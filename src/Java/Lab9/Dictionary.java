package Java.Lab9;

import java.util.*;

public class Dictionary {

    public void showCities(List<Call> calls) {

        Map<String, Double> cityMap = new HashMap<>();

        for (Call call : calls) {
            String key = call.getCityCode() + " " + call.getCityName();
            double value = call.getValue();

            cityMap.put(key, cityMap.getOrDefault(key, 0.0) + value);
        }

        int i = 1;
        for (Map.Entry<String, Double> entry : cityMap.entrySet()) {
            System.out.printf("%d. %s | Всего: %.2f руб.%n", i++, entry.getKey(), entry.getValue());
        }
    }


    private static class CityInfo {
        String name;
        double total;

        CityInfo(String name, double total) {
            this.total = total;
            this.name = name;
        }
    }
}
//1