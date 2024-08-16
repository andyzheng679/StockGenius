package com.example.stockGenuis.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class StockData {

    @EmbeddedId
    private StockDataCompositeKey id;
    private double open;
    private double close;
    private double high;
    private double low;
    private double intradayMovePercentage;
    private long volume;

    public StockData(StockDataCompositeKey id, double open, double close, double high, double low, double intradayMovePercentage, long volume) {
        this.id = id;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.intradayMovePercentage = intradayMovePercentage;
        this.volume = volume;
    }

    public StockDataCompositeKey getId() {
        return id;
    }

    public void setId(StockDataCompositeKey id) {
        this.id = id;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getIntradayMovePercentage() {
        return intradayMovePercentage;
    }

    public void setIntradayMovePercentage(double intradayMovePercentage) {
        this.intradayMovePercentage = intradayMovePercentage;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }
}
