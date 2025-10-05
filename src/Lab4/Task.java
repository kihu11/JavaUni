package Lab4;

public class Task {

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {2, 3, 5, 6},
                {3, 7, 2, 9}
        };

        printMatrix(matrix);

        System.out.print("Числа в каждой строке: ");
        boolean foundAny = false;

        for (int num = 1; num <= 9; num++) {
            boolean inAllRows = true;

            for (int i = 0; i < matrix.length; i++) {
                boolean foundInRow = false;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == num) {
                        foundInRow = true;
                        break;
                    }
                }
                if (!foundInRow) {
                    inAllRows = false;
                    break;
                }
            }

            if (inAllRows) {
                if (foundAny) {
                    System.out.print(", ");
                }
                System.out.print(num);
                foundAny = true;
            }
        }
    }
}