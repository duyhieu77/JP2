package Service;

import Entity.Product;
import Entity.Statistic;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public List<Product> readFile(String filePath) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String[] data = line.split(";");
                products.add(new Product(
                        Integer.parseInt(data[0].trim()),
                        Integer.parseInt(data[1].trim()),
                        Integer.parseInt(data[2].trim()),
                        Integer.parseInt(data[3].trim()),
                        LocalDate.parse(data[4].trim())
                ));
            }
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        return products;
    }

    public void writeFile(String filePath, List<Statistic> statistics) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write("ProductId; %Click; %AddToCart; %CheckOut; Date");
            writer.newLine();
            for (Statistic stat : statistics) {
                writer.write(stat.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public List<Statistic> PercentageStatistics(List<Product> products) {
        int totalClicks = products.stream().mapToInt(Product::getClicks).sum();
        List<Statistic> statistics = new ArrayList<>();

        for (Product product : products) {
            double percentClick = (totalClicks > 0) ? (double) product.getClicks() / totalClicks * 100 : 0;
            statistics.add(new Statistic(product.getId(), percentClick, 0, 0, product.getDate()));
        }
        return statistics;
    }
}