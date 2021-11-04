package com.api.projettransversal.auth.etudiant.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterModelEtudiant {
    @NotNull
    @NotBlank
    private String numeroTelephone;
    @NotNull
    @NotBlank
    private String cni;
    @NotNull
    @NotBlank
    private LocalDate dateNaissance;
    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @Email
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private Long place;
    @NotNull
    @NotBlank
    private String numeroEtudiant;
    @NotNull
    @NotBlank
    private String option;
}
