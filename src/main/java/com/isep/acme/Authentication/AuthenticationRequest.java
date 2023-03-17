package com.isep.acme.Authentication;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class AuthenticationRequest {

    @NotNull
    @Email
    String username;
    @NotNull
    String password;
}
