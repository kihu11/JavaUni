package Java.Lab9;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CallService {

    public static void showCalls(List<Call> calls) {
        System.out.println("\nСписок звонков:");
        for (int i = 0; i < calls.size(); i++) {
            System.out.println(i + ". " + calls.get(i));
        }
    }

    public static void addCall(List<Call> calls, Scanner sc, Dictionary dictionary) {
        Call newCall = new Call("", "", "", 0, 0, "", "");
        Call.set(newCall, sc);
        calls.add(newCall);
        System.out.println("Звонок добавлен\n");
    }

    public static void deleteCall(List<Call> calls, Scanner sc, Dictionary dictionary) {
        showCalls(calls);
        System.out.print("Введите индекс для удаления: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 0 && index < calls.size()) {
//            String cityCode = calls.get(index).getCityCode();
            calls.remove(index);
            System.out.println("Звонок удалён!");
        } else {
            System.out.println("Неверный индекс!");
        }
    }
}
