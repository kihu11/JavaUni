package Java.Lab11;

public class Cpu extends Thread {
    private final String name;
    private final CpuQueue ownQueue;
    private CpuQueue otherQueue;
    private volatile boolean running = true;

    public Cpu(String name, CpuQueue ownQueue) {
        this.name = name;
        this.ownQueue = ownQueue;
    }

    public void setOtherQueue(CpuQueue otherQueue) {
        this.otherQueue = otherQueue;
    }

    public void shutdown() {
        running = false;
        interrupt();
    }

    @Override
    public void run() {
        try {
            while (running) {
                CpuProcess p;

                if (!ownQueue.isEmpty()) {
                    p = ownQueue.dequeue();
                    log("взял процесс " + p + " из своей очереди");
                } else if (!otherQueue.isEmpty()) {
                    p = otherQueue.dequeue();
                    log("взял процесс " + p + " из ЧУЖОЙ очереди");
                } else {
                    Thread.sleep(10);
                    continue;
                }

                log("начал обслуживание " + p);
                Thread.sleep((long) (p.service * 1000));
                log("завершил обслуживание " + p);
            }
        } catch (InterruptedException ignored) {
        }
    }

    private void log(String msg) {
        System.out.println("[" + name + "] " + msg);
    }
}
