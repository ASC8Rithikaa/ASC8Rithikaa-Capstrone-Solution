package com.demo.service;

import com.demo.entity.Admin;
import com.demo.model.LoginRequest;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            return "Email and password cannot be blank.";
        }

        if (!isValidEmail(email)) {
            return "Invalid email address.";
        }

        if (!isValidPassword(password)) {
            return "Password must contain an uppercase letter, lowercase letters, a digit, and a special character.";
        }

        Optional < Admin > userOptional = userRepository.findByEmail(email);
//        if (userOptional.()) {
//            return "User not found.";
//        }

        Admin user = userOptional.get();
        if (!user.getPassword().equals(password)) {
            return "Invalid password. Try again.";
        }

        return "Login successful!";
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$";
        Pattern pattern = Pattern.compile(passwordRegex);
        return pattern.matcher(password).matches();
    }
}
