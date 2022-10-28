package com.stijn.order.api;

import com.stijn.order.domain.user.User;
import com.stijn.order.domain.user.UserRepository;
import com.stijn.order.domain.user.fields.Address;
import com.stijn.order.domain.user.fields.PhoneNumber;
import com.stijn.order.domain.user.fields.Role;
import com.stijn.order.service.user.dto.CreateUserDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.Base64;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityIntegrationTest {

    @LocalServerPort
    private int port;
    private static final String URI = "http://localhost";

    @Autowired
    UserRepository userRepository;

    private final User user = new User("Dude",
            "The Second",
            "test@test.be",
            new PhoneNumber("+32", "1234587"),
            new Address("TestCity"),
            Role.USER,
            "password");

    private final User user2 = new User("Dude",
            "The Third",
            "test2@test.be",
            new PhoneNumber("+32", "12345889"),
            new Address("TestCity"),
            Role.TEST,
            "password");

    @BeforeEach
    void saveUserToRepo() {
        userRepository.getAll().clear();
        userRepository.saveUser(user);
        userRepository.saveUser(user2);
    }

    @Test
    void loginAsUserWithValidCredentiols() {
        String authorization = Base64.getEncoder().encodeToString(user.getEmail().concat(":").concat(user.getPassword()).getBytes());

        RestAssured
                .given()
                .baseUri(URI)
                .port(port)
                .when()
                .headers("Authorization", "Basic " + authorization)
                .get("/login")
                .then()
                .assertThat()
                .statusCode(HttpStatus.ACCEPTED.value());
    }

    @Test
    void loginAsUserWithNotValidEmail() {
        String authorization = Base64.getEncoder().encodeToString("wrong@mail.oei".concat(":").concat(user.getPassword()).getBytes());

        RestAssured
                .given()
                .baseUri(URI)
                .port(port)
                .when()
                .headers("Authorization", "Basic " + authorization)
                .get("/login")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void loginAsNullUserWithNotValidEmail() {
        String authorization = Base64.getEncoder().encodeToString("wrong@mail.oei".concat(":").concat(user.getPassword()).getBytes());

        RestAssured
                .given()
                .baseUri(URI)
                .port(port)
                .when()
                .headers("Authorization", "Basic " + authorization)
                .get("/login")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void loginAsUserWithNotValidPassword() {
        String authorization = Base64.getEncoder().encodeToString(user.getEmail().concat(":").concat("fout").getBytes());

        RestAssured
                .given()
                .baseUri(URI)
                .port(port)
                .when()
                .headers("Authorization", "Basic " + authorization)
                .get("/login")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void loginAsUserWithWrongAuthorization() {
        String authorization = Base64.getEncoder().encodeToString(user2.getEmail().concat(":").concat(user2.getPassword()).getBytes());

        RestAssured
                .given()
                .baseUri(URI)
                .port(port)
                .when()
                .headers("Authorization", "Basic " + authorization)
                .get("/login")
                .then()
                .assertThat()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }
}
