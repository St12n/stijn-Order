package com.stijn.order.domain.user;

public class PhoneNumber {
    private final String countrycode;
    private final String localPhoneNumber;

    public PhoneNumber(String countrycode, String localPhoneNumber) {
        this.countrycode = countrycode;
        this.localPhoneNumber = localPhoneNumber;
    }
}
