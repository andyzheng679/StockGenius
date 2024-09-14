package com.example.stockGenuis.service;

import com.example.stockGenuis.entity.StockData;
import com.example.stockGenuis.entity.StockDataCompositeKey;
import com.example.stockGenuis.repository.StockDataRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

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

    public void mapSaveStockData(String getStockData){

        try{
            JsonNode root = objectMapper.readTree(getStockData);

            JsonNode metaData = root.get("Meta Data");
            JsonNode timeSeries = root.get("Time Series (Daily)");

            String stockTicker = metaData.get("2. Symbol").asText();

            Iterator<Map.Entry<String, JsonNode>> data = timeSeries.fields();
            while(data.hasNext()){
                Map.Entry<String, JsonNode> nextDataPair = data.next();
                String date = nextDataPair.getKey();;
                JsonNode datesData = nextDataPair.getValue();

                LocalDate localDate = LocalDate.parse(date);
                Double open = datesData.get("1. open").asDouble();
                Double close = datesData.get("4. close").asDouble();
                Double high = datesData.get("2. high").asDouble();
                Double low = datesData.get("3. low").asDouble();
                Double intradayMovePercentage = calculateIntradayMovePercentage(open, close);
                Long volume = datesData.get("5. volume").asLong();

                StockDataCompositeKey stockDataCompositeKey = new StockDataCompositeKey(stockTicker, localDate);
                StockData stockData = new StockData(stockDataCompositeKey, open, close, high, low, intradayMovePercentage, volume);

                stockDataRepository.save(stockData);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
