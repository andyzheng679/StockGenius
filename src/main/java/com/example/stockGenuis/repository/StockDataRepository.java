package com.example.stockGenuis.repository;

import com.example.stockGenuis.entity.StockDataCompositeKey;
import com.example.stockGenuis.entity.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockDataRepository extends JpaRepository<StockData, StockDataCompositeKey> {

    List<StockData> findByStockDataCompositeKey_StockTicker(String stockTicker);

}
