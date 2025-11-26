package Java.Lab10.service;

import Java.Lab10.model.Product;

import java.io.*;
import java.util.function.Consumer;

public class ProductFileReader {

    private final File file;

    public ProductFileReader(String filename) {
        this.file = new File(filename);
    }

    public void readAll(Consumer<Product> handler) throws IOException {
        if (!file.exists() || file.length() == 0) return;

        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file)))) {

            while (true) {
                try {
                    Product p = (Product) ois.readObject();
                    handler.accept(p);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new IOException("Ошибка чтения класса", e);
                }
            }
        }
    }
}
