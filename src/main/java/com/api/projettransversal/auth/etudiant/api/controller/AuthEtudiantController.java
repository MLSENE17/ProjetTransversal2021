package com.api.projettransversal.auth.etudiant.api.controller;

import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.apiCrent.service.CrentService;
import com.api.projettransversal.auth.etudiant.api.request.RegisterModelEtudiant;
import com.api.projettransversal.auth.etudiant.service.AuthEtudiantService;
import com.api.projettransversal.etudiant.entity.Etudiant;
import com.api.projettransversal.etudiant.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(Utils.etudiant)
public class AuthEtudiantController {
    @Autowired
    private AuthEtudiantService authEtudiantService;
    @PostMapping("/signup")
    public Etudiant create(@Valid @RequestBody RegisterModelEtudiant registerModelEtudiant){
        return authEtudiantService.create(registerModelEtudiant);
    }

}
