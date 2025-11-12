package Java.Lab9;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Dictionary {
    private static final Map<String, String> cityCodes = new HashMap<>();

    static {
        cityCodes.put("044", "Киев");
        cityCodes.put("032", "Львов");
        cityCodes.put("048", "Одесса");
        cityCodes.put("057", "Харьков");
        cityCodes.put("0352", "Тернополь");
        cityCodes.put("061", "Запорожье");
        cityCodes.put("0362", "Ровно");
        cityCodes.put("0342", "Ивано-Франковск");
        cityCodes.put("0372", "Черновцы");
        cityCodes.put("045", "Бровары");
        cityCodes.put("062", "Донецк");
    }

    public static void showDictionary() {
        System.out.println("\nСловарь кодов городов:");
        var keys = new ArrayList<>(cityCodes.keySet());
        for (int i = 0; i < keys.size(); i++) {
            String code = keys.get(i);
            String city = cityCodes.get(code);
            System.out.printf("%d. %s — %s%n", i + 1, code, city);
        }
        System.out.println();
    }
    public static void addCityIfAbsent(String code, String city) {
        cityCodes.putIfAbsent(code, city);
    }
}
