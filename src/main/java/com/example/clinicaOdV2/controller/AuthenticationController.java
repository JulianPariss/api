package com.example.clinicaOdV2.controller;

import com.example.clinicaOdV2.Dao.IUserRepository;
import com.example.clinicaOdV2.model.AuthenticationRequest;
import com.example.clinicaOdV2.model.AuthenticationResponse;
import com.example.clinicaOdV2.model.User;
import com.example.clinicaOdV2.service.Security.MyPasswordEncoder;
import com.example.clinicaOdV2.service.Security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;


    @Autowired
    IUserRepository iUserRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        User user = iUserRepository.getUserByName(authenticationRequest.getUsername()).get();

        if(user != null && myPasswordEncoder.matchesPassword(authenticationRequest.getPassword(),user.getPassword())){
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse((jwt)));
        }else {return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}

    }


}
