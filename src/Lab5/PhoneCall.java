package Lab5;

import java.util.Scanner;

public class PhoneCall {
    public static void main(String[] args) {

        Task1[] calls = new Task1[4];
        Scanner sc = new Scanner(System.in);
        calls[0]=new Task1();
        calls[0].setDuration(-1);
        calls[0].setPricePerMinute(-1);
        System.out.println(calls[0]);

        calls[0].getDuration();

        for (int i = 0; i < calls.length; i++) {
            System.out.println("Создания звонка N " + (i + 1));

            int duration;

            do {
                System.out.println("Введите продолжительность звонка: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Введите целое число");
                    sc.next();
                }
                duration = sc.nextInt();
            } while (duration <= 0);

            double price;

            do {
                System.out.println("Введите цену в минуту: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Введите число");
                    sc.next();
                }
                price = sc.nextDouble();
            } while (price <= 0);

            if (i % 2 == 0) {
                calls[i] = new Task1(duration, price);
            } else {
                calls[i] = new Task1();
                calls[i].setDuration(duration);
                calls[i].setPricePerMinute(price);
            }
        }


        System.out.println("Список звонков");
        for (Task1 call : calls) {
            System.out.println(call);
          //  System.out.println("Цена звонка: " + call.calculatePrice());
        }

        System.out.println("Равенство звонков");
        System.out.println("1й и 2й: " + calls[0].equals(calls[1]));
        System.out.println("1й и 3й: " + calls[0].equals(calls[2]));
        System.out.println("2й и 3й: " + calls[1].equals(calls[2]));
    }
}
