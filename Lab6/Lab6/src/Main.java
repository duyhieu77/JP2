import Entity.Product;
import Entity.Statistic;
import Service.FileService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();

        String sysPath = System.getProperty("user.dir");
        String fileInPath = sysPath.replace("/", "\\") + "\\data\\Input.txt";
        String fileOutPath = sysPath.replace("/", "\\") + "\\data\\Output.txt";

        List<Product> products = fileService.readFile(fileInPath);
        List<Statistic> statistics = fileService.PercentageStatistics(products);
        fileService.writeFile(fileOutPath, statistics);
    }
}