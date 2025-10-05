package Lab3;
public class Task {
    public static void main(String[] args) {
        int[] array = {0, 0, 1, 2, 4, 0, 5};

        System.out.println("Массив до:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();


        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 3;
                if (i > 0 && i - 1 != 0) array[i - 1] = 3;
                if (i < array.length - 1 && array[i + 1] != 0) array[i + 1] = 3;
            }
        }

        System.out.println("Массив после: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}