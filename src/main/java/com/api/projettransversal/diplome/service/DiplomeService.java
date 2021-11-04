package com.api.projettransversal.diplome.service;

import com.api.projettransversal.diplome.entity.Diplome;

import java.util.List;
import java.util.Optional;

public interface DiplomeService {
    Diplome create(Diplome dp);
    List<Diplome> getAll();
    Optional<Diplome> getOne(Long id);
}
