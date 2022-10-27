package com.stijn.order.service.user.dto;

import com.stijn.order.domain.user.Address;
import com.stijn.order.domain.user.PhoneNumber;

public class UserDTO {
    private String firstname;
    private String lastname;
    private String email;
    private PhoneNumber phoneNumber;
    private Address address;

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

    public UserDTO setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserDTO setAddress(Address address) {
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

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }
}
