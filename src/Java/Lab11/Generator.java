package Java.Lab11;

public class Generator extends Thread {
    private final CpuQueue queue;
    private final int total;
    private final double interLow, interHigh;
    private final double servLow, servHigh;

    public Generator(CpuQueue queue, int total,
                     double interLow, double interHigh,
                     double servLow, double servHigh) {
        this.queue = queue;
        this.total = total;
        this.interLow = interLow;
        this.interHigh = interHigh;
        this.servLow = servLow;
        this.servHigh = servHigh;
    }

    private double rnd(double l, double h) {
        return l + Math.random() * (h - l);
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= total; i++) {
                Thread.sleep((long) (rnd(interLow, interHigh) * 1000));
                CpuProcess p = new CpuProcess(i, rnd(servLow, servHigh));
                queue.enqueue(p);
                System.out.println("[GEN] сгенерирован " + p);
            }
        } catch (InterruptedException ignored) {
        }
    }
}
