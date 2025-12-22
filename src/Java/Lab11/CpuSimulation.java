package Java.Lab11;

import java.text.DecimalFormat;
import java.util.PriorityQueue;

public class CpuSimulation {
    final int total1, total2;
    final double inter1Low, inter1High, inter2Low, inter2High;
    final double s1Low, s1High, s2Low, s2High;

    PriorityQueue<Event> eventList = new PriorityQueue<>();
    CpuQueue queue1 = new CpuQueue();
    CpuQueue queue2 = new CpuQueue();
    Cpu cpu1 = new Cpu("CPU1");
    Cpu cpu2 = new Cpu("CPU2");

    double now = 0.0;
    int gen1 = 0, gen2 = 0;
    int completed1 = 0, completed2 = 0;
    int maxQueue1 = 0, maxQueue2 = 0;

    public CpuSimulation(int total1, int total2, double il1, double iu1, double s1l, double s1u,
                         double il2, double iu2, double s2l, double s2u) {
        this.total1 = total1;
        this.total2 = total2;
        inter1Low = il1;
        inter1High = iu1;
        s1Low = s1l;
        s1High = s1u;
        inter2Low = il2;
        inter2High = iu2;
        s2Low = s2l;
        s2High = s2u;
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

    CpuProcess makeProcess(int id, double arr, double low, double high) {
        return new CpuProcess(id, arr, uniform(low, high));
    }

    void schedule(Event e) {
        eventList.add(e);
    }

    void updateMax() {
        if (queue1.size() > maxQueue1) maxQueue1 = queue1.size();
        if (queue2.size() > maxQueue2) maxQueue2 = queue2.size();
    }

    public void run() {
        double t1 = uniform(inter1Low, inter1High);
        CpuProcess p1 = makeProcess(++gen1, t1, s1Low, s1High);
        schedule(new Event(t1, EventType.ARRIVAL1, p1));

        double t2 = uniform(inter2Low, inter2High);
        CpuProcess p2 = makeProcess(++gen2, t2, s2Low, s2High);
        schedule(new Event(t2, EventType.ARRIVAL2, p2));

        while (!eventList.isEmpty()) {
            Event ev = eventList.poll();
            now = ev.time;
            updateMax();

            switch (ev.type) {
                case ARRIVAL1 -> arrival(ev, queue1, cpu1, total1, gen1, inter1Low, inter1High, s1Low, s1High, EventType.ARRIVAL1);
                case ARRIVAL2 -> arrival(ev, queue2, cpu2, total2, gen2, inter2Low, inter2High, s2Low, s2High, EventType.ARRIVAL2);
                case FINISH1 -> finish(ev, cpu1, queue1, cpu2, queue2);
                case FINISH2 -> finish(ev, cpu2, queue2, cpu1, queue1);
            }
        }

        System.out.println();
        System.out.println("Итоги");
        System.out.println("Сгенерировано поток 1: " + gen1);
        System.out.println("Сгенерировано поток 2: " + gen2);
        System.out.println("Завершено поток 1: " + completed1);
        System.out.println("Завершено поток 2: " + completed2);
        System.out.println("Максимальная длина очереди 1: " + maxQueue1);
        System.out.println("Максимальная длина очереди 2: " + maxQueue2);
    }

    void arrival(Event ev, CpuQueue q, Cpu cpu, int total, int gen, double il, double iu, double sl, double su, EventType type) {
        CpuProcess p = ev.process;
        log("Появление " + p);
        q.enqueue(p);
        log("Добавлен в очередь: " + q);
        updateMax();

        if (gen < total) {
            double nextT = now + uniform(il, iu);
            CpuProcess nx = makeProcess(++gen, nextT, sl, su);
            schedule(new Event(nextT, type, nx));
            if (type == EventType.ARRIVAL1) this.gen1 = gen; else this.gen2 = gen;
            log("Запланировано появление " + nx + " в t=" + fmt(nextT));
        }

        if (!cpu.busy && !q.isEmpty()) {
            CpuProcess x = q.dequeue();
            x.start = now;
            cpu.busy = true;
            cpu.currentProcess = x;
            log(x + " начинает обработку на " + cpu.name);
            schedule(new Event(now + x.service, cpu == cpu1 ? EventType.FINISH1 : EventType.FINISH2, x));
        }
    }

    void finish(Event ev, Cpu cpu, CpuQueue ownQueue, Cpu otherCpu, CpuQueue otherQueue) {
        CpuProcess p = ev.process;
        p.finish = now;
        if (cpu == cpu1) completed1++; else completed2++;
        log(p + " завершён на " + cpu.name);
        cpu.busy = false;
        cpu.currentProcess = null;

        if (!ownQueue.isEmpty()) {
            CpuProcess x = ownQueue.dequeue();
            x.start = now;
            cpu.busy = true;
            cpu.currentProcess = x;
            log(x + " берётся из своей очереди на " + cpu.name);
            schedule(new Event(now + x.service, cpu == cpu1 ? EventType.FINISH1 : EventType.FINISH2, x));
        } else if (!otherQueue.isEmpty()) {
            CpuProcess x = otherQueue.dequeue();
            x.start = now;
            cpu.busy = true;
            cpu.currentProcess = x;
            log(x + " берётся из чужой очереди на " + cpu.name);
            schedule(new Event(now + x.service, cpu == cpu1 ? EventType.FINISH1 : EventType.FINISH2, x));
        }
    }
}
