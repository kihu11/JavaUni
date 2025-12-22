package Java.Lab10.service;

import Java.Lab10.model.Product;

import java.io.*;

public class ProductFileWriter {

    private final File file;

    public ProductFileWriter(String filename) {
        this.file = new File(filename);
    }

        public void overwriteFile(Product[] products) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file, false)))) {
            for (Product p : products) {
                oos.writeObject(p);
            }
        }
    }

    public void appendProduct(Product product) throws IOException {
        boolean append = file.exists() && file.length() > 0;

        try (ObjectOutputStream oos = append ? new AppendableObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file, true)))
                : new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file, true)))) {

            oos.writeObject(product);
        }
    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }
        @Override
        protected void writeStreamHeader() {}
    }
}
