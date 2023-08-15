package com.application.springazuredocker.tag.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

public class TagColorValueObject {
    public String value;
    public String validColorRegexp = "/^#?([a-f0-9]{6}|[a-f0-9]{3})$/";
    public TagColorValueObject(String value) throws InvalidArgumentException {
        this.value = value;
        this.ensureValidIsDefined(value);
        this.ensureIsValidColor(value);
    }
    private void ensureValidIsDefined(String value) throws InvalidArgumentException {
        if(value != null && !value.isEmpty()) return;
        throw new InvalidArgumentException("Value must be defined");
    }
    private void ensureIsValidColor(String value) throws InvalidArgumentException {
        if(!value.matches(validColorRegexp)) {
            throw new InvalidArgumentException("Color needs the hexadecimal format");
        }
    }
}