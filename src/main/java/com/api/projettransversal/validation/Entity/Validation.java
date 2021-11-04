package com.api.projettransversal.validation.Entity;

import com.api.projettransversal.demande.entity.Demande;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.validation.ResponseEnum;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name="validations")
@Data
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @ManyToOne(fetch=FetchType.EAGER)
    private Demande demande;
    @NotNull
    @NotBlank
    @ManyToOne(fetch=FetchType.EAGER)
    private PlaceSignatory placeSignatory;
    @Enumerated(EnumType.STRING)
    private ResponseEnum response;
    @CreationTimestamp
    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @UpdateTimestamp
    @Column(name="update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @Column(nullable = true)
    private String message;
    @PreUpdate
    public void setUpdateAt(){
        this.updateAt=new Date();
    }
}
