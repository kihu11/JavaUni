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

    public static void addCall(List<Call> calls, Scanner sc, Dictionary dictionary) {
        Call newCall = new Call("", "", "", 0, 0, "", "");
        set(newCall, sc);
        calls.add(newCall);

        dictionary.addCity(newCall.getCityCode(), newCall.getCityName());

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
}
