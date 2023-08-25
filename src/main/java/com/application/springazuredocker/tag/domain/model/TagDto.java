package com.application.springazuredocker.tag.domain.model;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;
import com.application.springazuredocker.tag.domain.aggregates.TagColorValueObject;
import com.application.springazuredocker.tag.domain.aggregates.TagNameValueObject;
import com.application.springazuredocker.tag.domain.aggregates.TagUuidValueObject;

public class TagDto {
    private TagUuidValueObject uuid;
    private TagNameValueObject name;
    private TagColorValueObject color;
    private String description;
    public String getUuid() {
        return uuid.value;
    }
    public String getName() {
        return name.value;
    }
    public String getColor() {
        return color.value;
    }
    public String getDescription() { return description; }
    public TagDto() {}
    public TagDto(String uuid, String name, String color, String description) throws InvalidArgumentException {
        this.uuid = new TagUuidValueObject(uuid);
        this.name = new TagNameValueObject(name);
        this.color = new TagColorValueObject(color);
        this.description = description;
    }
}
