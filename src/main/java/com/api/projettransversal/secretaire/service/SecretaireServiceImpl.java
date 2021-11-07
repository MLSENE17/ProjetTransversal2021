package com.api.projettransversal.secretaire.service;

import com.api.projettransversal.demande.api.request.DemandeProjection;
import com.api.projettransversal.demande.api.request.RetraitProjection;
import com.api.projettransversal.demande.entity.Demande;
import com.api.projettransversal.demande.exception.DemandeException;
import com.api.projettransversal.demande.repository.DemandeRepository;
import com.api.projettransversal.demande.repository.RetraitRepository;
import com.api.projettransversal.demande.service.DemandeService;
import com.api.projettransversal.etudiant.entity.Etudiant;
import com.api.projettransversal.etudiant.repository.EtudiantRepository;
import com.api.projettransversal.validation.Repository.ValidationRepository;
import com.api.projettransversal.validation.ResponseEnum;
import com.api.projettransversal.validation.Service.ValidationService;
import com.api.projettransversal.validation.api.request.ValidationProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecretaireServiceImpl implements SecretaireService{
    @Autowired
    private DemandeRepository demandeRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private RetraitRepository retraitRepository;
    @Override
    public List<Map<String, Object>> getAll(String numero) {
        Etudiant etudiant = etudiantRepository.findCniOrNumero(numero);
        if(etudiant==null){
            throw new DemandeException("Etudiant non trouver");
        }
        List<DemandeProjection> demandeRepositoryList=demandeRepository.findAllEtudiantCours(etudiant);
        List<Map<String,Object>> mapResult =new ArrayList<>();
        demandeRepositoryList.forEach(demande->{
            Map<String,Object> map = new HashMap<>();
             map.put("demande",demande);
             boolean trouve = validationRepository.isSecretaire(demande.getId(),ResponseEnum.Accept);
             map.put("all",trouve);
             mapResult.add(map);
        });
        return mapResult;
    }

    @Override
    public Map<String, Object> getAllSign(Long demande, String etudiant) {
        List<ValidationProjection> validationProjections = validationService.getAll(demande,etudiant);
        Optional<RetraitProjection> retraitProjection = retraitRepository.findRetrait(demande);
        Map<String, Object> map=new HashMap<>();
        map.put("signature",validationProjections);
        map.put("retrait",retraitProjection);
        return map;
    }

    @Override
    public Map<String, String> valid(Long demande) {
        Demande demande1=demandeRepository.findById(demande).orElseThrow(
                ()->new DemandeException("demande non trouver")
        );
        demande1.setValide(true);
        demandeRepository.save(demande1);
        Map<String,String> map=new HashMap<>();
        map.put("lamine","lamine");
        return map;
    }
}
