package com.api.projettransversal.Menu.api.controller;

import com.api.projettransversal.Menu.Projection.UnifyMenuProjection;
import com.api.projettransversal.Menu.api.request.RoleSearch;
import com.api.projettransversal.Menu.entity.UnifyMenu;
import com.api.projettransversal.Menu.service.UnifyMenuService;
import com.api.projettransversal.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Utils.menu)
public class UnifyMenuController {
    @Autowired
    private UnifyMenuService unifyMenuService;
    @PostMapping("/menus")
    public List<UnifyMenuProjection> getMenus(@Valid @RequestBody RoleSearch roleSearch){
        return  unifyMenuService.getMenus(roleSearch.getRole());
    }
    @PostMapping
    public List<UnifyMenu> createAll(@Valid @RequestBody List<RoleSearch> roleSearch){
        return  unifyMenuService.createAll(roleSearch);
    }
    @GetMapping("/all")
    public List<UnifyMenu> getAll(){
        return  unifyMenuService.getAll();
    }
}
