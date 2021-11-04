package com.api.projettransversal.auth.personnel.service;

import com.api.projettransversal.Role.ERole;
import com.api.projettransversal.Role.entity.Role;
import com.api.projettransversal.Role.repository.RoleRepository;
import com.api.projettransversal.auth.AllUser.entity.User;
import com.api.projettransversal.auth.AllUser.repository.UserRepository;
import com.api.projettransversal.auth.AllUser.service.UserDetailsImpl;
import com.api.projettransversal.auth.jwt.response.JwtResponse;
import com.api.projettransversal.auth.jwt.security.JwtUtils;
import com.api.projettransversal.auth.personnel.Exception.PersonnelException;
import com.api.projettransversal.auth.personnel.api.request.ProjectionPersonnel;
import com.api.projettransversal.auth.personnel.api.request.RegisterModel;
import com.api.projettransversal.auth.personnel.api.request.UserReq;
import com.api.projettransversal.auth.personnel.entity.Personnel;
import com.api.projettransversal.auth.personnel.repository.PersonnelRepository;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.placeSignatory.service.PlaceSignatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonnelServiceBean implements  PersonnelService {
    @Autowired
    private PersonnelRepository personnelRepository;
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
    public Personnel create(RegisterModel registerModel) {
        if(personnelRepository.existsByEmail(registerModel.getEmail())){
            throw new PersonnelException("Email existe deja");
        }
        Personnel pl = new Personnel();
        Role role=new Role();
        Set<Role> roles = new HashSet<>();
        switch (registerModel.getRole()){
            case "ADMIN":
                     role = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(
                            ()->new PersonnelException("role n'existe pas")
                    );
                     pl.setUrlHome("/admin/home");
                    break;
            case "SECRETAIRE":
                 role = roleRepository.findByName(ERole.ROLE_SECRETAIRE).orElseThrow(
                        ()->new PersonnelException("role n'existe pas")
                );
                pl.setUrlHome("/secretaire/home");
                break;
            case "SIGNATAIRE":
                 role = roleRepository.findByName(ERole.ROLE_SIGNATAIRE).orElseThrow(
                        ()->new PersonnelException("role n'existe pas")
                );
                 Long id = Long.parseLong(String.valueOf(registerModel.getPlace()));
                if(personnelRepository.existByPlace(id)){
                    throw new PersonnelException("Cette place a deja un compte (Signataire)");
                }
                pl.setUrlHome("/signataire/home");
                break;
            default:throw new PersonnelException("aJOUTER AU MOINS une role");
        }
        PlaceSignatory pls =  placeSignatoryService.getOne(registerModel.getPlace()).orElseThrow(
                ()-> new PersonnelException("LA PLACE N'EXISTE PAS")
        );
        pl.setEmail(registerModel.getEmail());
        pl.setNom(registerModel.getNom());
        pl.setPrenom(registerModel.getPrenom());
        pl.setPlaceSignatory(pls);
        roles.add(role);
        User user = new User(null,
                registerModel.getEmail(),
                encoder.encode("1707"),
                roles);
        userRepository.save(user);
        return personnelRepository.save(pl);
    }

    @Override
    public ResponseEntity<?> sigin(UserReq loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generatedJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        for(String rs:roles){
                return ResponseEntity.ok(new JwtResponse(jwt,
                        userDetails.getId(),
                        userDetails.getEmail(),
                        roles));
        }
        throw new PersonnelException("Email ou password incorrect");
    }

    @Override
    public User deleteUser(Long id,String email) {
        personnelRepository.deleteById(id);
        User user = userRepository.findByEmail(email).orElseThrow(
                ()->new PersonnelException("erreur")
        );
        userRepository.delete(user);
        return user;
    }

    @Override
    public Optional<Personnel> getUser(String email) {
        return this.personnelRepository.findByEmail(email);
    }

    @Override
    public List<ProjectionPersonnel> getAll() {
        return personnelRepository.getAll();
    }
}
