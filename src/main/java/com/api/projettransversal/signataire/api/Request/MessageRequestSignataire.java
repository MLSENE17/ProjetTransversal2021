package com.api.projettransversal.signataire.api.Request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class MessageRequestSignataire {
    @NotNull
    @NotBlank
    private Long id;
    @NotNull
    @NotBlank
    private String response;
    private String message;
}
