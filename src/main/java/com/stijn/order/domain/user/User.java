package com.stijn.order.domain.user;

public class User {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final PhoneNumber phoneNumber;
    private final Address address;
    private final Role role;

    public User(String firstname, String lastname, String email, PhoneNumber phoneNumber, Address address, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
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
}

