package com.stijn.order.domain.item.price;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class Price {
    @Column(name = "PRICE_AMOUNT")
    private double priceAmount;
    @Column(name = "PRICE_CURRENCY")
    @Enumerated(EnumType.STRING)
    private PriceCurrency priceCurrency;

    public Price() {
    }

    public Price(double priceAmount, PriceCurrency priceCurrency) {
        this.priceAmount = verifyPriceAmount(priceAmount);
        this.priceCurrency = verifyPriceCurrency(priceCurrency);
    }

    public Price add(Price otherPrice) {
        return new Price(priceAmount + otherPrice.priceAmount, priceCurrency);
    }

    public static Price eur(int amount) {
        return new Price(amount, PriceCurrency.EUR);
    }

    private double verifyPriceAmount(double priceAmount){
        if (priceAmount < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        return priceAmount;
    }

    private PriceCurrency verifyPriceCurrency(PriceCurrency priceCurrency) {
        if (priceCurrency == null) {
            throw new IllegalArgumentException("Provide a currency for the price.");
        }
        return priceCurrency;
    }

    public void setPriceAmount(double priceAmount) {
        this.priceAmount = priceAmount;
    }

    public void setPriceCurrency(PriceCurrency priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public double getPriceAmount() {
        return priceAmount;
    }

    public PriceCurrency getPriceCurrency() {
        return priceCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.priceAmount, priceAmount) == 0 && priceCurrency == price.priceCurrency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceAmount, priceCurrency);
    }

    @Override
    public String toString() {
        return "Price{" +priceAmount + " " + priceCurrency +'}';
    }
}
