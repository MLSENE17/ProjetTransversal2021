package com.api.projettransversal.apiCrent.service;

import com.api.projettransversal.apiCrent.entity.Crent;
import com.api.projettransversal.apiCrent.repository.CrentRepository;
import com.api.projettransversal.auth.personnel.Exception.PersonnelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrentServiceBean implements CrentService {
    @Autowired
    private CrentRepository crentRepository;
    @Override
    public Optional<Crent> getOne(long cni) {
        return crentRepository.findByCni(cni);
    }
}
