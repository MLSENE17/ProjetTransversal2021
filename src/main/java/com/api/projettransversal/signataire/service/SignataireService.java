package com.api.projettransversal.signataire.service;

import com.api.projettransversal.signataire.api.Request.MessageRequestSignataire;
import com.api.projettransversal.signataire.api.Request.SearchRequestSignataire;
import com.api.projettransversal.signataire.api.Request.SignataireProjection;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SignataireService {
    List<SignataireProjection> getAll(SearchRequestSignataire searchRequestSignataire);

    Optional<SignataireProjection> getOne(Long id, Long place);

    Map<String, String> signIn(MessageRequestSignataire messageRequestSignataire);
}
