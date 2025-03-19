package com.myproject;

import java.util.*;

public class StockFeeder {
    private List<Stock> stockList = new ArrayList<>();
    private Map<String, List<StockViewer>> viewers = new HashMap<>();
    private static StockFeeder instance = null;

    // TODO: Implement Singleton pattern
    private StockFeeder() {}

    public static StockFeeder getInstance() {
        // TODO: Implement Singleton logic
        if (instance == null) {
            instance = new StockFeeder();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        // TODO: Implement adding a stock to stockList
        stockList.add(stock);
        viewers.put(stock.getCode(), new ArrayList<> ());
    }

    public void registerViewer(String code, StockViewer stockViewer) {
        // TODO: Implement registration logic, including checking stock existence
        if (!viewers.containsKey(code)) {
            Logger.errorRegister(code);
        }
        else {
            viewers.get(code).add(stockViewer);
        }
    }    

    public void unregisterViewer(String code, StockViewer stockViewer) {
        // TODO: Implement unregister logic, including error logging
        bool viewerRegistered = viewers.get(code).contains(stockViewer);
        if (!viewers.containsKey(code) || !viewerRegistered) {
            Logger.errorUnregister(code);
        }
        else {
            viewers.get(code).remove(stockViewer);
        }
    }

    public void notify(StockPrice stockPrice) {
        // TODO: Implement notifying registered viewers about price updates
        for (StockViewer stockViewer : viewers.get(stockPrice.getCode())) {
            stockViewer.onUpdate(stockPrice);
        }
    }
}
