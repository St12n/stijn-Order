package com.stijn.order.domain.user;

import com.stijn.order.domain.user.fields.Address;
import com.stijn.order.domain.user.fields.PhoneNumber;
import com.stijn.order.domain.user.fields.Role;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Logger log = LoggerFactory.getLogger(UserRepository.class);

    private final Map<String, User> userRepositoryByID;

    public UserRepository() {
        this.userRepositoryByID = new HashMap<>();
        addAdminToRepository();
    }

    public void addAdminToRepository() {
        User admin1 = new User("Minh","The Admin", "m.admin@order.be", new PhoneNumber("+32","457964521"),new Address("Brussels"), Role.ADMIN);
        userRepositoryByID.put(admin1.getUserID(), admin1);
    }

    public void saveUser(User newUser) {
        if (!isEmailOfMemberUnique(newUser.getEmail())) {
            log.error("email already in use: ".concat(newUser.getEmail()));
            throw new IllegalArgumentException("This email address is already linked to another account.");
        }
        if (!isPhoneNumberOfMemberUnique(newUser.getPhoneNumber())) {
            log.error("phone number already in use: ".concat(newUser.getPhoneNumber().toString()));
            throw new IllegalArgumentException("This phone number is already linked to another account.");
        }
        userRepositoryByID.put(newUser.getUserID(), newUser);
        log.info("POST -> ".concat(newUser.toString()));
    }

    public boolean isEmailOfMemberUnique(String email) {
        for (User user : userRepositoryByID.values()) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPhoneNumberOfMemberUnique(PhoneNumber phoneNumber) {
        for (User user : userRepositoryByID.values()) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return false;
            }
        }
        return true;
    }

    public Collection<User> getAll() {
        return userRepositoryByID.values();
    }
}
