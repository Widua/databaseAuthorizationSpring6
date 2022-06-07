package me.widua.databaseauthorizationspring6.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterModel {

    private String username;
    private String password;
    private String confirmPassword;

}
