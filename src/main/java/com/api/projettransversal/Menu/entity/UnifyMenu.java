package com.api.projettransversal.Menu.entity;

import com.api.projettransversal.Role.entity.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="menus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnifyMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String nameRoute;
    @ManyToOne(fetch=FetchType.EAGER)
    private Role role;

}
