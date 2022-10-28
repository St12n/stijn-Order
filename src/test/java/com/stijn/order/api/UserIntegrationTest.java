package com.stijn.order.api;

import com.stijn.order.domain.user.UserRepository;
import com.stijn.order.service.user.UserMapper;
import com.stijn.order.service.user.dto.CreateUserDTO;
import com.stijn.order.service.user.dto.UserDTO;
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
public class UserIntegrationTest {

    @LocalServerPort
    private int port;

    private final UserMapper userMapper = new UserMapper();

    @Autowired
    private UserRepository userRepository;


    @Test
    void createAUser() {
        CreateUserDTO given = new CreateUserDTO()
                .setFirstname("Jeff")
                .setLastname("Vermaulen")
                .setEmail("jefkevermeulen@vtm.be")
                .setCountryCode("+32")
                .setLocalPhoneNumber("123456789")
                .setCity("Aalst")
                .setPassword("password");

        UserDTO result = RestAssured
                .given()
                .body(given)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .baseUri("http://localhost")
                .port(port)
                .when()
                .post("/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(UserDTO.class);

        assertThat(result).isNotNull();
        assertThat(result.getFirstname()).isEqualTo(given.getFirstname());
        assertThat(result.getLastname()).isEqualTo(given.getLastname());
        assertThat(result.getEmail()).isEqualTo(given.getEmail());
        assertThat(result.getCountryCode()).isEqualTo(given.getCountryCode());
        assertThat(result.getLocalPhoneNumber()).isEqualTo(given.getLocalPhoneNumber());
        assertThat(result.getAddress()).contains("Aalst");
    }

}
