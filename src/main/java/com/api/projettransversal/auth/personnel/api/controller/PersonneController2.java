package com.api.projettransversal.auth.personnel.api.controller;

import com.api.projettransversal.Menu.service.UnifyMenuService;
import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.auth.personnel.Exception.PersonnelException;
import com.api.projettransversal.auth.personnel.api.request.RegisterModel;
import com.api.projettransversal.auth.personnel.entity.Personnel;
import com.api.projettransversal.auth.personnel.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(Utils.personnel2)
public class PersonneController2 {
    @Autowired
    PersonnelService personnelService;
    @Autowired
    private UnifyMenuService unifyMenuService;
    @GetMapping()
    public Map<String,Object> getUser(@Valid @RequestParam  String email,@RequestParam String role){
        Map<String,Object> exec = new HashMap<String,Object>();
        exec.put("user",personnelService.getUser(email));
        exec.put("menu",unifyMenuService.getMenus(role));
        return exec;
    }
}
