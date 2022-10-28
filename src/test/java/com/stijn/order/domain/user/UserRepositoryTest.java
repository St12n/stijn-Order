package com.stijn.order.domain.user;

import com.stijn.order.domain.user.fields.Address;
import com.stijn.order.domain.user.fields.PhoneNumber;
import com.stijn.order.domain.user.fields.Role;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserRepositoryTest {

    @Test
    void givenNewRepo_AdminIsThere() {
        UserRepository userRepository = new UserRepository();
        assertThat(userRepository.getAll().size()).isEqualTo(1);
    }

    @Test
    void givenAValidUser_WhenSaveUserToRepo_ThenAlUsersContainsGivenUser() {
        UserRepository userRepository = new UserRepository();
        User newUser = new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", "123456789"), new Address("Aalst"), Role.USER);
        User newUser2 = new User("Test", "Lastname", "test@Test2.be", new PhoneNumber("+32", "123456788"), new Address("Aalst"), Role.USER);
        userRepository.saveUser(newUser);
        userRepository.saveUser(newUser2);
        assertThat(userRepository.getAll()).isNotNull();
        assertThat(userRepository.getAll()).isNotEmpty();
        assertThat(userRepository.getAll()).contains(newUser);
        assertThat(userRepository.getAll()).contains(newUser2);
    }

    @Test
    void givenAValidUser_WhenDifferntPhoneAndEmail_ThenAllUsersContainsGivenUser() {
        UserRepository userRepository = new UserRepository();
        User newUser = new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", "123456789"), new Address("Aalst"), Role.USER);
        userRepository.saveUser(newUser);
        assertThat(userRepository.getAll()).isNotNull();
        assertThat(userRepository.getAll()).isNotEmpty();
        assertThat(userRepository.getAll()).contains(newUser);
    }

    @Test
    void givenAUserWithEmailAlreadyInUse_ThenGetException() {
        UserRepository userRepository = new UserRepository();
        User newUser = new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", "123456789"), new Address("Aalst"), Role.USER);
        User newUser2 = new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", "8974457"), new Address("Aalst"), Role.USER);
        userRepository.saveUser(newUser);
        assertThatThrownBy(() -> userRepository.saveUser(newUser2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This email address is already linked to another account.");
    }

    @Test
    void givenAUserWithPhoneNumberAlreadyInUse_ThenGetException() {
        UserRepository userRepository = new UserRepository();
        User newUser = new User("Test", "Lastname", "test@Test.be", new PhoneNumber("+32", "123456789"), new Address("Aalst"), Role.USER);
        User newUser2 = new User("Test", "Lastname", "test@Test2.be", new PhoneNumber("+32", "123456789"), new Address("Aalst"), Role.USER);
        userRepository.saveUser(newUser);
        assertThatThrownBy(() -> userRepository.saveUser(newUser2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This phone number is already linked to another account.");
    }
}