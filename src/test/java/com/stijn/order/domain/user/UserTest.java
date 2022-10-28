package com.stijn.order.domain.user;

import com.stijn.order.domain.user.fields.Address;
import com.stijn.order.domain.user.fields.Feature;
import com.stijn.order.domain.user.fields.PhoneNumber;
import com.stijn.order.domain.user.fields.Role;
import org.junit.jupiter.api.Test;

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
        assertThat(user.getPhoneNumber().getLocalPhoneNumber()).isEqualTo("0478945");
        assertThat(user.getPhoneNumber().getCountrycode()).isEqualTo("0032");
        assertThat(user.getAddress().getStreetname()).isEqualTo("Timstraat");
        assertThat(user.getAddress().getHousenumber()).isEqualTo("123a");
        assertThat(user.getAddress().getBoxNumber()).isEqualTo("1");
        assertThat(user.getAddress().getCity()).isEqualTo("Leuven");
        assertThat(user.getAddress().getPostalCode()).isEqualTo("4568");
        assertThat(user.getRole().containsFeature(Feature.LOGIN)).isTrue();
    }

    @Test
    void whenCreatingCustomerWithSameAddress_AddressIsEqual() {
        User user = new User(
                "Tim",
                "Vercruysse",
                "timv@test.be",
                new PhoneNumber("0032", "0478945"),
                new Address("Timstraat", "123a", "1", "Leuven", "4568"), Role.USER);

        User user2 = new User(
                "Tim",
                "Vercruysse",
                "timv@test.be",
                new PhoneNumber("0032", "0478945"),
                new Address("Timstraat", "123a", "1", "Leuven", "4568"), Role.USER);

        assertThat(user.getAddress()).isEqualTo(user2.getAddress());
    }

    @Test
    void whenCreatingUserWithNullCountryCodePhone_GivesException() {
        assertThatThrownBy(() -> new User("Test", "Lastname", "test@Test.be", new PhoneNumber(null, "123456789"), new Address("Aalst"), Role.USER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Please provide a country code");
    }

    @Test
    void whenCreatingUserWithNullLocalPhone_GivesException() {
        assertThatThrownBy(() -> new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", null), new Address("Aalst"), Role.USER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Please provide a phonenumber");
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