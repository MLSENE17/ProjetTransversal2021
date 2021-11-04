package com.api.projettransversal.auth.personnel.service;

import com.api.projettransversal.auth.AllUser.entity.User;
import com.api.projettransversal.auth.personnel.api.request.ProjectionPersonnel;
import com.api.projettransversal.auth.personnel.api.request.RegisterModel;
import com.api.projettransversal.auth.personnel.api.request.UserReq;
import com.api.projettransversal.auth.personnel.entity.Personnel;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface PersonnelService {
    Personnel create(RegisterModel registerModel);
    ResponseEntity<?> sigin( UserReq userReq);
    User deleteUser(Long id, String email);
    Optional<Personnel> getUser(String email);
    List<ProjectionPersonnel> getAll();
}
