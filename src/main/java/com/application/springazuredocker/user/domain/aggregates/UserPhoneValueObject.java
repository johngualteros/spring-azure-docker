package com.application.springazuredocker.user.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

public class UserPhoneValueObject {
    public String value;
    private String validPhoneRegexp = "/^[0-9]{10}$/i";
    public UserPhoneValueObject(String value) throws InvalidArgumentException {
        this.value = value;
        this.ensureValueIsDefined(value);
        this.ensureIsValidPhone(value);
    }
    private void ensureValueIsDefined(String value) throws InvalidArgumentException {
        if(value != null && !value.isEmpty()) return;
        throw new InvalidArgumentException("Value must be defined");
    }
    private void ensureIsValidPhone(String value) throws InvalidArgumentException {
        if(!value.matches(validPhoneRegexp)) {
            throw new InvalidArgumentException(String.format("%s Value not is a phone", value));
        }
    }
}
