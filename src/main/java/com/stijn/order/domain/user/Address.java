package com.stijn.order.domain.user;

public class Address {
    private final String streetname;
    private final String housenumber;
    private final String boxNumber;
    private final String city;
    private final String postalCode;

    public Address(String streetname, String housenumber, String boxNumber, String city, String postalCode) {
        this.streetname = streetname;
        this.housenumber = housenumber;
        this.boxNumber = boxNumber;
        this.city = city;
        this.postalCode = postalCode;
    }
}
