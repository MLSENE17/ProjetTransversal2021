package com.api.projettransversal.demande.service;

import com.api.projettransversal.demande.api.request.RetraitProjection;

import java.util.Map;
import java.util.Optional;

public interface RetraitService {
    Optional<RetraitProjection> getOne(Long demande);
    Map<String,String> update(Long id,String cni,String numero);
}
