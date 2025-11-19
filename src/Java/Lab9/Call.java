package Java.Lab9;

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

    public String getCityKey() {
        return cityCode + " " + cityName;
    }

    public double getValue(){
        return duration * rate;
    }

    public double getCost() {
        return duration * rate;
    }

    public double getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public double getRate() {
        return rate;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public String getSubscriberNumber() {
        return subscriberNumber;
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
