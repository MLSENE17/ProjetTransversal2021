package com.api.projettransversal.auth.personnel.api.controller;

import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.auth.AllUser.entity.User;
import com.api.projettransversal.auth.personnel.api.request.ProjectionPersonnel;
import com.api.projettransversal.auth.personnel.api.request.RegisterModel;
import com.api.projettransversal.auth.personnel.api.request.UserReq;
import com.api.projettransversal.auth.personnel.entity.Personnel;
import com.api.projettransversal.auth.personnel.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Utils.personnel)
public class PersonnelController {
    @Autowired
    PersonnelService personnelService;
    @PostMapping("/signup")
    public Personnel create(@Valid @RequestBody RegisterModel registerModel){
        return personnelService.create(registerModel);
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@Valid @RequestBody UserReq userReq){
        return  personnelService.sigin(userReq);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<ProjectionPersonnel> create(){
        return personnelService.getAll();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}/{email}")
    public User delete(@Valid @PathVariable Long id, @PathVariable String email){
        return  personnelService.deleteUser(id,email);
    }
}
