package com.myproject;

import java.util.HashMap;
import java.util.Map;

public class StockRealtimePriceView implements StockViewer {
    private final Map<String, Double> lastPrices = new HashMap<>();

    @Override
    public void onUpdate(StockPrice stockPrice) {
        // TODO: Implement logic to check if price has changed and log it
        String code = stockPrice.getCode();
        double currentPrice = stockPrice.getAvgPrice();
        Double lastPrice = lastPrices.get(code);

        System.out.println("update"); // debug

        if (lastPrice == null || lastPrice != currentPrice) {
            lastPrices.put(code, currentPrice);
            Logger.logRealtime(code, currentPrice);
        }
    }
}
