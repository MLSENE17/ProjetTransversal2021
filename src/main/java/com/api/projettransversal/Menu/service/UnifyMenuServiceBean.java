package com.api.projettransversal.Menu.service;

import com.api.projettransversal.Menu.Projection.UnifyMenuProjection;
import com.api.projettransversal.Menu.repository.UnifyMenuRepository;
import com.api.projettransversal.Role.ERole;
import com.api.projettransversal.auth.personnel.Exception.PersonnelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnifyMenuServiceBean implements UnifyMenuService{
    @Autowired
    private UnifyMenuRepository unifyMenuRepository;
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
}
