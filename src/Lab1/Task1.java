package Lab1;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читаем координаты первой клетки (например, "a1")
        String cell1 = scanner.next();
        // Читаем координаты второй клетки
        String cell2 = scanner.next();

        // Получаем цвет первой клетки
        boolean isBlack1 = isBlackCell(cell1);
        // Получаем цвет второй клетки
        boolean isBlack2 = isBlackCell(cell2);

        // Проверяем, одного ли цвета клетки
        if (isBlack1 == isBlack2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }

    // Метод для определения цвета клетки (true - черная, false - белая)
    private static boolean isBlackCell(String cell) {
        // Преобразуем букву в число: 'a'->1, 'b'->2, ..., 'h'->8
        int column = cell.charAt(0) - 'a' + 1;
        // Преобразуем цифру в число
        int row = Character.getNumericValue(cell.charAt(1));

        // Клетка черная, если сумма координат нечетная
        return (column + row) % 2 != 0;
    }
}