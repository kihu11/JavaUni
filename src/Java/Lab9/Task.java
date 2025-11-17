package Java.Lab9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Call> calls = new ArrayList<>(Arrays.asList(
                new Call("2025-11-01", "044", "Киев", 12.5, 1.5, "111-111", "222-222"),
                new Call("2025-11-02", "032", "Львов", 8.0, 2.0, "333-333", "444-444"),
                new Call("2025-11-03", "048", "Одесса", 5.2, 1.7, "555-555", "666-666"),
                new Call("2025-11-04", "057", "Харьков", 9.0, 1.8, "777-777", "888-888"),
                new Call("2025-11-05", "0352", "Тернополь", 10.0, 1.6, "999-999", "111-000"),
                new Call("2025-11-06", "044", "Киев", 15.0, 1.5, "222-111", "333-000"),
                new Call("2025-11-06", "032", "Львов", 7.3, 2.0, "444-111", "555-000"),
                new Call("2025-11-07", "061", "Запорожье", 11.0, 1.9, "666-111", "777-000"),
                new Call("2025-11-08", "048", "Одесса", 20.0, 1.7, "888-111", "999-000"),
                new Call("2025-11-08", "0362", "Ровно", 6.2, 1.4, "101-101", "202-202"),
                new Call("2025-11-09", "0342", "Ивано-Франковск", 5.5, 2.3, "303-303", "404-404"),
                new Call("2025-11-09", "0372", "Черновцы", 9.1, 1.9, "505-505", "606-606"),
                new Call("2025-11-09", "044", "Киев", 4.5, 1.5, "707-707", "808-808"),
                new Call("2025-11-10", "045", "Бровары", 3.0, 1.6, "909-909", "010-010"),
                new Call("2025-11-10", "062", "Донецк", 13.0, 1.8, "111-222", "333-444"),
                new Call("2025-11-10", "061", "Запорожье", 6.5, 1.9, "555-666", "777-888"),
                new Call("2025-11-10", "048", "Одесса", 10.5, 1.7, "999-000", "111-222")
        ));

        Dictionary dictionary = new Dictionary();

        for (Call call : calls) {
            dictionary.addCity(call.getCityCode(), call.getCityName());
        }

        while (true) {
            System.out.println(
                    "Выберите пункт меню:\n" +
                            "0. выход\n" +
                            "1. Показать все звонки\n" +
                            "2. Добавить звонок\n" +
                            "3. Изменить звонок\n" +
                            "4. Удалить звонок\n" +
                            "5. Словарь\n"
            );

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0)
                break;

            switch (choice) {
                case 1 -> CallService.showCalls(calls);
                case 2 -> CallService.addCall(calls, scanner, dictionary);
                case 3 -> {
                    System.out.print("Введите индекс звонка (0-" + (calls.size() - 1) + "): ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    if (index >= 0 && index < calls.size()) {
                        CallService.set(calls.get(index), scanner);
                    } else {
                        System.out.println("Неверный индекс");
                    }
                }
                case 4 -> CallService.deleteCall(calls, scanner);
                case 5 -> dictionary.showCities();
            }
        }
    }
}
