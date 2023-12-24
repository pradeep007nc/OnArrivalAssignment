package dev.pradeep.OnArrivalAssignment.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.pradeep.OnArrivalAssignment.Dto.LoginDto;
import dev.pradeep.OnArrivalAssignment.Dto.SignupDto;
import dev.pradeep.OnArrivalAssignment.Entity.User;
import dev.pradeep.OnArrivalAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    only unlocked urls in beginning login and signup with exception of swagger
 */

@RestController
@RequestMapping("/api")
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
        post method takes login dto as parameter i.e email and password
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );

            // Authentication successful, generate JWT token
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok("login success");

        } catch (AuthenticationException e) {
            // Authentication failed, return error message
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    /*
        post method for signup controller
        takes signup dto as parameter return string notifying weather user has successfully signed in
        if user exists notifies user exists
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignupDto user) {

        try {
            // Check for existing user with the same email
            if (userRepository.existsById(user.getEmail())) {
                return ResponseEntity.badRequest().body("Email already exists");
            }

            // Hash the password
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            User mappedUser = new ObjectMapper().convertValue(user, User.class);
            // Save the user to the database
            userRepository.save( mappedUser );

            return ResponseEntity.ok("User registered successfully");

        } catch (Exception e) {
            // Handle any unexpected errors
            return ResponseEntity.internalServerError().body("Registration failed");
        }
    }

}
