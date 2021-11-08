package com.api.projettransversal.Role.service;

import com.api.projettransversal.Role.ERole;
import com.api.projettransversal.Role.entity.Role;
import com.api.projettransversal.Role.repository.RoleRepository;
import com.api.projettransversal.auth.personnel.Exception.PersonnelException;
import com.api.projettransversal.placeSignatory.api.request.PlaceSignatorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements  RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> createAll(List<PlaceSignatorRequest> placeSignatorRequest) {
        List<Role> roleList = new ArrayList<>();
        placeSignatorRequest.forEach(item->{
            Role role=new Role();
            switch (item.getName()){
                case "ADMIN":
                    role.setName(ERole.ROLE_ADMIN);
                    break;
                case "SECRETAIRE":
                    role.setName(ERole.ROLE_SECRETAIRE);
                    break;
                case "SIGNATAIRE":
                    role.setName(ERole.ROLE_SIGNATAIRE);
                    break;
                case "ETUDIANT":
                    role.setName(ERole.ROLE_ETUDIANT);
                    break;
                default:throw new PersonnelException("aJOUTER AU MOINS une role");
            }
            roleList.add(role);
        });
        return roleRepository.saveAll(roleList);
    }
}
