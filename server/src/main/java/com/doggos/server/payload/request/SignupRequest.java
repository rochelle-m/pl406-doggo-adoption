package com.doggos.server.payload.request;

import java.util.Set;

public class SignupRequest {
    private String username;

    private String email;

    private Set<String> roles;

    private String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return this.roles;
    }
}
