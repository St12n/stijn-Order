package com.stijn.order.domain.user;

public class Customer {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final PhoneNumber phoneNumber;
    private final Address address;

    public Customer(String firstname, String lastname, String email, PhoneNumber phoneNumber, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
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
}
