package com.api.projettransversal.etudiant.service;

import com.api.projettransversal.etudiant.entity.Etudiant;
import com.api.projettransversal.etudiant.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EtudiantServiceBean implements EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public Optional<Etudiant> getUser(String email) {
        return etudiantRepository.findByEmail(email);
    }
}
