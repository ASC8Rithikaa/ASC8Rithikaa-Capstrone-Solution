package com.demo.service;

import com.demo.model.LoginRequest;
import com.demo.entity.Admin;
public interface UserService {
    String login(LoginRequest loginRequest);
}
