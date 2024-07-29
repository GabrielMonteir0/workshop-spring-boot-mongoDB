package com.gabriel.demo.cursodb.dto;

import com.gabriel.demo.cursodb.worshopmongodb.User;

import java.io.Serializable;

public class UserDto implements Serializable {
private static final long serialVersionUID = 1l;
    private String name;
    private String email;

    public UserDto() {

    }

    public UserDto(User obj) {
        name = obj.getName();
        email = obj.getEmail();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
