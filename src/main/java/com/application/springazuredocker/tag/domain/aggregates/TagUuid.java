package com.application.springazuredocker.tag.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

import java.util.Optional;

public class TagUuid {
    public String value;
    private String validUuidRegexp = "/^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$/i";
    public TagUuid(String value) {
        this.value = value;
    }
    private void ensureValueIsDefined(Optional<String> value) throws InvalidArgumentException {
        if(value.isPresent()) return;
        throw new InvalidArgumentException("Value must be defined");
    }
    private void ensureIsValidUuid(String value) throws InvalidArgumentException {
        if(!value.matches(validUuidRegexp)) {
            throw new InvalidArgumentException(String.format("%s Value not is a uuid", value));
        }
    }
}
