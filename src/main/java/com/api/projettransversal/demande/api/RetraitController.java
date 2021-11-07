package com.api.projettransversal.demande.api;

import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.demande.api.request.RetraitProjection;
import com.api.projettransversal.demande.service.RetraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(Utils.retrait)
public class RetraitController {
    @Autowired
    private RetraitService retraitService;
    @GetMapping("/{id}")
    public Optional<RetraitProjection> getOne(@Valid @PathVariable Long id){
        return retraitService.getOne(id);
    }
    @GetMapping("save/{id}/{cni}/{numero}")
    public Map<String, String> create(@Valid @PathVariable Long id,
                                      @Valid @PathVariable String cni,
                                      @Valid @PathVariable String numero){
        return retraitService.update(
                id,
                cni,
                numero
        );
    }
}
