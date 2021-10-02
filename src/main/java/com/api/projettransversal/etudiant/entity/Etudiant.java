package com.api.projettransversal.etudiant.entity;

import com.api.projettransversal.Role.entity.Role;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="etudiants",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"email",
                        "numero_telephone",
                        "cni",
                        "numero_etudiant"
                }
        )
)
@Data
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String prenom;
    @NotNull
    @NotBlank
    private String nom;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private long cni;
    @NotNull
    @NotBlank
    @Column(name="numero_etudiant",nullable = false)
    private String numeroEtudiant;
    @ManyToOne(fetch = FetchType.EAGER)
    private PlaceSignatory placeSignatory;
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
    @NotNull
    @NotBlank
    @Column(name="date_naissance",nullable = false)
    private LocalDate dateNaissance;
    @NotNull
    @NotBlank
    @Column(name="numero_telephone",nullable = false)
    private String numeroTelephone;
    @NotNull
    @NotBlank
    private String option;
    @CreationTimestamp
    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @UpdateTimestamp
    @Column(name="update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    public Etudiant(){

    }
    @PreUpdate
    public void setUpdateAt(){
        this.updateAt=new Date();
    }

}
