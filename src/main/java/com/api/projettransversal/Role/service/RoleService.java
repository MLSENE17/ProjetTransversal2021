package com.api.projettransversal.Role.service;

import com.api.projettransversal.Role.entity.Role;
import com.api.projettransversal.placeSignatory.api.request.PlaceSignatorRequest;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    List<Role> createAll(List<PlaceSignatorRequest> placeSignatorRequest);
}
