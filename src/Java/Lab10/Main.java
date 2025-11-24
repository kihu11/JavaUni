package Java.Lab10;
import Java.Lab10.model.Product;
import Java.Lab10.service.ProductFileReader;
import Java.Lab10.service.ProductFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String FILENAME = "products.bin";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        ProductFileWriter writer = new ProductFileWriter(FILENAME);
        ProductFileReader reader = new ProductFileReader(FILENAME);

        while (true) {
            System.out.println("1. Первичное заполнение файла (стирает старые данные)");
            System.out.println("2. Показать все элементы файла");
            System.out.println("3. Добавить элемент");
            System.out.println("4. Рассчитать общую стоимость и среднюю цену");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> {
                    System.out.println("\nСоздание нового списка (старые данные удаляются)");

                    Product[] arr = new Product[]{
                            new Product("Молоко", 70, 10),
                            new Product("Хлеб", 30, 20),
                            new Product("Сахар", 55, 15),
                    };

                    writer.overwriteFile(arr);
                    System.out.println("Файл успешно создан и заполнен.");
                }

                case 2 -> {
                    System.out.println("\nСписок товаров:");

                    reader.readAll(p ->
                            System.out.println(p)
                    );
                }

                case 3 -> {
                    System.out.println("Введите наименование:");
                    String name = scanner.nextLine();

                    System.out.println("Введите цену:");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.println("Введите количество:");
                    int qty = Integer.parseInt(scanner.nextLine());

                    writer.appendProduct(new Product(name, price, qty));
                    System.out.println("Товар добавлен!");
                }

                case 4 -> {
                    List<Product> list = new ArrayList<>();

                    reader.readAll(list::add);

                    if (list.isEmpty()) {
                        System.out.println("Файл пуст.");
                        break;
                    }

                    double total = list.stream().mapToDouble(Product::totalCost).sum();
                    double avg = list.stream().mapToDouble(Product::getPrice).average().orElse(0);

                    System.out.printf("Общая стоимость всего товара: %.2f%n", total);
                    System.out.printf("Средняя цена единицы товара: %.2f%n", avg);
                }

                case 0 -> {
                    System.out.println("До свидания!");
                    return;
                }

                default -> System.out.println("Неверный выбор!");
            }
        }
    }
}
