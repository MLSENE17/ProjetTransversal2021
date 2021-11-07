package com.api.projettransversal.secretaire.api;

import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.secretaire.service.SecretaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( Utils.secretaire)
public class SecretaireController {
    @Autowired
    private SecretaireService secretaireService;
    @GetMapping("/{etudiant}")
    public List<Map<String, Object>> getCours(@Valid @PathVariable String etudiant){
        return secretaireService.getAll(etudiant);
    }
    @GetMapping("/valide/{demande}/{etudiant}")
    public Map<String,Object> getAll(@Valid @PathVariable Long demande,@Valid @PathVariable String etudiant){
        return secretaireService.getAllSign(demande,etudiant);
    }
    @GetMapping("/demande/{demande}")
    public Map<String,String> getAll(@Valid @PathVariable Long demande){
        return secretaireService.valid(demande);
    }
}
