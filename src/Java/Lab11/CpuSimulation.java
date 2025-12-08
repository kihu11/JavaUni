package Java.Lab11;

import java.util.*;
import java.text.DecimalFormat;

public class CpuSimulation {
    final int totalToGenerate;
    final double interLower, interUpper;
    final double s1Lower, s1Upper;
    final double s2Lower, s2Upper;

    PriorityQueue<Event> eventList = new PriorityQueue<>();
    CpuQueue queue = new CpuQueue();
    Cpu cpu1 = new Cpu("CPU1");
    Cpu cpu2 = new Cpu("CPU2");

    double now = 0.0;
    int generatedCount = 0;
    int completedCount = 0;
    int maxQueue = 0;

    public CpuSimulation(int total, double il, double iu, double s1l, double s1u, double s2l, double s2u) {
        totalToGenerate = total;
        interLower = il;
        interUpper = iu;
        s1Lower = s1l;
        s1Upper = s1u;
        s2Lower = s2l;
        s2Upper = s2u;
    }

    void log(String s) {
        System.out.println("t=" + fmt(now) + " : " + s);
    }

    static double uniform(double low, double high) {
        return low + Math.random() * (high - low);
    }

    static String fmt(double t) {
        return new DecimalFormat("#0.000").format(t);
    }

    CpuProcess makeProcess(int id, double arr) {
        return new CpuProcess(id, arr,
                uniform(s1Lower, s1Upper),
                uniform(s2Lower, s2Upper));
    }

    void schedule(Event e) {
        eventList.add(e);
    }

    void updateMax() {
        if (queue.size() > maxQueue) maxQueue = queue.size();
    }

    public void run() {
        double t0 = uniform(interLower, interUpper);
        CpuProcess p0 = makeProcess(++generatedCount, t0);
        schedule(new Event(t0, EventType.ARRIVAL, p0));
        log("Запланировано появление " + p0 + " в t=" + fmt(t0));

        while (!eventList.isEmpty()) {
            Event ev = eventList.poll();
            now = ev.time;
            updateMax();

            switch (ev.type) {
                case ARRIVAL -> arrival(ev);
                case FINISH1 -> finish1(ev);
                case FINISH2 -> finish2(ev);
            }

            if (completedCount >= totalToGenerate && eventList.isEmpty()) break;
        }

        System.out.println();
        System.out.println("Итоги");
        System.out.println("Сгенерировано: " + generatedCount);
        System.out.println("Завершено: " + completedCount);
        System.out.println("Максимальная длина очереди: " + maxQueue);
    }

    void arrival(Event ev) {
        CpuProcess p = ev.process;
        log("Появление " + p);
        queue.enqueue(p);
        log("Добавлен в очередь: " + queue);
        updateMax();

        if (generatedCount < totalToGenerate) {
            double nextT = now + uniform(interLower, interUpper);
            CpuProcess nx = makeProcess(++generatedCount, nextT);
            schedule(new Event(nextT, EventType.ARRIVAL, nx));
            log("Запланировано появление " + nx + " в t=" + fmt(nextT));
        }

        if (!cpu1.busy && cpu1.blockedProcess == null && !queue.isEmpty()) {
            CpuProcess x = queue.dequeue();
            x.start1 = now;
            cpu1.busy = true;
            log(x + " начинает обработку на CPU1");
            schedule(new Event(now + x.service1, EventType.FINISH1, x));
        } else {
            if (cpu1.blockedProcess != null) log("CPU1 блокирован, " + p + " остаётся в очереди");
            else if (cpu1.busy) log("CPU1 занят, " + p + " остаётся в очереди");
        }
    }

    void finish1(Event ev) {
        CpuProcess p = ev.process;
        p.finish1 = now;
        log(p + " завершил обработку на CPU1");

        if (!cpu2.busy) {
            p.start2 = now;
            cpu2.busy = true;
            schedule(new Event(now + p.service2, EventType.FINISH2, p));
            log(p + " передан на CPU2");

            cpu1.busy = false;
            if (!queue.isEmpty()) {
                CpuProcess x = queue.dequeue();
                x.start1 = now;
                cpu1.busy = true;
                schedule(new Event(now + x.service1, EventType.FINISH1, x));
                log("CPU1 берёт " + x + " из очереди");
            } else log("Очередь пуста, CPU1 свободен");

        } else {
            cpu1.blockedProcess = p;
            cpu1.busy = true;
            log("CPU2 занят, CPU1 удерживает " + p);
        }
    }

    void finish2(Event ev) {
        CpuProcess p = ev.process;
        p.finish2 = now;
        completedCount++;
        log(p + " завершён полностью");

        cpu2.busy = false;

        if (cpu1.blockedProcess != null) {
            CpuProcess h = cpu1.blockedProcess;
            cpu1.blockedProcess = null;
            h.start2 = now;
            cpu2.busy = true;
            schedule(new Event(now + h.service2, EventType.FINISH2, h));
            log("CPU1 передаёт удерживаемый " + h + " на CPU2");

            cpu1.busy = false;
            if (!queue.isEmpty()) {
                CpuProcess x = queue.dequeue();
                x.start1 = now;
                cpu1.busy = true;
                schedule(new Event(now + x.service1, EventType.FINISH1, x));
                log("CPU1 берёт " + x + " после передачи удерживаемого");
            } else log("Очередь пуста, CPU1 свободен");

        } else {
            log("CPU2 свободен, удерживаемых процессов нет");
        }
    }
}
