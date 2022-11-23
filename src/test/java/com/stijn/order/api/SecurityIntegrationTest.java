package com.stijn.order.api;

import com.stijn.order.domain.user.User;
import com.stijn.order.repositories.UserRepository;
import com.stijn.order.domain.user.contactInformation.Address;
import com.stijn.order.domain.user.contactInformation.PhoneNumber;
import com.stijn.order.domain.user.role.Role;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.Base64;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityIntegrationTest {

    @LocalServerPort
    private int port;
    private static final String URI = "http://localhost";

    @Autowired
    UserRepository userRepository;


//    @BeforeAll
//    void saveUserToRepo() {
//        User user = new User(
//                "Dude",
//                "The Second",
//                "test@test.be",
//                new PhoneNumber("+32", "1234587"),
//                new Address("TestCity"),
//                Role.USER,
//                "password");
//
//        User user2 = new User(
//                "Dude",
//                "The Third",
//                "test2@test.be",
//                new PhoneNumber("+32", "12345889"),
//                new Address("TestCity"),
//                Role.TEST,
//                "password");
//
//        userRepository.findAll().clear();
//        userRepository.save(user);
//        userRepository.save(user2);
//    }

    @Test
    void loginAsUserWithValidCredentiols() {
        User user = new User(
                "Dude",
                "The Second",
                "test@test.be",
                new PhoneNumber("+32", "1234587"),
                new Address("TestCity"),
                Role.USER,
                "password");

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

        User user = new User(
                "Dude",
                "The Second",
                "test@test.be",
                new PhoneNumber("+32", "1234587"),
                new Address("TestCity"),
                Role.USER,
                "password");

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

        User user = new User(
                "Dude",
                "The Second",
                "test@test.be",
                new PhoneNumber("+32", "1234587"),
                new Address("TestCity"),
                Role.USER,
                "password");

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

        User user = new User(
                "Dude",
                "The Second",
                "test@test.be",
                new PhoneNumber("+32", "1234587"),
                new Address("TestCity"),
                Role.USER,
                "password");

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

        User user = new User(
                "Dude",
                "The Second",
                "test@test.be",
                new PhoneNumber("+32", "1234587"),
                new Address("TestCity"),
                Role.USER,
                "password");

        User user2 = new User(
                "Dude",
                "The Third",
                "test2@test.be",
                new PhoneNumber("+32", "12345889"),
                new Address("TestCity"),
                Role.TEST,
                "password");

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
                .statusCode(HttpStatus.UNAUTHORIZED.value());
    }
}
