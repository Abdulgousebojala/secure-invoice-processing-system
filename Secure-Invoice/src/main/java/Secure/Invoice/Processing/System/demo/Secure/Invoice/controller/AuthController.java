package Secure.Invoice.Processing.System.demo.Secure.Invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Secure.Invoice.Processing.System.demo.Secure.Invoice.model.User;
import Secure.Invoice.Processing.System.demo.Secure.Invoice.repository.UserRepository;
import Secure.Invoice.Processing.System.demo.Secure.Invoice.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser =
                userRepository.findByUsername(user.getUsername());

        if (existingUser != null &&
                passwordEncoder.matches(
                        user.getPassword(),
                        existingUser.getPassword()
                )) {

            return jwtUtil.generateToken(user.getUsername());
        }

        return "Invalid Username or Password";
    }
}