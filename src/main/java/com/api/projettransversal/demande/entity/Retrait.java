package com.api.projettransversal.demande.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="retraits")
@Data
public class Retrait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    private Demande demande;
    @NotNull
    @NotBlank
    private String cni;
    @NotNull
    @NotBlank
    private String numero;
}
