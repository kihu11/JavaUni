package Lab5;

public class Vectors {
    public static void main(String[] args) {

        Task2[] vectors = new Task2[4];

        vectors[0] = new Task2(0, 0, -2, -2);      // угол 45
        vectors[2] = new Task2(1, 1, 4, 2);      // угол 45

        vectors[1] = new Task2();
        vectors[1].setX1(0);
        vectors[1].setY1(0);
        vectors[1].setX2(1);
        vectors[1].setY2(1);                    // угол 45

        vectors[3] = new Task2();
        vectors[3].setX1(1);
        vectors[3].setY1(2);
        vectors[3].setX2(5);
        vectors[3].setY2(6);                    // не 45

        System.out.println("Список векторов:");
        for (Task2 i : vectors) {
            System.out.println(i);

            double[] mid = i.getMidPoint();
            System.out.printf("Середина: (%.1f, %.1f)%n", mid[0], mid[1]);

            if (i.isAngle45())
                System.out.println("Угол 45");
            else
                System.out.println("Угол не 45");

            System.out.println();
        }

        System.out.println("Равенство векторов:");
        System.out.println("1 и 2: " + vectors[0].equals(vectors[1]));
        System.out.println("1 и 3: " + vectors[0].equals(vectors[2]));
        //System.out.println("2 и 3: " + vectors[1].equals(vectors[2]));
    }
}
