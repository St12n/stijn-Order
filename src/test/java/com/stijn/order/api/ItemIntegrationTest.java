package com.stijn.order.api;

import com.stijn.order.domain.item.ItemRepository;
import com.stijn.order.service.item.ItemMapper;
import com.stijn.order.service.item.dto.CreateItemDTO;
import com.stijn.order.service.item.dto.ItemDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemIntegrationTest {

    @LocalServerPort
    private int port;

    private final ItemMapper itemMapper = new ItemMapper();

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void createItem() {
        CreateItemDTO given = new CreateItemDTO()
                .setName("Beautiful Test Item")
                .setDescription("This is indeed an item")
                .setPriceAmount("50.5")
                .setPriceCurrency("EUR")
                .setStockAmount("1000")
                .setStockUnit("KG");

        ItemDTO result = RestAssured
                .given()
                .body(given)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .baseUri("http://localhost")
                .port(port)
                .when()
                .post("/items")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ItemDTO.class);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(given.getName());
        assertThat(result.getDescription()).isEqualTo(given.getDescription());
        assertThat(result.getPrice()).contains(given.getPriceAmount());
        assertThat(result.getPrice()).contains(given.getPriceCurrency());
        assertThat(result.getAmount()).contains(given.getStockUnit());
        assertThat(result.getAmount()).contains(given.getStockAmount());
    }
}
