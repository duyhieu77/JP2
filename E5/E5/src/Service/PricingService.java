package Service;

import Entity.Pricing;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PricingService {

    public double averageClosePrice(List<Pricing> pricingList) {
        return pricingList.stream()
                .mapToDouble(Pricing::getClosePrice)
                .average()
                .orElse(0.0);
    }

    public Map<Boolean, List<Pricing>> partitionPricingByPrice(List<Pricing> pricingList, double threshold) {
        return pricingList.stream()
                .collect(Collectors.partitioningBy(pricing -> pricing.getClosePrice() > threshold));
    }

    public Optional<Pricing> findHighestPrice(List<Pricing> pricingList) {
        return pricingList.stream()
                .max(Comparator.comparing(Pricing::getClosePrice));
    }
}