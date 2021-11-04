package com.api.projettransversal.auth.personnel.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class UserReq {
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;

}
