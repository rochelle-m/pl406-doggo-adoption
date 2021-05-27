package com.doggos.server.payload.request;

import org.springframework.lang.Nullable;

import java.util.Set;

public class SignupRequest {
    private String username;

    private String email;

    private Set<String> roles;

    private String password;

    @Nullable
    private String volunteerRole;

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

    public String getVolunteerRole() {
        return volunteerRole;
    }
}
