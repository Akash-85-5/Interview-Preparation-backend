package com.interview_preparation_portal.dto;

public class AuthResponse {

    private String token;

    private Long id;

    private String name;

    public AuthResponse(
            String token,
            Long id,
            String name) {

        this.token = token;
        this.id = id;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}