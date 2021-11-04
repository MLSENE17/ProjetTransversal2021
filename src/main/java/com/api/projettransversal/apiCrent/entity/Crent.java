package com.api.projettransversal.apiCrent.entity;

import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="crent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @ManyToOne(fetch=FetchType.EAGER)
    private PlaceSignatory placeSignatory;
    private long cni;
    private String numeroetudiant;
    private String prenom;
    private String nom;
    private LocalDate dateNaissance;
}
