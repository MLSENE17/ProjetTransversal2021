package com.api.projettransversal.placeSignatory.Entity;

import com.api.projettransversal.Role.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="placeSignatories",
    uniqueConstraints = @UniqueConstraint(
            columnNames = {"name_place"}
    )
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceSignatory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5)
    @Column(name="name_place")
    private String namePlace;
}
