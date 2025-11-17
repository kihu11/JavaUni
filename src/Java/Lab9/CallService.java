package Java.Lab9;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CallService {

    public static void set(Call call, Scanner sc) {
        System.out.println("\nОпишите звонок");

        System.out.print("Дата (yyyy-mm-dd): ");
        call.setDate(sc.nextLine());

        System.out.print("Код города: ");
        call.setCityCode(sc.nextLine());

        System.out.print("Название города: ");
        call.setCityName(sc.nextLine());

        System.out.print("Время разговора (мин): ");
        call.setDuration(Double.parseDouble(sc.nextLine()));

        System.out.print("Тариф (руб/мин): ");
        call.setRate(Double.parseDouble(sc.nextLine()));

        System.out.print("Номер в городе: ");
        call.setLocalNumber(sc.nextLine());

        System.out.print("Номер абонента: ");
        call.setSubscriberNumber(sc.nextLine());
    }

    public static void addCall(List<Call> calls, Scanner sc) {
        Call newCall = new Call("", "", "", 0, 0, "", "");
        set(newCall, sc);
        calls.add(newCall);
//        Dictionary.addCityIfAbsent(newCall.getCityCode(), newCall.getCityName());
        System.out.println("Звонок добавлен\n");
    }

    public static void showCalls(List<Call> calls) {
        System.out.println("\nСписок звонков:");
        for (int i = 0; i < calls.size(); i++) {
            System.out.println(i + ". " + calls.get(i));
        }
    }

    public static void deleteCall(List<Call> calls, Scanner sc) {
        showCalls(calls);
        System.out.print("Введите индекс для удаления: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 0 && index < calls.size()) {
            calls.remove(index);
            System.out.println("Звонок удалён!");
        } else {
            System.out.println("Неверный индекс!");
        }
    }

    public static void showSummary(List<Call> calls) {
        calls.sort(Comparator.comparing(Call::getCityKey));

        System.out.println("\nИтоги по городам:");
        String currentCity = "";
        double totalDuration = 0;
        double totalCost = 0;

        for (Call call : calls) {
            if (!call.getCityKey().equals(currentCity)) {
                if (!currentCity.isEmpty()) {
                    System.out.printf("%-20s | Общее время: %2.1f мин | Сумма: %4.2f руб%n",
                            currentCity, totalDuration, totalCost);
                }
                currentCity = call.getCityKey();
                totalDuration = 0;
                totalCost = 0;
            }
            totalDuration += call.getDuration();
            totalCost += call.getCost();
        }

        if (!currentCity.isEmpty()) {
            System.out.printf("%-20s | Общее время: %2.1f мин | Сумма: %4.2f руб%n",
                    currentCity, totalDuration, totalCost);
        }
        System.out.println();
    }
}
