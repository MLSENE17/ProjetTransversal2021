package com.api.projettransversal.Role.entity;

import com.api.projettransversal.Role.ERole;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="roles")
@Data
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Enumerated(EnumType.STRING)
    private ERole name;
    public Role(){

    }
    public Role(ERole name){
        this.name=name;
    }
}
