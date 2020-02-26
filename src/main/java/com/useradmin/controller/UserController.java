package com.useradmin.controller;

import com.useradmin.models.Users;
import com.useradmin.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    @RequestMapping("{active}")
    public List<Users> list() {
        return userRepo.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Users get(@PathVariable Long id) {
        return  userRepo.getOne(id);
    }

    @GetMapping
    public Users create(@RequestBody final Users user){
        return userRepo.saveAndFlush(user);
    }
}
