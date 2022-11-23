package com.stijn.order.domain.user.contactInformation;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class PhoneNumber {
    @Column(name = "mobile_phone_country_code")
    private String countryCode;
    @Column(name = "mobile_phone_local_phone_number")
    private String localPhoneNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(String countryCode, String localPhoneNumber) {
        this.countryCode = countryCodeValidator(countryCode);
        this.localPhoneNumber = localPhoneNumberValidator(localPhoneNumber);
    }

    public String countryCodeValidator(String countrycode) {
        if (countrycode == null) {
            throw new IllegalArgumentException("Please provide a country code");
        }
        if (countrycode.length() == 3 && countrycode.charAt(0) != '+') {
            throw new IllegalArgumentException("please provide a correct country code");
        }
        if (countrycode.length() == 4 && countrycode.charAt(0) != '0') {
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

    public String getCountryCode() {
        return countryCode;
    }

    public String getLocalPhoneNumber() {
        return localPhoneNumber;
    }

    public void setCountryCode(String countrycode) {
        this.countryCode = countrycode;
    }

    public void setLocalPhoneNumber(String localPhoneNumber) {
        this.localPhoneNumber = localPhoneNumber;
    }

    @Override
    public String toString() {
        return countryCode + ' ' + localPhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(countryCode, that.countryCode) && Objects.equals(localPhoneNumber, that.localPhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, localPhoneNumber);
    }
}
