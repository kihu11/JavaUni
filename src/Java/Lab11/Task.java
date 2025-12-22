package Java.Lab11;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Процессов поток 1: ");
        int total1 = sc.nextInt();
        System.out.print("Процессов поток 2: ");
        int total2 = sc.nextInt();

        CpuQueue q1 = new CpuQueue();
        CpuQueue q2 = new CpuQueue();

        Generator g1 = new Generator(q1, total1, 0.5, 1.5, 0.5, 2.0);
        Generator g2 = new Generator(q2, total2, 0.5, 1.5, 0.5, 2.0);

        Cpu cpu1 = new Cpu("CPU1", q1);
        Cpu cpu2 = new Cpu("CPU2", q2);

        cpu1.setOtherQueue(q2);
        cpu2.setOtherQueue(q1);

        g1.start();
        g2.start();
        cpu1.start();
        cpu2.start();

        g1.join();
        g2.join();

        Thread.sleep(5000);

        cpu1.shutdown();
        cpu2.shutdown();

        System.out.println("\nИтоги:");
        System.out.println("Максимальная очередь 1: " + q1.getMaxSize());
        System.out.println("Максимальная очередь 2: " + q2.getMaxSize());
    }
}
