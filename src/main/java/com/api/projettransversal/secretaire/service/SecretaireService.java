package com.api.projettransversal.secretaire.service;

import java.util.List;
import java.util.Map;

public interface SecretaireService {
    List<Map<String, Object>> getAll(String numero);

    Map<String, Object> getAllSign(Long demande, String etudiant);

    Map<String, String> valid(Long demande);
}
