package com.api.projettransversal.auth.personnel.api.request;


import com.api.projettransversal.Role.ERole;
import com.api.projettransversal.Role.entity.Role;

import java.util.HashSet;


public interface ProjectionPersonnel {
    Long getId();
    String getEmail();
    String getNom();
    String getPrenom();
    String getPlace();
}
