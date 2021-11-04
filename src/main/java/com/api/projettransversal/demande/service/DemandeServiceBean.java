package com.api.projettransversal.demande.service;

import com.api.projettransversal.demande.api.request.DemandeProjection;
import com.api.projettransversal.demande.api.request.DemandeRequest;
import com.api.projettransversal.demande.entity.Demande;
import com.api.projettransversal.demande.exception.DemandeException;
import com.api.projettransversal.demande.repository.DemandeRepository;
import com.api.projettransversal.diplome.entity.Diplome;
import com.api.projettransversal.diplome.repository.DiplomeRepository;
import com.api.projettransversal.etudiant.entity.Etudiant;
import com.api.projettransversal.etudiant.repository.EtudiantRepository;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.placeSignatory.repository.PlaceSignatoryRepository;
import com.api.projettransversal.validation.Repository.ValidationRepository;
import com.api.projettransversal.validation.ResponseEnum;
import com.api.projettransversal.validation.Entity.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeServiceBean implements DemandeService{
    @Autowired
    private DemandeRepository demandeRepository;
    @Autowired
    private DiplomeRepository diplomeRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private PlaceSignatoryRepository placeSignatoryRepository;
    @Override
    public Demande createDemande(DemandeRequest demandeRequest) {
        Diplome diplome = diplomeRepository.findById(demandeRequest.getDiplome()).orElseThrow(
                ()->new DemandeException("Cet diplome n'existe pas")
        );
        Optional<Etudiant> etudiant = etudiantRepository.findByEmail(demandeRequest.getEmail());
        if(demandeRepository.existDemande(diplome,etudiant.get())){
            throw new DemandeException("Vous avez une demande en cours pour ce Diplome:"+diplome.getNomDiplome()
                    +" Veuillez verifier cette demande en cours");
        }
        Demande demande=new Demande();demande.setEtudiant(etudiant.get());
        demande.setValide(false);
        demande.setDiplome(diplome);
        List<Validation> validationList = new ArrayList<>();
        List<PlaceSignatory> placeSignatoryList = placeSignatoryRepository.getPlaceSigne();
        for(PlaceSignatory pl:placeSignatoryList){
            Validation validation1 = new Validation();
            validation1.setDemande(demande);
            validation1.setResponse(ResponseEnum.Waiting);
            validation1.setPlaceSignatory(pl);
            validationList.add(validation1);
        }
        Validation validation = new Validation();
        validation.setDemande(demande);
        validation.setResponse(ResponseEnum.Waiting);
        validation.setPlaceSignatory(etudiant.get().getPlaceSignatory());
        validationList.add(validation);
        Demande demande1 = demandeRepository.save(demande);
        validationRepository.saveAll(validationList);
        return demande1 ;
    }

    @Override
    public List<DemandeProjection> getAll(String email) {
        Etudiant etudiant = etudiantRepository.findByEmail(email).orElseThrow(
                ()->new DemandeException("email non trouver")
        );
        List<DemandeProjection> demandeProjectionList=demandeRepository.findAllEtudiant(etudiant);
        return demandeProjectionList;
    }

    @Override
    public List<DemandeProjection> getEnCours(String email) {

        Etudiant etudiant = etudiantRepository.findByEmail(email).orElseThrow(
                ()->new DemandeException("email non trouver")
        );
        List<DemandeProjection> demandeProjectionList=demandeRepository.findAllEtudiantCours(etudiant);
        return demandeProjectionList;
    }
}
