package com.api.projettransversal.apiCrent.api.request;

import lombok.Data;

import java.time.LocalDate;


@Data
public class CrentRequest {
    private String cni;
    private LocalDate dateNaissance;
    private String email;
    private String prenom;
    private String nom;
    private String numeroEtudiant;
    private Long place;
}
