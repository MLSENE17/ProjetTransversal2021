package com.api.projettransversal.auth.etudiant.service;
import com.api.projettransversal.Role.ERole;
import com.api.projettransversal.Role.entity.Role;
import com.api.projettransversal.Role.repository.RoleRepository;
import com.api.projettransversal.auth.AllUser.entity.User;
import com.api.projettransversal.auth.AllUser.repository.UserRepository;
import com.api.projettransversal.auth.etudiant.api.request.RegisterModelEtudiant;

import com.api.projettransversal.auth.jwt.security.JwtUtils;
import com.api.projettransversal.auth.personnel.Exception.PersonnelException;

import com.api.projettransversal.etudiant.entity.Etudiant;
import com.api.projettransversal.etudiant.repository.EtudiantRepository;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.placeSignatory.service.PlaceSignatorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import java.util.Set;


@Service
public class AuthEtudiantServiceBean implements AuthEtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PlaceSignatorService placeSignatoryService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    @Override
    public Etudiant create(RegisterModelEtudiant registerModel) {
        if(etudiantRepository.existsByEmail(registerModel.getEmail())){
            throw new PersonnelException("Email existe deja");
        }
        if(etudiantRepository.existsByNumero(registerModel.getNumeroEtudiant())){
            throw new PersonnelException("le numero etudiant existe deja");
        }
        if(etudiantRepository.existsByCni(registerModel.getCni())){
            throw new PersonnelException("le numero cni existe existe deja");
        }
        if(etudiantRepository.existsBynumeroTelephone(registerModel.getNumeroTelephone())){
            throw new PersonnelException("le numero telephone  existe deja");
        }
        Role role=roleRepository.findByName(ERole.ROLE_ETUDIANT).orElseThrow(
                ()->new PersonnelException("role non trouv")
        );
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        PlaceSignatory pls =  placeSignatoryService.getOne(registerModel.getPlace()).orElseThrow(
                ()-> new PersonnelException("LA PLACE N'EXISTE PAS")
        );
        Etudiant pl = new Etudiant();
        pl.setCni(registerModel.getCni());
        pl.setOption(registerModel.getOption());
        pl.setDateNaissance(registerModel.getDateNaissance());
        pl.setNumeroEtudiant(registerModel.getNumeroEtudiant());
        pl.setNumeroTelephone(registerModel.getNumeroTelephone());
        pl.setEmail(registerModel.getEmail());
        pl.setNom(registerModel.getNom());
        pl.setPrenom(registerModel.getPrenom());
        pl.setPlaceSignatory(pls);
        pl.setUrlHome("/etudiant/home");
        User user = new User(null,
                registerModel.getEmail(),
                encoder.encode(registerModel.getPassword()),
                roles);
        Etudiant etus = etudiantRepository.save(pl);
        userRepository.save(user);
        return etus ;
    }


}
