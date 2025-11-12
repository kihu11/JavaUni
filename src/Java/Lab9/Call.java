package Java.Lab9;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Call {
    private String date;
    private String cityCode;
    private String cityName;
    private double duration;
    private double rate;
    private String localNumber;
    private String subscriberNumber;

    public Call(String date, String cityCode, String cityName, double duration, double rate,
                String localNumber, String subscriberNumber) {
        this.date = date;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.duration = duration;
        this.rate = rate;
        this.localNumber = localNumber;
        this.subscriberNumber = subscriberNumber;
    }

    public void set(Scanner sc) {
        System.out.println("\nОпишите звонок");

        System.out.print("Дата (yyyy-mm-dd): ");
        setDate(sc.nextLine());

        System.out.print("Код города: ");
        setCityCode(sc.nextLine());

        System.out.print("Название города: ");
        setCityName(sc.nextLine());

        System.out.print("Время разговора (мин): ");
        setDuration(Double.parseDouble(sc.nextLine()));

        System.out.print("Тариф (руб/мин): ");
        setRate(Double.parseDouble(sc.nextLine()));

        System.out.print("Номер в городе: ");
        setLocalNumber(sc.nextLine());

        System.out.print("Номер абонента: ");
        setSubscriberNumber(sc.nextLine());
    }

    public static void addCall(List<Call> calls, Scanner sc) {
        Call newCall = new Call("", "", "", 0, 0, "", "");
        newCall.set(sc);
        calls.add(newCall);
        System.out.println("Звонок добавлен\n");
    }

    public static void showCalls(List<Call> calls) {
        System.out.println("\nСписок звонков:");
        for (int i = 1; i < calls.size(); i++) {
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

        for (int i = 0; i < calls.size(); i++) {
            Call call = calls.get(i);
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


    public String getCityKey() {
        return cityCode + " " + cityName;
    }

    public double getCost() {
        return duration * rate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public void setSubscriberNumber(String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    @Override
    public String toString() {
        return "Call{" +
                "date='" + date + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", duration=" + duration +
                ", rate=" + rate +
                ", localNumber='" + localNumber + '\'' +
                ", subscriberNumber='" + subscriberNumber + '\'' +
                '}';
    }
}
//распихать методы в другой класс