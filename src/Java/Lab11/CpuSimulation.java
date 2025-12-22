package Java.Lab11;

public class CpuSimulation {

    private final CpuQueue queue1 = new CpuQueue();
    private final CpuQueue queue2 = new CpuQueue();

    private final Generator gen1;
    private final Generator gen2;

    private final Cpu cpu1;
    private final Cpu cpu2;

    public CpuSimulation(
            int total1, double il1, double iu1, double s1l, double s1u,
            int total2, double il2, double iu2, double s2l, double s2u
    ) {
        gen1 = new Generator(queue1, total1, il1, iu1, s1l, s1u);
        gen2 = new Generator(queue2, total2, il2, iu2, s2l, s2u);

        cpu1 = new Cpu("CPU1", queue1);
        cpu2 = new Cpu("CPU2", queue2);

        cpu1.setOtherQueue(queue2);
        cpu2.setOtherQueue(queue1);
    }

    public void runSimulation() throws InterruptedException {
        System.out.println("=== Запуск многопоточной симуляции ===");

        gen1.start();
        gen2.start();

        cpu1.start();
        cpu2.start();

        gen1.join();
        gen2.join();

        Thread.sleep(3000);

        cpu1.shutdown();
        cpu2.shutdown();

        System.out.println("\n=== Итоги ===");
        System.out.println("Максимальная длина очереди 1: " + queue1.getMaxSize());
        System.out.println("Максимальная длина очереди 2: " + queue2.getMaxSize());
    }
}
