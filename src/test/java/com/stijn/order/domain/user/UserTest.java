package com.stijn.order.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {


    @Test
    void whenCreatingCustomer_GetAllFields() {
        User user = new User(
                "Tim",
                "Vercruysse",
                "timv@test.be",
                new PhoneNumber("0032", "0478945"),
                new Address("Timstraat", "123a", "1", "Leuven", "4568"), Role.USER);

        assertThat(user.getFirstname().equals("Tim"));
        assertThat(user.getLastname().equals("Vercruysse"));
        assertThat(user.getEmail().equals("timv@test.be"));
        assertThat(user.getAddress()).isNotNull();
        assertThat(user.getPhoneNumber()).isNotNull();
    }

    @Test
    void whenCreatingUserWithNullCodePhone_GivesException() {
        assertThatThrownBy(() -> new User("Test", "Lastname", "test@Test.be", new PhoneNumber(null, "123456789"), new Address("Aalst"), Role.USER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Please provide a country code");
    }
    @Test
    void whenCreatingUserWithWrongCountryCodePhone_GivesException() {
        assertThatThrownBy(() -> new User("Test", "Lastname", "test@Test.be", new PhoneNumber("032", "123456789"), new Address("Aalst"), Role.USER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("please provide a correct country code");
    }

    @Test
    void whenCreatingUserWithWrongCountryCode2Phone_GivesException() {
        assertThatThrownBy(() -> new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+032", "123456789"), new Address("Aalst"), Role.USER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("please provide a correct country code");
    }

    @Test
    void whenCreatingUserWithWrongCountryCode3Phone_GivesException() {
        assertThatThrownBy(() -> new User("Test", "Lastname", "test@Test.be", new PhoneNumber("00032", "123456789"), new Address("Aalst"), Role.USER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("please provide a correct country code");
    }
}