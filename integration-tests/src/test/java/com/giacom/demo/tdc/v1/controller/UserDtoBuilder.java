package com.giacom.demo.tdc.v1.controller;

import com.giacom.demo.tdc.v1.dto.UserDTO;

public class UserDtoBuilder {

    private UserDTO dto;

    private UserDtoBuilder() {
    }

    public static UserDtoBuilder create() {
        UserDtoBuilder builder = new UserDtoBuilder();
        builder.dto = new UserDTO();
        builder.dto.setName("name");
        builder.dto.setLastName("last name");
        return builder;
    }

    public UserDtoBuilder withName(String name) {
        dto.setName(name);
        return this;
    }

    public UserDtoBuilder withId(String id) {
        dto.setId(id);
        return this;
    }

    public UserDtoBuilder withLastName(String lastName) {
        dto.setLastName(lastName);
        return this;
    }

    public UserDtoBuilder withAge(int age) {
        dto.setAge(age);
        return this;
    }


    public UserDTO build() {
        return dto;
    }
}
