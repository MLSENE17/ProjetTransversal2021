package com.api.projettransversal.Menu.service;

import com.api.projettransversal.Menu.Projection.UnifyMenuProjection;



import java.util.List;

public interface UnifyMenuService {
    List<UnifyMenuProjection> getMenus(String role);
}
