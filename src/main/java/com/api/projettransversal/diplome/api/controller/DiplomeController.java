package com.api.projettransversal.diplome.api.controller;

import com.api.projettransversal.Email.GmailService;
import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.diplome.api.request.DiplomeRequest;
import com.api.projettransversal.diplome.entity.Diplome;
import com.api.projettransversal.diplome.exception.DiplomeExceptionName;
import com.api.projettransversal.diplome.repository.DiplomeRepository;
import com.api.projettransversal.diplome.service.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Utils.diplome)
public class DiplomeController {
    @Autowired
    private DiplomeService diplomeService;
    @Autowired
    private DiplomeRepository diplomeRepository;
    @GetMapping("/all")
    public List<Diplome> getAll(){
       return diplomeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Diplome> getOne(@Valid @PathVariable Long id){
        return  diplomeService.getOne(id);
    }
    @PreAuthorize("hasRole('ADMIN' )")
    @PostMapping("/create")
    public Diplome create(@Valid @RequestBody DiplomeRequest diplomeRequest)  {
        if(diplomeRepository.existsByName(diplomeRequest.getNameDiplome())){
            throw new DiplomeExceptionName("Cette diplome existe deja");
        }
        Diplome dp = new Diplome();
        dp.setNomDiplome(diplomeRequest.getNameDiplome());
        return  diplomeService.create(dp);
    }
    @PreAuthorize("hasRole('ADMIN' )")
    @PutMapping("/update/{id}")
    public Diplome update(@Valid @RequestBody DiplomeRequest diplomeRequest,@Valid @PathVariable Long id){
         Diplome dp = diplomeRepository.findById(id).orElseThrow(
                 ()-> new DiplomeExceptionName("Cet diplome n'existe pas")
         );
         dp.setNomDiplome(diplomeRequest.getNameDiplome());
         dp.setUpdateAt(new Date());
         return  diplomeService.create(dp);
    }
}
