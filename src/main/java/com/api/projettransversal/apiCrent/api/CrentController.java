package com.api.projettransversal.apiCrent.api;

import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.apiCrent.api.request.CrentRequest;
import com.api.projettransversal.apiCrent.entity.Crent;
import com.api.projettransversal.apiCrent.service.CrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(Utils.crent)
public class CrentController {
    @Autowired
    private CrentService crentService;
    @GetMapping("/{etudiant}")
    public Optional<Crent> getOne(@Valid @PathVariable String etudiant){
        return  crentService.getOne(etudiant);
    }
    @PostMapping
    public Crent creatOne(@Valid @RequestBody CrentRequest crentRequest){
        return  crentService.create(crentRequest);
    }
}
