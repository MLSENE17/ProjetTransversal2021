package com.api.projettransversal.signataire.api.Request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SearchRequestSignataire {
    @NotNull
    @NotBlank
    private Long id;
    private String numero;
    private String status;
}
