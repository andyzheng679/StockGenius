package com.example.stockGenuis.repository;

import com.example.stockGenuis.entity.CompositePrimaryKey;
import com.example.stockGenuis.entity.StockData;
import com.example.stockGenuis.service.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<StockData, CompositePrimaryKey> {
}
