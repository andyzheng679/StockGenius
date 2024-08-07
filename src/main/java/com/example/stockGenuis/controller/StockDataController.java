package com.example.stockGenuis.controller;

import com.example.stockGenuis.service.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockDataController {

    @Autowired
    private StockPrice stockPrice;

    @GetMapping("/main")
    public ResponseEntity<String> getStockData(){
        String stockData = stockPrice.test();
        return ResponseEntity.ok(stockData);
    }
}
