package Lab5;

public class Task2 {

    double x1, y1, x2, y2;

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

    public void printInfo() {
        double[] mid = getMidPoint();
        System.out.printf("Середина вектора: (%.2f, %.2f)%n", mid[0], mid[1]);
        if (isAngle45()) System.out.println("Угол наклона вектора равен 45°");
        else System.out.println("Угол наклона вектора НЕ равен 45°");
    }
}
