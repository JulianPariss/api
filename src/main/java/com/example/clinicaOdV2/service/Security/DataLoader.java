package com.example.clinicaOdV2.service.Security;

import com.example.clinicaOdV2.Dao.IUserRepository;
import com.example.clinicaOdV2.Dao.RolRepository;
import com.example.clinicaOdV2.controller.AuthenticationController;
import com.example.clinicaOdV2.model.Rol;
import com.example.clinicaOdV2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    private RolRepository rolRepository;

    @Autowired
    private MyPasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(IUserRepository userRepository, RolRepository rolRepository) {
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
    }


    public void run(ApplicationArguments args) {
        String hashedPassword = passwordEncoder.encodePassword("password");
        Rol rolAdmin = new Rol("ADMIN");
        rolRepository.save(rolAdmin);
        User user = new User("Diego",hashedPassword);
        user.addRol(rolRepository.getRolByName("ADMIN").get());
        userRepository.save(user);

        String hashedPassword2 = passwordEncoder.encodePassword("password");
        Rol rolUser = new Rol("USER");
        rolRepository.save(rolUser);
        User user2 = new User("Pepe",hashedPassword2);
        user.addRol(rolRepository.getRolByName("USER").get());
        userRepository.save(user2);
    }
}

