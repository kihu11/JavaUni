package Java.Lab9;

import java.util.*;

public class Dictionary {

    private final Map<String, String> cityCodes = new HashMap<>();

    public void addCity(String code, String city) {
        cityCodes.putIfAbsent(code, city);
    }

    public void showCities(List<Call> calls) {
        Map<String, Double> cityTotals = new HashMap<>();

        for (Call call : calls) {
            cityTotals.put(call.getCityCode(),
                    cityTotals.getOrDefault(call.getCityCode(), 0.0) + call.getValue());
        }

        int i = 1;
        for (Map.Entry<String, String> entry : cityCodes.entrySet()) {
            String code = entry.getKey();
            String city = entry.getValue();
            double total = cityTotals.getOrDefault(code, 0.0);
            System.out.printf("%d. %s — %s | Всего: %.2f руб.%n", i++, code, city, total);
        }
    }
}

//убрать лишний словарь
//1
