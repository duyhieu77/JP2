package Service;

import Entity.Ticker;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TickerService {

    public Map<String, List<Ticker>> groupByExchange(List<Ticker> tickers) {
        return tickers.stream()
                .collect(Collectors.groupingBy(Ticker::getExchange));
    }

    public Map<String, Ticker> toMap(List<Ticker> tickers) {
        return tickers.stream()
                .collect(Collectors.toMap(Ticker::getSymbol, ticker -> ticker));
    }
}