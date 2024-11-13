import Entity.Pricing;
import Entity.Ticker;
import Service.PricingService;
import Service.TickerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
    
        List<Ticker> tickers = new ArrayList<>();
        tickers.add(new Ticker(1,"V", "Riot","Venom"));
        tickers.add(new Ticker(2,"V2", "Carnage ","Venom2"));
        tickers.add(new Ticker(3,"V3", "Knull","Venom3"));

        TickerService tickerService = new TickerService();

        Map<String, List<Ticker>> groupedTickers = tickerService.groupByExchange(tickers);
        System.out.println("Tickers grouped by exchange: " + groupedTickers);

        List<Pricing> pricingList = new ArrayList<>();
        pricingList.add(new Pricing(1, 1, LocalDateTime.now(), 150.0, 155.0, 154.5));
        pricingList.add(new Pricing(2, 2, LocalDateTime.now(), 2800.0, 2795.0, 2780.0));
        pricingList.add(new Pricing(3, 3, LocalDateTime.now(), 700.0, 710.0, 705.0));
        pricingList.add(new Pricing(4, 4, LocalDateTime.now(), 3300.0, 3320.0, 3310.0));
        pricingList.add(new Pricing(5, 5, LocalDateTime.now(), 300.0, 305.0, 302.0));

        PricingService pricingService = new PricingService();

        double averageClosePrice = pricingService.averageClosePrice(pricingList);
        System.out.println("Average Price: " + averageClosePrice);

        double threshold = 1000.0;
        Map<Boolean, List<Pricing>> partitionedPricing = pricingService.partitionPricingByPrice(pricingList, threshold);
        System.out.println("Pricing partitioned by threshold: " + partitionedPricing);

        Optional<Pricing> highestPrice = pricingService.findHighestPrice(pricingList);
        highestPrice.ifPresent(price ->
                System.out.println("Highest Price: " + price.getClosePrice() + "tickerId: " + price.getTickerId()));
    }
}