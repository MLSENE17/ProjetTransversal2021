package com.api.projettransversal.placeSignatory.service;

import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.placeSignatory.api.request.PlaceSignatorRequest;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

public interface PlaceSignatorService {
    PlaceSignatory createPlace(PlaceSignatory placeSignator);
    Optional<PlaceSignatory> getOne(Long id);

    List<PlaceSignatory> getAll();

    List<PlaceSignatory> createAll(List<PlaceSignatorRequest> placeSignatorRequest);
}
