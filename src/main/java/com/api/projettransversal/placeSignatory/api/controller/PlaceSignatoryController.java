package com.api.projettransversal.placeSignatory.api.controller;

import com.api.projettransversal.Role.ERole;
import com.api.projettransversal.Role.entity.Role;
import com.api.projettransversal.Role.repository.RoleRepository;
import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.placeSignatory.api.request.PlaceSignatorRequest;
import com.api.projettransversal.placeSignatory.exception.PlaceSignatorExist;
import com.api.projettransversal.placeSignatory.repository.PlaceSignatoryRepository;
import com.api.projettransversal.placeSignatory.service.PlaceSignatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping( Utils.placeSignator)
@PreAuthorize("hasRole('ADMIN')")
public class PlaceSignatoryController {
    @Autowired
    private PlaceSignatoryRepository placeSignatoryRepository;
    @Autowired
    PlaceSignatorService placeSignatorService;
    @PostMapping("/create")
    public PlaceSignatory create(@Valid @RequestBody PlaceSignatorRequest placeSignatorRequest){
        if(placeSignatoryRepository.existsByName(placeSignatorRequest.getName())){
            throw  new PlaceSignatorExist("cette place existe deja");
        }
        PlaceSignatory placeSignatory = new PlaceSignatory(
                null,
                placeSignatorRequest.getName()
        );
        return this.placeSignatorService.createPlace(placeSignatory);
    }
    @PutMapping("/update/{id}")
    public PlaceSignatory update(@Valid  @PathVariable Long id, @RequestBody PlaceSignatorRequest placeSignatorRequest){

        PlaceSignatory placeSignatory = this.placeSignatorService.getOne(id).orElseThrow(
                ()-> new PlaceSignatorExist("Cet id n'existe pas ")
        );
        placeSignatory.setNamePlace(placeSignatorRequest.getName());
        return this.placeSignatorService.createPlace(placeSignatory);
    }
    @GetMapping("/{id}")
    public Optional<PlaceSignatory> getOne(@Valid  @PathVariable  Long id){
        return this.placeSignatorService.getOne(id);
    }
    @GetMapping("/all")
    public List<PlaceSignatory> getAll(){
        return this.placeSignatorService.getAll();
    }
}
