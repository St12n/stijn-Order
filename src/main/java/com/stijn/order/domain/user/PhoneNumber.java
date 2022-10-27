package com.stijn.order.domain.user;

import java.util.Objects;

public class PhoneNumber {
    private final String countrycode;
    private final String localPhoneNumber;

    public PhoneNumber(String countrycode, String localPhoneNumber) {
        this.countrycode = countryCodeValidator(countrycode);
        this.localPhoneNumber = localPhoneNumberValidator(localPhoneNumber);
    }

    public String countryCodeValidator(String countrycode) {
        if (countrycode == null) {
            throw new IllegalArgumentException("Please provide a country code");
        }
        if (countrycode.length() == 3 && countrycode.charAt(0) != '+') {
            throw new IllegalArgumentException("please provide a correct country code");
        }
        if (countrycode.length() > 4) {
            throw new IllegalArgumentException("please provide a correct country code");
        }
        return countrycode;
    }

    public String localPhoneNumberValidator(String localPhoneNumber) {
        if (localPhoneNumber == null) {
            throw new IllegalArgumentException("Please provide a phonenumber");
        }
        return localPhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(countrycode, that.countrycode) && Objects.equals(localPhoneNumber, that.localPhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countrycode, localPhoneNumber);
    }
}
