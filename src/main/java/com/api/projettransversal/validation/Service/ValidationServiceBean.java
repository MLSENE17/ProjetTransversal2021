package com.api.projettransversal.validation.Service;

import com.api.projettransversal.demande.entity.Demande;
import com.api.projettransversal.demande.exception.DemandeException;
import com.api.projettransversal.demande.repository.DemandeRepository;
import com.api.projettransversal.validation.Repository.ValidationRepository;

import com.api.projettransversal.validation.api.request.ValidationProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ValidationServiceBean implements ValidationService {
    @Autowired
    private DemandeRepository demandeRepository;
    @Autowired
    private ValidationRepository validationRepository;
    @Override
    public List<ValidationProjection> getAll(Long id){
        Demande demande =demandeRepository.findById(id).orElseThrow(
                ()->new DemandeException("Cette demande n'existe pas")
        );
        List<ValidationProjection> validationList = validationRepository.getAllValidation(demande);
        return validationList;
    }
}
