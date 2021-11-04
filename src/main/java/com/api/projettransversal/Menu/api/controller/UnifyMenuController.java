package com.api.projettransversal.Menu.api.controller;

import com.api.projettransversal.Menu.Projection.UnifyMenuProjection;
import com.api.projettransversal.Menu.api.request.RoleSearch;
import com.api.projettransversal.Menu.service.UnifyMenuService;
import com.api.projettransversal.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
