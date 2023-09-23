package com.application.springazuredocker.shared.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

public class UuidV3ValueObject {
    public String value;
    private String validUuidRegexp = "/^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$/i";
    public UuidV3ValueObject(String value) throws InvalidArgumentException {
        this.value = value;
        this.ensureValueIsDefined(value);
        this.ensureIsValidUuid(value);
    }
    private void ensureValueIsDefined(String value) throws InvalidArgumentException {
        if(value != null && !value.isEmpty()) return;
        throw new InvalidArgumentException("Value must be defined");
    }
    private void ensureIsValidUuid(String value) throws InvalidArgumentException {
        if(!value.matches(validUuidRegexp)) {
            throw new InvalidArgumentException(String.format("%s Value not is a uuid", value));
        }
    }
}
