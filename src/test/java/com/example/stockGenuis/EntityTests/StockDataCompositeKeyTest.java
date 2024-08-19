package com.example.stockGenuis.EntityTests;

import com.example.stockGenuis.entity.StockDataCompositeKey;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StockDataCompositeKeyTest {

    @Test
    void defaultEquals(){
        StockDataCompositeKey key1 = new StockDataCompositeKey("SPY", LocalDate.of(2024, 8, 19));
        StockDataCompositeKey key2 = new StockDataCompositeKey("SPY", LocalDate.of(2024, 8, 19));
        StockDataCompositeKey key3 = new StockDataCompositeKey("AAPL", LocalDate.of(2024, 8, 19));

        assertFalse(key1.equals(key2));
        assertTrue(key1.equals(key1));
        assertFalse(key1.equals(key3));
        assertFalse(key1.equals(null));
    }



}
