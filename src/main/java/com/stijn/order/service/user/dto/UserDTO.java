package com.stijn.order.service.user.dto;

public class UserDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String countryCode;
    private String localPhoneNumber;
    private String address;

    public UserDTO setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserDTO setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDTO setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public UserDTO setLocalPhoneNumber(String localPhoneNumber) {
        this.localPhoneNumber = localPhoneNumber;
        return this;
    }

    public UserDTO setAddress(String address) {
        this.address = address;
        return this;
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

    public String getCountryCode() {
        return countryCode;
    }

    public String getLocalPhoneNumber() {
        return localPhoneNumber;
    }

    public String getAddress() {
        return address;
    }
}
