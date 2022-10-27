package com.stijn.order.domain.user;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CustomerTest {

    @Test
    void whenCreatingCustomer_GetAllFields() {
        Customer customer = new Customer(
                "Tim",
                "Vercruysse",
                "timv@test.be",
                new PhoneNumber("0032", "0478945"),
                new Address("Timstraat", "123a", "1", "Leuven", "4568"));

        assertThat(customer.getFirstname().equals("Tim"));
        assertThat(customer.getLastname().equals("Vercruysse"));
        assertThat(customer.getEmail().equals("timv@test.be"));
        assertThat(customer.getAddress()).isNotNull();
        assertThat(customer.getPhoneNumber()).isNotNull();
    }
}