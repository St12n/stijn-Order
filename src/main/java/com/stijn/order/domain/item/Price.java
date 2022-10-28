package com.stijn.order.domain.item;

public class Price {
    private final double priceAmount;
    private final PriceCurrency priceCurrency;

    public Price(double priceAmount, PriceCurrency priceCurrency) {
        this.priceAmount = verifyPriceAmount(priceAmount);
        this.priceCurrency = verifyPriceCurrency(priceCurrency);
    }

    private double verifyPriceAmount(double priceAmount){
        if (priceAmount <= 0) {
            throw new IllegalArgumentException("Price cannot be zero or negative.");
        }
        return priceAmount;
    }

    private PriceCurrency verifyPriceCurrency(PriceCurrency priceCurrency) {
        if (priceCurrency == null) {
            throw new IllegalArgumentException("Provide a currency for the price.");
        }
        return priceCurrency;
    }

    public double getPriceAmount() {
        return priceAmount;
    }

    public PriceCurrency getPriceCurrency() {
        return priceCurrency;
    }
}
