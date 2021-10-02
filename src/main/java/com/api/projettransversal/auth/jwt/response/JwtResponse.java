package com.api.projettransversal.auth.jwt.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private Long id;
    private String token;
    private String email;
    private List<String> roles;
    public JwtResponse() {

    }
    public JwtResponse(String accessToken, Long id, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.email = email;
        this.roles = roles;

    }

}
