package com.api.projettransversal.demande.service;

import com.api.projettransversal.demande.api.request.RetraitProjection;
import com.api.projettransversal.demande.entity.Retrait;
import com.api.projettransversal.demande.repository.RetraitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RetraitServiceImpl implements RetraitService {
    @Autowired
    private RetraitRepository retraitRepository;
    @Override
    public Optional<RetraitProjection> getOne(Long demande) {
        Optional<RetraitProjection> optionalRetraitProjection = retraitRepository.findRetrait(demande);
        return optionalRetraitProjection;
    }

    @Override
    public Map<String, String> update(Long id, String cni, String numero) {
        Retrait retrait=retraitRepository.findDemande(id);
        if(retrait!=null){
        retrait.setNumero(numero);
        retrait.setCni(cni);
        retraitRepository.save(retrait);
        }
        Map<String,String> map=new HashMap<>();
        map.put("update","update");
        return map;
    }
}
