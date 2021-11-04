package com.api.projettransversal.etudiant.api;

import com.api.projettransversal.Menu.service.UnifyMenuService;
import com.api.projettransversal.Utils.Utils;
import com.api.projettransversal.etudiant.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(Utils.etudiants)
public class EtudiantController {
    @Autowired
    private UnifyMenuService unifyMenuService;
    @Autowired
    private EtudiantService etudiantService;
    @GetMapping("/getUser")
    public Map<String,Object> getUser(@Valid @RequestParam String email, @RequestParam String role){
        Map<String,Object> exec = new HashMap<String,Object>();
        exec.put("user",etudiantService.getUser(email));
        exec.put("menu",unifyMenuService.getMenus(role));
        return exec;
    }
}
