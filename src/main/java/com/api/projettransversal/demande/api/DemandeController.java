package com.api.projettransversal.demande.api;

import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.demande.api.request.DemandeProjection;
import com.api.projettransversal.demande.api.request.DemandeRequest;
import com.api.projettransversal.demande.entity.Demande;
import com.api.projettransversal.demande.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Utils.demande)
public class DemandeController {
    @Autowired
    private DemandeService demandeService;
    @GetMapping("/total")
    public Map<String,Long> getTotal(){
        return demandeService.getTotal();
    }
    @PostMapping
    public Demande createDemande(@Valid @RequestBody DemandeRequest demandeRequest){
       return  demandeService.createDemande(demandeRequest);
    }
    @GetMapping("/all/{email}")
    public List<DemandeProjection> getAll(@Valid @PathVariable String email){
            return  demandeService.getAll(email);
    }
    @GetMapping("/encours/{email}")
    public List<DemandeProjection> getCours(@Valid @PathVariable String email){
        return  demandeService.getEnCours(email);
    }
}
