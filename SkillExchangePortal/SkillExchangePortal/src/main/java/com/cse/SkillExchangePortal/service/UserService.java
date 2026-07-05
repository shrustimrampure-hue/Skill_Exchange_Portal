package com.cse.SkillExchangePortal.service;

import com.cse.SkillExchangePortal.entity.User;
import com.cse.SkillExchangePortal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User registerUser(User user) {
        return repository.save(user);
    }

    public User login(String email) {
        return repository.findByEmail(email);
    }
}