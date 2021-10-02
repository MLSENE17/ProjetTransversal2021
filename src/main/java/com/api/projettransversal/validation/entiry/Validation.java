package com.api.projettransversal.validation.entiry;

import com.api.projettransversal.demande.entity.Demande;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.validation.ResponseEnum;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity(name="validations")
@Data
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.EAGER)
    private Demande demande;
    @ManyToOne(fetch=FetchType.EAGER)
    private PlaceSignatory placeSignatory;
    @Enumerated(EnumType.STRING)
    private ResponseEnum response=ResponseEnum.Waiting;
    @CreationTimestamp
    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @UpdateTimestamp
    @Column(name="update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    private boolean valide=false;
    @PreUpdate
    public void setUpdateAt(){
        this.updateAt=new Date();
    }
}
