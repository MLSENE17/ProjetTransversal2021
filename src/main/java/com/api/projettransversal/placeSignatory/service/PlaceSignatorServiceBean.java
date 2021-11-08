package com.api.projettransversal.placeSignatory.service;

import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.placeSignatory.api.request.PlaceSignatorRequest;
import com.api.projettransversal.placeSignatory.repository.PlaceSignatoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceSignatorServiceBean implements  PlaceSignatorService {
    @Autowired
    private PlaceSignatoryRepository placeSignatoryRepository;
    @Override
    public PlaceSignatory createPlace(PlaceSignatory placeSignator) {
        return this.placeSignatoryRepository.save(placeSignator);
    }
    @Override
    public Optional<PlaceSignatory> getOne(Long id) {
        return placeSignatoryRepository.findById(id);
    }

    @Override
    public List<PlaceSignatory> getAll() {
        Long id = new Long(1);
        return this.placeSignatoryRepository.getAllPlace(id);
    }

    @Override
    public List<PlaceSignatory> createAll(List<PlaceSignatorRequest> placeSignatorRequest) {
        List<PlaceSignatory> placeSignatoryList = new ArrayList<>();
        placeSignatorRequest.forEach(item->{
            PlaceSignatory placeSignatory = new PlaceSignatory();
            placeSignatory.setNamePlace(item.getName());
            placeSignatoryList.add(placeSignatory);
        });
        return placeSignatoryRepository.saveAll(placeSignatoryList);
    }
}
