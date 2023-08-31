package com.application.springazuredocker.user.domain.model;

import com.application.springazuredocker.shared.domain.aggregates.UuidV3ValueObject;
import com.application.springazuredocker.user.domain.aggregates.*;

public class UserDto {
    private UuidV3ValueObject    uuid;
    private UserNameValueObject  name;
    private UserEmailValueObject email;
    private UserPassword         password;
    private UserRoleValueObject  role;
    private UserPhoneValueObject phone;
    private String avatar;
    public UuidV3ValueObject getUuid() {
        return uuid;
    }
    public UserNameValueObject getName() {
        return name;
    }
    public UserEmailValueObject getEmail() {
        return email;
    }
    public UserPassword getPassword() {
        return password;
    }
    public UserRoleValueObject getRole() {
        return role;
    }
    public UserPhoneValueObject getPhone() {
        return phone;
    }
    public String getAvatar() {
        return avatar;
    }
    public UserDto(UuidV3ValueObject uuid, UserNameValueObject name, UserEmailValueObject email, UserPassword password, UserRoleValueObject role, UserPhoneValueObject phone, String avatar) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.avatar = avatar;
    }
    public UserDto() {
    }
}
