package com.api.projettransversal.auth.personnel.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterModel {
    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @NotBlank
    private String email;
    @NotBlank
    private String role;
    @NotBlank
    private Long id;
    private String password;
    private Long place;
}
