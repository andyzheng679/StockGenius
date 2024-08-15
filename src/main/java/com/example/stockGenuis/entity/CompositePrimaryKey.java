package com.example.stockGenuis.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class CompositePrimaryKey implements Serializable {

    private String stockTicker;
    private LocalDate date;

    public CompositePrimaryKey(String stockTicker, LocalDate date){
        this.stockTicker = stockTicker;
        this.date = date;
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
}
