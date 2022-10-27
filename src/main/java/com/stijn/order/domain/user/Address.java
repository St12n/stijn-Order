package com.stijn.order.domain.user;

import java.util.Objects;

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

    public Address(String city) {
        this(null, null, null, city, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(streetname, address.streetname) && Objects.equals(housenumber, address.housenumber) && Objects.equals(boxNumber, address.boxNumber) && Objects.equals(city, address.city) && Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetname, housenumber, boxNumber, city, postalCode);
    }
}
