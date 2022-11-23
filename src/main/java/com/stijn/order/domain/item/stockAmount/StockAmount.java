package com.stijn.order.domain.item.stockAmount;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class StockAmount {
    @Column(name = "AMOUNT_IN_STOCK")
    private double amountInStock;
    @Column(name = "STOCK_UNIT")
    @Enumerated(EnumType.STRING)
    private StockUnit stockUnit;

    public StockAmount() {
    }

    public StockAmount(double amountInStock, StockUnit stockUnit) {
        this.amountInStock = verifyStockAmount(amountInStock);
        this.stockUnit = verifyStockUnit(stockUnit);
    }

    private double verifyStockAmount(double amountInStock) {
        if (amountInStock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        return amountInStock;
    }

    private StockUnit verifyStockUnit(StockUnit stockUnit) {
        if (stockUnit == null) {
            throw new IllegalArgumentException("Provide the stock unit.");
        }
        return stockUnit;
    }

    public void setAmountInStock(double amountInStock) {
        this.amountInStock = amountInStock;
    }

    public void setStockUnit(StockUnit stockUnit) {
        this.stockUnit = stockUnit;
    }

    public double getAmountInStock() {
        return amountInStock;
    }

    public StockUnit getStockUnit() {
        return stockUnit;
    }

    @Override
    public String toString() {
        return "StockAmount{" + amountInStock + " " + stockUnit + "}";
    }
}
