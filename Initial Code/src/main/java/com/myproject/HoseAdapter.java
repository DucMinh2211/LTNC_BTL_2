package com.myproject;

import java.util.List;

public class HoseAdapter implements PriceFetcher {
    private HosePriceFetchLib hoseLib;
    private List<String> stockCodes;
 
    public HoseAdapter(HosePriceFetchLib hoseLib, List<String> stockCodes) {
        this.hoseLib = hoseLib;
        this.stockCodes = stockCodes;
    }

    @Override
    public List<StockPrice> fetch() {
        // TODO: Fetch stock data and convert it to StockPrice list

        List<HoseData> hoseDatas = hoseLib.getPrices(stockCodes);
        List<StockPrice> stockPrices = new ArrayList<> ();

        for (HoseData hoseData : hoseDatas) {
            stockPrices.add(convertToStockPrice(hoseData));
        }
        return stockPrices;
    }

    private StockPrice convertToStockPrice(HoseData hoseData) {
        // TODO: Convert HoseData to StockPrice
        return new StockPrice(hoseData.getStockCode(), hoseData.getPrice(), hoseData.getVolume(), hoseData.getTimestamp());
    }
}
