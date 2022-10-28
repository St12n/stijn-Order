package com.stijn.order.domain.item.fields;

public class StockAmount {
    private final double amountInStock;
    private final StockUnit stockUnit;

    public StockAmount(double amountInStock, StockUnit stockUnit) {
        this.amountInStock = verifyStockAmount(amountInStock);
        this.stockUnit = verifyStockUnit(stockUnit);
    }

    private double verifyStockAmount(double amountInStock) {
        if (amountInStock <0) {
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
