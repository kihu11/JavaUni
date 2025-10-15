package Lab5;

public class Task1 {

    private int duration;
    private double pricePerMinute;

    public Task1() {
        this(1, 1);
    }

    public Task1(int duration, double pricePerMinute) {
        setDuration(duration);
        setPricePerMinute(pricePerMinute);
    }

    public double calculatePrice() {
        return getDuration() * getPricePerMinute();
    }

    public int getDuration() {
        return duration;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            System.out.println("Продолжительность должна быть положительной. Переменной присвоено значение 1. Программа продолжается.");
            this.duration = 1;
            return;
        }
        this.duration = duration;
    }

    public void setPricePerMinute(double pricePerMinute) {
        if (pricePerMinute <= 0) {
            System.out.println("Цена в минуту  должна быть положительной. Переменной присвоено значение 1. Программа продолжается.");
            this.pricePerMinute = 1;
            return;
        }
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task1 task1 = (Task1) o;
        return getDuration() == task1.getDuration() &&
                Double.compare(getPricePerMinute(), task1.getPricePerMinute()) == 0;
    }

    @Override
    public String toString() {
        return "Продолжительность = " + getDuration() +
                ", Цена в минуту = " + getPricePerMinute();
    }
}
