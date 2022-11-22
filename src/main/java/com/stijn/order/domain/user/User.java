package com.stijn.order.domain.user;

import com.stijn.order.domain.user.contactInformation.Address;
import com.stijn.order.domain.user.role.Feature;
import com.stijn.order.domain.user.contactInformation.PhoneNumber;
import com.stijn.order.domain.user.role.Role;

import java.util.UUID;


public class User {
    private final String userID;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final PhoneNumber phoneNumber;
    private final Address address;
    private final Role role;
    private final String password;

    public User(String firstname, String lastname, String email, PhoneNumber phoneNumber, Address address, Role role, String password) {
        this.userID = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
        this.password = password;
    }

    public boolean doesPasswordMatch(String passwordToMatch) {
        return password.equals(passwordToMatch);
    }

    public boolean canHaveAccessTo(Feature feature) {
        return role.containsFeature(feature);
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public Role getRole() {
        return role;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ", role=" + role +
                '}';
    }
}

