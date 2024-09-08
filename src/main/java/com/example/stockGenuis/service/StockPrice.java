package com.example.stockGenuis.service;

import com.example.stockGenuis.repository.StockDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockPrice {

    @Value("${apiKey}")
    private String apiKey;

    private String aphaVantageURL = "https://www.alphavantage.co/query?function=";

    private RestTemplate restTemplate;

    private StockDataRepository stockDataRepository;

    private ObjectMapper objectMapper;

    @Autowired
    public StockPrice(RestTemplate restTemplate, StockDataRepository stockDataRepository, ObjectMapper objectMapper){

        this.restTemplate = restTemplate;
        this.stockDataRepository = stockDataRepository;
        this.objectMapper = objectMapper;
    }

    private double calculateIntradayMovePercentage(double open, double close){
        return Math.round(((close - open) / open) * 100 * 100.0) / 100.0;
    }

    public String getStockData(String range, String ticker){
        String url = aphaVantageURL + range + "&symbol=" + ticker + "&outputsize=full&apikey=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    public String daily(String ticker){
        return getStockData("TIME_SERIES_DAILY", ticker);
    }

    public String weekly(String ticker){
        return getStockData("TIME_SERIES_WEEKLY", ticker);
    }

    public String monthly(String ticker){
        return getStockData("TIME_SERIES_MONTHLY", ticker);
    }

    public String test(){
        return daily("SPY");
    }



}
