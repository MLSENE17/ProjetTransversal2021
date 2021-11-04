package com.api.projettransversal.signataire.api;

import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.signataire.api.Request.MessageRequestSignataire;
import com.api.projettransversal.signataire.api.Request.SearchRequestSignataire;
import com.api.projettransversal.signataire.api.Request.SignataireProjection;
import com.api.projettransversal.signataire.service.SignataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping( Utils.signataire)
public class SignataireController {
    @Autowired
    private SignataireService signataireService;
    @PostMapping
    public List<SignataireProjection> allSign(@Valid @RequestBody SearchRequestSignataire searchRequestSignataire){
      return signataireService.getAll(searchRequestSignataire);
    }
    @GetMapping("/{id}/{place}")
    public  Optional<SignataireProjection> getOne(@Valid @PathVariable Long id,@Valid @PathVariable Long place){
        return signataireService.getOne(id,place);
    }
    @PostMapping("/demande")
    public Map<String,String> allSign(@Valid @RequestBody MessageRequestSignataire messageRequestSignataire){
        return signataireService.signIn(messageRequestSignataire);
    }
}
