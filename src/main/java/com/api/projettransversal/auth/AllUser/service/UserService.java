package com.api.projettransversal.auth.AllUser.service;

import com.api.projettransversal.auth.AllUser.entity.User;
import com.api.projettransversal.auth.AllUser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username).orElseThrow(
                ()-> new  UsernameNotFoundException("Email no trouver")
        );
        return UserDetailsImpl.build(user);
    }
}
