package com.api.projettransversal.signataire.service;

import com.api.projettransversal.signataire.api.Request.MessageRequestSignataire;
import com.api.projettransversal.signataire.api.Request.SearchRequestSignataire;
import com.api.projettransversal.signataire.api.Request.SignataireProjection;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.placeSignatory.repository.PlaceSignatoryRepository;
import com.api.projettransversal.signataire.exception.SignataireException;
import com.api.projettransversal.validation.Entity.Validation;
import com.api.projettransversal.validation.Repository.ValidationRepository;
import com.api.projettransversal.validation.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SignataireServiceBean implements SignataireService {
    @Autowired
    private PlaceSignatoryRepository placeSignatoryRepository;
    @Autowired
    private ValidationRepository validationRepository;
    @Override
    public List<SignataireProjection> getAll(SearchRequestSignataire searchRequestSignataire) {
        PlaceSignatory placeSignatory = placeSignatoryRepository.findById(searchRequestSignataire.getId()).orElseThrow(
                ()->new SignataireException("Place non trouver")
        );
        ResponseEnum responseEnum=null;
        if(searchRequestSignataire.getStatus()!=null) {
            switch (searchRequestSignataire.getStatus()) {
                case "Accept":
                    responseEnum = ResponseEnum.Accept;
                    break;
                case "Refuse":
                    responseEnum = ResponseEnum.Refuse;
                    break;
                case "Waiting":
                    responseEnum = ResponseEnum.Waiting;
                    break;
            }
        }
        List<SignataireProjection> signataireProjections=validationRepository.AllBySign(
                placeSignatory,
                searchRequestSignataire.getNumero()!=null?searchRequestSignataire.getNumero().toUpperCase():null,
                responseEnum
        );
        return signataireProjections;
    }

    @Override
    public Optional<SignataireProjection> getOne(Long id, Long place) {
        PlaceSignatory placeSignatory = placeSignatoryRepository.findById(place).orElseThrow(
                ()->new SignataireException("Place non trouver")
        );
        return this.validationRepository.getOne(id,placeSignatory);
    }

    @Override
    public Map<String, String> signIn(MessageRequestSignataire messageRequestSignataire) {
        ResponseEnum responseEnum=null;
        switch (messageRequestSignataire.getResponse()) {
            case "Accept":
                responseEnum = ResponseEnum.Accept;
                break;
            case "Refuse":
                responseEnum = ResponseEnum.Refuse;
                break;
            case "Waiting":
                responseEnum = ResponseEnum.Waiting;
                break;
            default:throw new SignataireException("non trouver");
        }
        Validation validation=validationRepository.findById(messageRequestSignataire.getId()).orElseThrow(
                ()->new ValidationException("non trouver")
        );
        validation.setResponse(responseEnum);
        validation.setMessage(messageRequestSignataire.getMessage());
        validationRepository.save(validation);
        Map<String,String> map = new HashMap<>();
        map.put("ibou","ibou");
        return map;
    }
}
