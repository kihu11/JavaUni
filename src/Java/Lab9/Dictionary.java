package Java.Lab9;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Dictionary {

    private static final Map<String, String> cityCodes = new TreeMap<>();
//убрать static сделать через for
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

    public static void addCityIfAbsent(String code, String city) {
        cityCodes.putIfAbsent(code, city);
    }

    public static String getCityName(String code) {
        return cityCodes.getOrDefault(code, "Неизвестный город");
    }

    public static Collection<String> getAllCitiesCollection() {
        return Collections.unmodifiableCollection(cityCodes.values());
    }

    public static void showCitiesAndKeys() {
        Collection<String> cities = getAllCitiesCollection();
        int i = 1;
        for (String city : cities) {
            String code = getCodeByCity(city);
            System.out.printf("%d. %s — %s%n", i++, code, city);
        }
    }

    private static String getCodeByCity(String city) {
        for (Map.Entry<String, String> entry : cityCodes.entrySet()) {
            if (entry.getValue().equals(city)) {
                return entry.getKey();
            }
        }
        return "Неизвестно";
    }
}
