package com.api.projettransversal.Menu.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class RoleSearch {
    @NotNull
    @NotBlank
    private String role;
}
