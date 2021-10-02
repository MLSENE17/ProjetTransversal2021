package com.api.projettransversal.auth.personnel.entity;

import com.api.projettransversal.Role.entity.Role;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(
        name="personels",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"email"}
        )
)
@Data
//@Where(clause = "deleted = false")
public class Personnel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String email;
    private boolean deleted=false;
    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @ManyToOne(fetch=FetchType.EAGER)
    private PlaceSignatory placeSignatory;
    @CreationTimestamp
    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @UpdateTimestamp
    @Column(name="update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @PreUpdate
    public void setUpdateAt(){
        this.updateAt=new Date();
    }
}
