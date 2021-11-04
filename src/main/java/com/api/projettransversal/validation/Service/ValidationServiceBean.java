package com.api.projettransversal.validation.Service;

import com.api.projettransversal.demande.entity.Demande;
import com.api.projettransversal.demande.exception.DemandeException;
import com.api.projettransversal.demande.repository.DemandeRepository;
import com.api.projettransversal.etudiant.entity.Etudiant;
import com.api.projettransversal.etudiant.repository.EtudiantRepository;
import com.api.projettransversal.validation.Repository.ValidationRepository;

import com.api.projettransversal.validation.ResponseEnum;
import com.api.projettransversal.validation.api.request.ValidationProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class ValidationServiceBean implements ValidationService {
    @Autowired
    private DemandeRepository demandeRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ValidationRepository validationRepository;
    @Override
    public List<ValidationProjection> getAll(Long id,String email){
        Etudiant etudiant = etudiantRepository.findByEmail(email).orElseThrow(
                ()->new DemandeException("etudiant non trouver")
        );
        Optional<Demande> demande =demandeRepository.findIdEmail(id,etudiant);
        if(demande==null) {
           throw  new DemandeException("Cette demande n'existe pas");
        }
        List<ValidationProjection> validationList = validationRepository.getAllValidation(demande.get());
        return validationList;
    }

    @Override
    public Map<String, String> isValid(Long id, String email) {
        Etudiant etudiant = etudiantRepository.findByEmail(email).orElseThrow(
                ()->new DemandeException("etudiant non trouver")
        );
        Optional<Demande> demande =demandeRepository.findIdEmail(id,etudiant);
        if(demande==null) {
            throw  new DemandeException("Cette demande n'existe pas");
        }
        if(!validationRepository.isValid(demande.get(), ResponseEnum.Accept)){
            throw  new DemandeException("Non trouver");
        }
        Map<String,String> map=new HashMap<>();
        map.put("lamine","sene");
        return map;
    }
}
