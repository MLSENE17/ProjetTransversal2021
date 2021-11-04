package com.api.projettransversal.diplome.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiplomeRequest {
    @NotBlank
    private String nameDiplome;
}
