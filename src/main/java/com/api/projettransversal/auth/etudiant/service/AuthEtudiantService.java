package com.api.projettransversal.auth.etudiant.service;

import com.api.projettransversal.auth.etudiant.api.request.RegisterModelEtudiant;
import com.api.projettransversal.auth.personnel.api.request.UserReq;
import com.api.projettransversal.etudiant.entity.Etudiant;
import org.springframework.http.ResponseEntity;

public interface AuthEtudiantService {
    Etudiant create(RegisterModelEtudiant registerModelEtudiant);
}
