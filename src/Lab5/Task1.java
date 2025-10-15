package Lab5;

public class Task1 {

    private int duration;
    private double pricePerMinute;

    public Task1() {
       this(1,1);
//        this.duration = 1;
//        this.pricePerMinute = 1.0;
    }

    public Task1(int duration, double pricePerMinute) {
        setDuration(duration);
        setPricePerMinute(pricePerMinute);
    }

    public int getDuration() {
        return duration;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            System.out.println("Продолжительность должна быть положительной. Программа продолжается.");
            return;
        }
        this.duration = duration;
    }

    public void setPricePerMinute(double pricePerMinute) {
        if (pricePerMinute <= 0) {
            System.out.println("Цена в минуту должна быть положительной. Программа продолжается.");
            return;
        }
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task1 task1 = (Task1) o;
        return duration == task1.duration &&
                Double.compare(pricePerMinute, task1.pricePerMinute) == 0;
    }

    @Override
    public String toString() {
        return "Продолжительность = " + duration +
                ", Цена в минуту = " + pricePerMinute;
    }
}
