package com.api.projettransversal.diplome.service;

import com.api.projettransversal.diplome.entity.Diplome;
import com.api.projettransversal.diplome.repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiplomeServiceBean implements  DiplomeService{
    @Autowired
    private DiplomeRepository diplomeRepository;
    @Override
    public Diplome create(Diplome dp) {
        return  this.diplomeRepository.save(dp);
    }
    @Override
    public List<Diplome> getAll() {
        return this.diplomeRepository.findAll();
    }

    @Override
    public Optional<Diplome> getOne(Long id) {
        return this.diplomeRepository.findById(id);
    }
}
