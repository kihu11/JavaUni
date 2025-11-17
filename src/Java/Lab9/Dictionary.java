package Java.Lab9;

import java.util.*;

public class Dictionary {

    private final Map<String, String> cityCodes = new HashMap<>();

    public void addCity(String code, String city) {
        cityCodes.putIfAbsent(code, city);
    }

    public String getCityName(String code) {
        return cityCodes.getOrDefault(code, "Неизвестный город");
    }

    public void showCities() {
        int i = 1;
        for (Map.Entry<String, String> entry : cityCodes.entrySet()) {
            System.out.printf("%d. %s — %s%n", i++, entry.getKey(), entry.getValue());
        }
    }
}
