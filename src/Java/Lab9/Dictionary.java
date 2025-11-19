package Java.Lab9;

import java.util.*;

public class Dictionary {

    public void showCities(List<Call> calls) {

        // карта: код города → {название, сумма}
        Map<String, CityInfo> cityMap = new LinkedHashMap<>();

        for (Call call : calls) {
            String code = call.getCityCode();
            String city = call.getCityName();
            double value = call.getValue();

            cityMap.putIfAbsent(code, new CityInfo(city, 0));
            cityMap.get(code).total += value;
        }

        int i = 1;
        for (Map.Entry<String, CityInfo> entry : cityMap.entrySet()) {
            String code = entry.getKey();
            CityInfo info = entry.getValue();
            System.out.printf("%d. %s — %s | Всего: %.2f руб.%n",
                    i++, code, info.name, info.total);
        }
    }

    private static class CityInfo {
        String name;
        double total;

        CityInfo(String name, double total) {
            this.name = name;
            this.total = total;
        }
    }
}
//1