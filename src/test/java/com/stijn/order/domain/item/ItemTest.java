package com.stijn.order.domain.item;

import com.stijn.order.domain.item.fields.Price;
import com.stijn.order.domain.item.fields.PriceCurrency;
import com.stijn.order.domain.item.fields.StockAmount;
import com.stijn.order.domain.item.fields.StockUnit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ItemTest {
    @Test
    void whenCreatingItem_GetAllFields() {
        Item item = new Item("name", "description", new Price(10, PriceCurrency.EUR),new StockAmount(100, StockUnit.KG));
        assertThat(item).isNotNull();
        assertThat(item.getName()).isEqualTo("name");
        assertThat(item.getDescription()).isEqualTo("description");
        assertThat(item.getPrice().getPriceAmount()).isEqualTo(10);
        assertThat(item.getPrice().getPriceCurrency()).isEqualTo(PriceCurrency.EUR);
        assertThat(item.getAmount().getAmountInStock()).isEqualTo(100);
        assertThat(item.getAmount().getStockUnit()).isEqualTo(StockUnit.KG);
    }

    @Test
    void whenCreatingItemWithNoName_GetExceptionName() {
        assertThatThrownBy(() -> new Item(null, "description", new Price(10, PriceCurrency.EUR),new StockAmount(100, StockUnit.KG)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Provide a name and a description for the item");
    }

    @Test
    void whenCreatingItemWithNoDescription_GetExceptionNameDescription() {
        assertThatThrownBy(() -> new Item("name", null, new Price(10, PriceCurrency.EUR),new StockAmount(100, StockUnit.KG)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Provide a name and a description for the item");
    }

    @Test
    void whenCreatingItemWithNoPrice_GetExceptionPrice() {
        assertThatThrownBy(() -> new Item("name", "description", new Price(0, PriceCurrency.EUR),new StockAmount(100, StockUnit.KG)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Price cannot be zero or negative.");
    }

    @Test
    void whenCreatingItemWithNegativePrice_GetExceptionPrice() {
        assertThatThrownBy(() -> new Item("name", "description", new Price(-10, PriceCurrency.EUR),new StockAmount(100, StockUnit.KG)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Price cannot be zero or negative.");
    }

    @Test
    void whenCreatingItemWithNoCurrency_GetExceptionCurrency() {
        assertThatThrownBy(() -> new Item("name", "description", new Price(10, null),new StockAmount(100, StockUnit.KG)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Provide a currency for the price.");
    }

    @Test
    void whenCreatingItemWithNegativeAmountOfStock_GetExceptionAmountOfStock() {
        assertThatThrownBy(() -> new Item("name", "description", new Price(10, PriceCurrency.EUR),new StockAmount(-100, StockUnit.KG)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Stock cannot be negative.");
    }

    @Test
    void whenCreatingItemWithNoStockUnit_GetExceptionStockUnit() {
        assertThatThrownBy(() -> new Item("name", "description", new Price(10, PriceCurrency.EUR),new StockAmount(100, null)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Provide the stock unit.");
    }
}