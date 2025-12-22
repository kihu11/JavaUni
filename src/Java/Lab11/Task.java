package Java.Lab11;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Симуляция двух потоков процессов двумя CPU");

        System.out.print("Количество процессов для потока 1: ");
        int total1 = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Интервал появления потока 1: нижняя граница: ");
        double il1 = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Интервал появления потока 1: верхняя граница: ");
        double iu1 = Double.parseDouble(sc.nextLine().trim());
        System.out.print("CPU1: нижняя граница обслуживания: ");
        double s1l = Double.parseDouble(sc.nextLine().trim());
        System.out.print("CPU1: верхняя граница обслуживания: ");
        double s1u = Double.parseDouble(sc.nextLine().trim());

        System.out.print("Количество процессов для потока 2: ");
        int total2 = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Интервал появления потока 2: нижняя граница: ");
        double il2 = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Интервал появления потока 2: верхняя граница: ");
        double iu2 = Double.parseDouble(sc.nextLine().trim());
        System.out.print("CPU2: нижняя граница обслуживания: ");
        double s2l = Double.parseDouble(sc.nextLine().trim());
        System.out.print("CPU2: верхняя граница обслуживания: ");
        double s2u = Double.parseDouble(sc.nextLine().trim());

        CpuSimulation sim = new CpuSimulation(total1, total2, il1, iu1, s1l, s1u, il2, iu2, s2l, s2u);
        sim.run();
    }
}
