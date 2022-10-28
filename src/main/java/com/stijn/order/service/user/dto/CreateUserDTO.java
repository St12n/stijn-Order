package com.stijn.order.service.user.dto;

import com.stijn.order.domain.user.fields.Address;

public class CreateUserDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String countryCode;
    private String localPhoneNumber;
    private String streetname;
    private String housenumber;
    private String boxNumber;
    private String city;
    private String postalCode;
    private Address address;

    public String getCountryCode() {
        return countryCode;
    }

    public CreateUserDTO setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getLocalPhoneNumber() {
        return localPhoneNumber;
    }

    public CreateUserDTO setLocalPhoneNumber(String localPhoneNumber) {
        this.localPhoneNumber = localPhoneNumber;
        return this;
    }

    public CreateUserDTO setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CreateUserDTO setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CreateUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateUserDTO setStreetname(String streetname) {
        this.streetname = streetname;
        return this;
    }

    public CreateUserDTO setHousenumber(String housenumber) {
        this.housenumber = housenumber;
        return this;
    }

    public CreateUserDTO setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber;
        return this;
    }

    public CreateUserDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public CreateUserDTO setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public CreateUserDTO setAddress(Address address) {
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

    public String getStreetname() {
        return streetname;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public String getBoxNumber() {
        return boxNumber;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Address getAddress() {
        return address;
    }
}
