package com.application.springazuredocker.tag.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

import java.util.Optional;

public class TagUuidValueObject {
    public String value;
    private String validUuidRegexp = "/^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$/i";
    public TagUuidValueObject(String value) throws InvalidArgumentException {
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
