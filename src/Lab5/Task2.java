package Lab5;

public class Task2 {

    private double x1, y1, x2, y2;

    public Task2() {
    }

    public Task2(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double[] getMidPoint() {
        double midX = (x1 + x2) / 2.0;
        double midY = (y1 + y2) / 2.0;
        return new double[]{midX, midY};
    }

    public boolean isAngle45() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        if (dx == 0) return false;
        double angleDegrees = Math.toDegrees(Math.atan(dy / dx));
        return Math.abs(angleDegrees - 45.0) < 1e-6;
    }

    @Override
    public String toString() {
        return "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task2 task2 = (Task2) o;
        return Double.compare(x1, task2.x1) == 0 &&
                Double.compare(y1, task2.y1) == 0 &&
                Double.compare(x2, task2.x2) == 0 &&
                Double.compare(y2, task2.y2) == 0;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }
}
