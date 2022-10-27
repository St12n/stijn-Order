package com.stijn.order.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    void whenCreatingCustomer_GetAllFields() {
        User user = new User(
                "Tim",
                "Vercruysse",
                "timv@test.be",
                new PhoneNumber("0032", "0478945"),
                new Address("Timstraat", "123a", "1", "Leuven", "4568"), Role.CUSTOMER);

        assertThat(user.getFirstname().equals("Tim"));
        assertThat(user.getLastname().equals("Vercruysse"));
        assertThat(user.getEmail().equals("timv@test.be"));
        assertThat(user.getAddress()).isNotNull();
        assertThat(user.getPhoneNumber()).isNotNull();
    }
}