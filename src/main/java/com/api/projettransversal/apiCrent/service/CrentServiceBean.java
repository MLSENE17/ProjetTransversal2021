package com.api.projettransversal.apiCrent.service;

import com.api.projettransversal.apiCrent.api.request.CrentRequest;
import com.api.projettransversal.apiCrent.entity.Crent;
import com.api.projettransversal.apiCrent.repository.CrentRepository;
import com.api.projettransversal.auth.personnel.Exception.PersonnelException;
import com.api.projettransversal.demande.exception.DemandeException;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.placeSignatory.repository.PlaceSignatoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class CrentServiceBean implements CrentService {
    @Autowired
    private CrentRepository crentRepository;
    @Autowired
    private PlaceSignatoryRepository placeSignatoryRepository;
    @Override
    public Optional<Crent> getOne(String etudiant) {
        return crentRepository.findByCni(etudiant.toUpperCase());
    }

    @Override
    public Crent create(CrentRequest crentRequest) {
        PlaceSignatory placeSignatory = placeSignatoryRepository.findById(crentRequest.getPlace()).orElseThrow(
                ()->new DemandeException("place n'existe pas")
        );
        Optional<Crent> crent = crentRepository.findByCni(crentRequest.getNumeroEtudiant().toUpperCase());
        if(!crent.isEmpty()){
            throw  new DemandeException("non trouver");
        }
        Crent crentNew = new Crent();
        crentNew.setCni(crentRequest.getCni());
        crentNew.setPlaceSignatory(placeSignatory);
        crentNew.setNumeroetudiant(crentRequest.getNumeroEtudiant().toUpperCase());
        crentNew.setDateNaissance(crentRequest.getDateNaissance());
        crentNew.setEmail(crentRequest.getEmail());
        crentNew.setNom(crentRequest.getNom());
        crentNew.setPrenom(crentRequest.getPrenom());
        return crentRepository.save(crentNew);
    }
}
