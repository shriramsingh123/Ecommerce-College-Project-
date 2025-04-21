package com.shriram.e_commerce.controller;

import com.shriram.e_commerce.dto.request.AuthRequest;
import com.shriram.e_commerce.dto.request.UsersDtoRequest;
import com.shriram.e_commerce.dto.response.AuthResponse;
import com.shriram.e_commerce.dto.response.ProfileDataResponse;
import com.shriram.e_commerce.entity.Users;
import com.shriram.e_commerce.jwt.JwtAuthService;
import com.shriram.e_commerce.repository.UsersRepository;
import com.shriram.e_commerce.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsersServices usersServices;

    @Autowired
    private JwtAuthService jwtAuthService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerUser(@ModelAttribute UsersDtoRequest usersDtoRequest){
        System.out.println(usersDtoRequest);
        boolean posted = usersServices.singUpUser(usersDtoRequest);
        if (posted){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/generateToken")
    public AuthResponse authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            Users users = usersRepository.findByEmail(authRequest.getUsername());
            AuthResponse authResponse = new AuthResponse();
            authResponse.setJwt(jwtAuthService.generateToken(authRequest.getUsername()));
            authResponse.setRole(users.getRoles());
            authResponse.setUserId(users.getUserId());
            return authResponse;
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<ProfileDataResponse> getUserDetails(@PathVariable int userId){
        ProfileDataResponse profile = usersServices.getUsersDetails(userId);
        return new ResponseEntity<>(profile,HttpStatus.OK);
    }


    @GetMapping("/message")
    public String welcomeMessage(){
        return "Your Auth Controller work properly";
    }
}
