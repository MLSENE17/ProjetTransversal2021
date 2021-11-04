package com.api.projettransversal.etudiant.service;



import com.api.projettransversal.etudiant.entity.Etudiant;

import java.util.Optional;

public interface EtudiantService {
    Optional<Etudiant> getUser(String email);
}
