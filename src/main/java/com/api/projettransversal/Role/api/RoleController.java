package com.api.projettransversal.Role.api;

import com.api.projettransversal.Role.entity.Role;
import com.api.projettransversal.Role.service.RoleService;
import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.placeSignatory.api.request.PlaceSignatorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( Utils.role)
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/all")
    public List<Role> getAll(){
        return roleService.getAll();
    }
    @PostMapping
    public List<Role> createAll(@Valid @RequestBody List<PlaceSignatorRequest> placeSignatorRequest){
        return roleService.createAll(placeSignatorRequest);
    }
}
