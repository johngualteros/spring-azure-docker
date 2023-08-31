package com.application.springazuredocker.user.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

public class UserRoleValueObject {
    public String value;
    private String validRoleRegexp = "/^(ROLE_ADMIN|ROLE_USER)$/i";
    public UserRoleValueObject(String value) throws InvalidArgumentException {
        this.value = value;
        this.ensureValueIsDefined(value);
        this.ensureIsValidRole(value);
    }
    private void ensureValueIsDefined(String value) throws InvalidArgumentException {
        if(value != null && !value.isEmpty()) return;
        throw new InvalidArgumentException("Value must be defined");
    }
    private void ensureIsValidRole(String value) throws InvalidArgumentException {
        if(!value.matches(validRoleRegexp)) {
            throw new InvalidArgumentException(String.format("%s Value not is a role", value));
        }
    }
}
