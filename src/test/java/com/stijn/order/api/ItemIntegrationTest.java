package com.stijn.order.api;

import com.stijn.order.repositories.ItemRepository;
import com.stijn.order.domain.user.User;
import com.stijn.order.repositories.UserRepository;
import com.stijn.order.domain.user.contactInformation.Address;
import com.stijn.order.domain.user.contactInformation.PhoneNumber;
import com.stijn.order.domain.user.role.Role;
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

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemIntegrationTest {

    @LocalServerPort
    private int port;

    private final ItemMapper itemMapper = new ItemMapper();

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    private final User user = new User("Dude",
            "The Second",
            "test123@test.be",
            new PhoneNumber("+32", "1234587"),
            new Address("TestCity"),
            Role.USER,
            "password");





    @Test
    void createItemAsAdmin_ShouldCreateAnItem() {

        String authorization = Base64.getEncoder().encodeToString("m.admin@order.be:admin".getBytes());

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
                .headers("Authorization", "Basic " + authorization)
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

    @Test
    void createItemAsUser_ShouldThrowUnauthorized() {
        userRepository.saveUser(user);
        String authorization = Base64.getEncoder().encodeToString("test123@test.be:password".getBytes());

        CreateItemDTO given = new CreateItemDTO()
                .setName("Beautiful Test Item")
                .setDescription("This is indeed an item")
                .setPriceAmount("50.5")
                .setPriceCurrency("EUR")
                .setStockAmount("1000")
                .setStockUnit("KG");

        RestAssured
                .given()
                .body(given)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .baseUri("http://localhost")
                .port(port)
                .headers("Authorization", "Basic " + authorization)
                .when()
                .post("/items")
                .then()
                .assertThat()
                .statusCode(HttpStatus.UNAUTHORIZED.value());
    }
}
