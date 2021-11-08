package com.api.projettransversal.Menu.service;

import com.api.projettransversal.Menu.Projection.UnifyMenuProjection;
import com.api.projettransversal.Menu.api.request.RoleSearch;
import com.api.projettransversal.Menu.entity.UnifyMenu;


import java.util.List;

public interface UnifyMenuService {
    List<UnifyMenuProjection> getMenus(String role);

    List<UnifyMenu> createAll(List<RoleSearch> roleSearch);

    List<UnifyMenu> getAll();
}
