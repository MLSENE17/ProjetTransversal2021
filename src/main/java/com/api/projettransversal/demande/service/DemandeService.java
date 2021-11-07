package com.api.projettransversal.demande.service;

import com.api.projettransversal.demande.api.request.DemandeProjection;
import com.api.projettransversal.demande.api.request.DemandeRequest;
import com.api.projettransversal.demande.entity.Demande;

import java.util.List;
import java.util.Map;


public interface DemandeService {
    Demande createDemande(DemandeRequest demandeRequest);
    List<DemandeProjection> getAll(String email);
    List<DemandeProjection> getEnCours(String email);
    Map<String,Long> getTotal();
}
