package com.stijn.order.domain.user;

import com.stijn.order.domain.user.contactInformation.Address;
import com.stijn.order.domain.user.contactInformation.PhoneNumber;
import com.stijn.order.domain.user.role.Role;
import com.stijn.order.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void givenNewRepo_AdminIsThere() {
        assertThat(userRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void givenAValidUser_WhenSaveUserToRepo_ThenAlUsersContainsGivenUser() {
        User newUser = new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", "123456789"), new Address("Aalst"), Role.USER, "password");
        User newUser2 = new User("Test", "Lastname", "test@Test2.be", new PhoneNumber("+32", "123456788"), new Address("Aalst"), Role.USER, "password");
        userRepository.save(newUser);
        userRepository.save(newUser2);
        assertThat(userRepository.findAll()).isNotNull();
        assertThat(userRepository.findAll()).isNotEmpty();
        assertThat(userRepository.findAll()).contains(newUser);
        assertThat(userRepository.findAll()).contains(newUser2);
    }

    @Test
    void givenAValidUser_WhenDifferntPhoneAndEmail_ThenAllUsersContainsGivenUser() {
        User newUser = new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", "123456789"), new Address("Aalst"), Role.USER, "password");
        userRepository.save(newUser);
        assertThat(userRepository.findAll()).isNotNull();
        assertThat(userRepository.findAll()).isNotEmpty();
        assertThat(userRepository.findAll()).contains(newUser);
    }

    @Test
    void givenAUserWithEmailAlreadyInUse_ThenGetException() {
        User newUser = new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", "123456789"), new Address("Aalst"), Role.USER, "password");
        User newUser2 = new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", "8974457"), new Address("Aalst"), Role.USER, "password");
        userRepository.save(newUser);
        assertThatThrownBy(() -> userRepository.save(newUser2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This email address is already linked to another account.");
    }

    @Test
    void givenAUserWithPhoneNumberAlreadyInUse_ThenGetException() {
        User newUser = new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", "123456789"), new Address("Aalst"), Role.USER, "password");
        User newUser2 = new User("Test", "Lastname", "test@Test2.be", new PhoneNumber("+32", "123456789"), new Address("Aalst"), Role.USER, "password");
        userRepository.save(newUser);
        assertThatThrownBy(() -> userRepository.save(newUser2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This phone number is already linked to another account.");
    }
}