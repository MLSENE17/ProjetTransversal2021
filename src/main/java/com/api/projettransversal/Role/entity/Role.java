package com.api.projettransversal.Role.entity;

import com.api.projettransversal.Role.ERole;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="roles",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"name"}
        )
)
@Data
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private ERole name;
    public Role(){

    }
    public Role(ERole name){
        this.name=name;
    }
}
