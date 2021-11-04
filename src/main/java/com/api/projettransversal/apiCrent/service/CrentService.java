package com.api.projettransversal.apiCrent.service;

import com.api.projettransversal.apiCrent.entity.Crent;

import java.util.Optional;

public interface CrentService {
    Optional<Crent> getOne(long cni);
}
