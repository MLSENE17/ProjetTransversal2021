package com.api.projettransversal.diplome.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="diplomes",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"nom_diplome"}
        )
)
@Data
public class Diplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name="nom_diplome",nullable = false)
    private String nomDiplome;
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
