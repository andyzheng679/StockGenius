package com.example.stockGenuis.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class StockDataCompositeKey implements Serializable {

    private String stockTicker;
    private LocalDate date;

    public StockDataCompositeKey(String stockTicker, LocalDate date){
        this.stockTicker = stockTicker;
        this.date = date;
    }

    public StockDataCompositeKey(){

    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        StockDataCompositeKey that = (StockDataCompositeKey) o;
//        return Objects.equals(stockTicker, that.stockTicker) &&
//                Objects.equals(date, that.date);
//    }


}
