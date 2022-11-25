package com.stijn.order.domain.user;

import com.stijn.order.domain.user.contactInformation.Address;
import com.stijn.order.domain.user.contactInformation.PhoneNumber;
import com.stijn.order.domain.user.role.Role;
import com.stijn.order.repositories.UserRepository;
import com.stijn.order.service.user.UserMapper;
import com.stijn.order.service.user.UserService;
import com.stijn.order.service.user.dto.CreateUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    UserMapper userMapper = new UserMapper();

//    @BeforeEach
//    void setUp() {
//        userRepository.deleteAll();
//    }

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
        System.out.println(userRepository.findAll());
        CreateUserDTO createUserDTO1 = new CreateUserDTO()
                .setFirstname("Test")
                .setLastname("Lastname")
                .setEmail("test@test.be")
                .setPassword("test")
                .setCountryCode("0032")
                .setLocalPhoneNumber("0499123456")
                .setCity("Aalst");

        CreateUserDTO createUserDTO2 = new CreateUserDTO()
                .setFirstname("Test")
                .setLastname("Lastname")
                .setEmail("test@test.be")
                .setPassword("test")
                .setCountryCode("0032")
                .setLocalPhoneNumber("0499123457")
                .setCity("Aalst");

        userService.saveUser(createUserDTO1);
        assertThatThrownBy(() -> userService.saveUser(createUserDTO2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This email address is already linked to another account.");
    }

    @Test
    void givenAUserWithPhoneNumberAlreadyInUse_ThenGetException() {
        CreateUserDTO createUserDTO1 = new CreateUserDTO()
                .setFirstname("Test")
                .setLastname("Lastname")
                .setEmail("test@test7.be")
                .setPassword("test")
                .setCountryCode("0032")
                .setLocalPhoneNumber("0499654321")
                .setCity("Aalst");

        CreateUserDTO createUserDTO2 = new CreateUserDTO()
                .setFirstname("Test")
                .setLastname("Lastname")
                .setEmail("test@test9.be")
                .setPassword("test")
                .setCountryCode("0032")
                .setLocalPhoneNumber("0499654321")
                .setCity("Aalst");
        userService.saveUser(createUserDTO1);
        assertThatThrownBy(() -> userService.saveUser(createUserDTO2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This phone number is already linked to another account.");
    }
}