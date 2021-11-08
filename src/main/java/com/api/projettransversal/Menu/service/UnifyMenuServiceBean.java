package com.api.projettransversal.Menu.service;

import com.api.projettransversal.Menu.Projection.UnifyMenuProjection;
import com.api.projettransversal.Menu.api.request.RoleSearch;
import com.api.projettransversal.Menu.entity.UnifyMenu;
import com.api.projettransversal.Menu.repository.UnifyMenuRepository;
import com.api.projettransversal.Role.ERole;
import com.api.projettransversal.Role.entity.Role;
import com.api.projettransversal.Role.repository.RoleRepository;
import com.api.projettransversal.auth.personnel.Exception.PersonnelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UnifyMenuServiceBean implements UnifyMenuService{
    @Autowired
    private UnifyMenuRepository unifyMenuRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<UnifyMenuProjection> getMenus(String role) {
        switch (role){
            case "ROLE_ETUDIANT" :
                return unifyMenuRepository.findByRole(ERole.ROLE_ETUDIANT);
            case "ROLE_SIGNATAIRE" :
                return unifyMenuRepository.findByRole(ERole.ROLE_SIGNATAIRE);
            case "ROLE_SECRETAIRE" :
                return unifyMenuRepository.findByRole(ERole.ROLE_SECRETAIRE);
            case "ROLE_ADMIN" :
                return unifyMenuRepository.findByRole(ERole.ROLE_ADMIN);
        }
        throw new PersonnelException("cette role n'existe pas");
    }

    @Override
    public List<UnifyMenu> createAll(List<RoleSearch> roleSearch) {
        List<UnifyMenu> unifyMenuList = new ArrayList<>();
        roleSearch.forEach(item->{
            UnifyMenu unifyMenu = new UnifyMenu();
            unifyMenu.setIcon(item.getIcon());
            unifyMenu.setName(item.getName());
            unifyMenu.setNameRoute(item.getNameRoute());
            Role role=new Role();
            switch (item.getRole()){
                case "ADMIN":
                    role = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(
                            ()->new PersonnelException("role n'existe pas")
                    );
                    break;
                case "SECRETAIRE":
                    role = roleRepository.findByName(ERole.ROLE_SECRETAIRE).orElseThrow(
                            ()->new PersonnelException("role n'existe pas")
                    );
                    break;
                case "SIGNATAIRE":
                    role = roleRepository.findByName(ERole.ROLE_SIGNATAIRE).orElseThrow(
                            ()->new PersonnelException("role n'existe pas")
                    );

                    break;
                case "ETUDIANT":
                    role = roleRepository.findByName(ERole.ROLE_ETUDIANT).orElseThrow(
                            ()->new PersonnelException("role n'existe pas")
                    );
                    break;
                default:throw new PersonnelException("aJOUTER AU MOINS une role");
            }
            unifyMenu.setRole(role);
            unifyMenuList.add(unifyMenu);
        });
        return unifyMenuRepository.saveAll(unifyMenuList);
    }

    @Override
    public List<UnifyMenu> getAll() {
        return unifyMenuRepository.findAll();
    }
}
