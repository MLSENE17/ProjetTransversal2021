package com.api.projettransversal.validation.api;

import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.validation.Service.ValidationService;
import com.api.projettransversal.validation.Entity.Validation;
import com.api.projettransversal.validation.api.request.ValidationProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( Utils.validation)
public class ValidationController {
    @Autowired
    private ValidationService validationService;
    @GetMapping("/{id}")
    public List<ValidationProjection> getAll(@Valid @PathVariable  Long id){
        return this.validationService.getAll(id);
    }
}
