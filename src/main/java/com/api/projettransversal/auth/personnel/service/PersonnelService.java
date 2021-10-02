package com.api.projettransversal.auth.personnel.service;

import com.api.projettransversal.auth.personnel.api.request.RegisterModel;
import com.api.projettransversal.auth.personnel.api.request.UserReq;
import com.api.projettransversal.auth.personnel.entity.Personnel;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;


public interface PersonnelService {
    Personnel create(RegisterModel registerModel);
    ResponseEntity<?> sigin( UserReq userReq);
    void deleteUser(Long id);
}
