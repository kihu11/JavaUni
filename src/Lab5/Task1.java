package Lab5;//18

public class Task1 {

    int duration;
    double pricePerMinute;

    public Task1(int duration, double pricePerMinute) {

        this.duration = duration;
        this.pricePerMinute = pricePerMinute;
    }

    public static void calculatePrice(double duration, double pricePerMinute){

        double result = duration * pricePerMinute;
        System.out.println("Цена за разговор: " + result);
    }
}



