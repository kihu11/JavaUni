package Lab5;

public class PhoneCall {
    public static void main(String[] args) {

        Task1 first = new Task1(4, 0.8);
        Task1 second = new Task1(10, 0.4);

        Task1.calculatePrice(first.duration, first.pricePerMinute);
        Task1.calculatePrice(second.duration, second.pricePerMinute);
    }
}
