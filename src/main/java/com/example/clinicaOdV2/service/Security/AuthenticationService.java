package com.example.clinicaOdV2.service.Security;

import com.example.clinicaOdV2.Dao.IUserRepository;
import com.example.clinicaOdV2.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<com.example.clinicaOdV2.model.User> user = userRepository.getUserByName(userName);

        Set<GrantedAuthority> autorizaciones = new HashSet<>();
        GrantedAuthority autorizacion = null;
        for (Rol rol : user.get().getRoles()) {
            autorizacion = new SimpleGrantedAuthority(rol.getName());
            autorizaciones.add(autorizacion);
        }
        User userDetail = new User(user.get().getName(),"{noop}" + user.get().getPassword(),true, true, true,true,autorizaciones);
        return userDetail;
    }


}
