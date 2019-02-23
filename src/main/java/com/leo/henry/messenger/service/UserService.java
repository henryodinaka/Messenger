package com.leo.henry.messenger.service;

import com.leo.henry.messenger.model.User;
import com.leo.henry.messenger.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User getOne(Long id)
    {
        return userRepo.getOne(id);
    }
}
