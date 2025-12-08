package Java.Lab11;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Симуляция обслуживания одним потоком, одной очередью и двумя CPU");

        System.out.print("Количество процессов: ");
        int total = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Интервал появления: нижняя граница: ");
        double il = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Интервал появления: верхняя граница: ");
        double iu = Double.parseDouble(sc.nextLine().trim());
        System.out.print("CPU1: нижняя граница обслуживания: ");
        double s1l = Double.parseDouble(sc.nextLine().trim());
        System.out.print("CPU1: верхняя граница: ");
        double s1u = Double.parseDouble(sc.nextLine().trim());
        System.out.print("CPU2: нижняя граница обслуживания: ");
        double s2l = Double.parseDouble(sc.nextLine().trim());
        System.out.print("CPU2: верхняя граница: ");
        double s2u = Double.parseDouble(sc.nextLine().trim());

        CpuSimulation sim = new CpuSimulation(total, il, iu, s1l, s1u, s2l, s2u);
        sim.run();
    }
}
