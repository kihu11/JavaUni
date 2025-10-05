package Lab1;
import java.util.Scanner;
import java.lang.Math;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод значения x с консоли
        System.out.print("Введите действительное значение переменной x: ");
        double x = scanner.nextDouble();
        System.out.println("Вы ввели x = " + x);
        System.out.println();

        // Массив параметров (три варианта)
        double[][] parameters = {
                {7.2, -1.3, 2.5},    // Вариант 1
                {1.47, 3.8, 2.8},     // Вариант 2
                {4.8, 10.6, 2.7}      // Вариант 3
        };

        System.out.println("Результаты вычисления функции y(x):");
        System.out.println("№\tПараметры (a,b,c)\t\ty(x)");
        System.out.println("------------------------------------------------");

        // Вычисление функции для каждого варианта параметров
        for (int i = 0; i < parameters.length; i++) {
            double a = parameters[i][0];
            double b = parameters[i][1];
            double c = parameters[i][2];

            double y = calculateFunction(x, a, b, c);

            System.out.printf("%d\t(%.2f, %.2f, %.2f)\t\t%.6f%n",
                    i + 1, a, b, c, y);
        }

        scanner.close();
    }

    // Функция для вычисления y(x) по заданным правилам
    public static double calculateFunction(double x, double a, double b, double c) {
        double sum = a + b;

        if (sum > x) {
            // Первый случай: sin(e^(a+b)) + x^2
            return Math.sin(Math.exp(sum)) + Math.pow(x, 2);
        }
        else if (sum == x) {
            // Второй случай: arctg(a*b*c) + корень кубический из x
            return Math.atan(a * b * c) + Math.cbrt(x);
        }
        else {
            // Третий случай: arcsin(cos^2(sqrt(|x|)))
            double cosSquared = Math.pow(Math.cos(Math.sqrt(Math.abs(x))), 2);
            // Обеспечиваем, чтобы аргумент arcsin был в допустимом диапазоне [-1, 1]
            if (cosSquared > 1.0) cosSquared = 1.0;
            if (cosSquared < -1.0) cosSquared = -1.0;
            return Math.asin(cosSquared);
        }
    }
}