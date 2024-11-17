package General;

import Entity.Product;

import java.util.List;

public interface IGeneral {
    List<Product> readFile(String filePath);
    void writeFile(String filePath, List<Object> data);
}
