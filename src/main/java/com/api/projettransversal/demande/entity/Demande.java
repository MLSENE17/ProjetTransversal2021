package com.api.projettransversal.demande.entity;

import com.api.projettransversal.diplome.entity.Diplome;
import com.api.projettransversal.etudiant.entity.Etudiant;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="demandes")
@Data
public class Demande {
    @Id @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id",updatable = false,nullable = false)
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Etudiant etudiant;
    @ManyToOne(fetch = FetchType.EAGER)
    private Diplome diplome;
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
