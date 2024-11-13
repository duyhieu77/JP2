import Entity.OderDetail;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String sysPath = System.getProperty("user.dir");
        String fileInPath = sysPath.replace("/","\\") + "/data/orderDetail.in.txt";
        String fileOutPath = sysPath.replace("/","\\") + "/data/orderCustomer.out.txt";

        List<OderDetail> oderDetails = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInPath))) {
            String lineData;
            bufferedReader.readLine();
            while ((lineData = bufferedReader.readLine()) != null) {
                if (!lineData.isEmpty()) {
                    String[] arData = lineData.split(";");
                    int orderId = Integer.parseInt(arData[1]);
                    int productId = Integer.parseInt(arData[2]);
                    int quantity = Integer.parseInt(arData[3]);
                    double price = Double.parseDouble(arData[4]);
                    oderDetails.add(new OderDetail(orderId, productId, quantity, price));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Map<Integer, Double> customerTotal = oderDetails.stream()
                .collect(Collectors.groupingBy(OderDetail::getOrderId,
                        Collectors.summingDouble(OderDetail::getPrice)));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutPath))) {
            bufferedWriter.write("OrderId;TotalPrice\n");
            for (Map.Entry<Integer, Double> entry : customerTotal.entrySet()) {
                bufferedWriter.write(entry.getKey() + ";" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        customerTotal.forEach((orderId, totalPrice) ->
                System.out.println("OrderId: " + orderId + ", TotalPrice: " + totalPrice));
    }
}