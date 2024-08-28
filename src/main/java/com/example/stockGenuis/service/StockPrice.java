package com.example.stockGenuis.service;

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

    @Autowired
    public StockPrice(RestTemplate restTemplate){

        this.restTemplate =restTemplate;
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

//    public String test(){
//        return daily("SPY");
//    }



}
