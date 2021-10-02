package com.api.projettransversal.auth.personnel.api.controller;

import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.auth.personnel.api.request.RegisterModel;
import com.api.projettransversal.auth.personnel.api.request.UserReq;
import com.api.projettransversal.auth.personnel.entity.Personnel;
import com.api.projettransversal.auth.personnel.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
