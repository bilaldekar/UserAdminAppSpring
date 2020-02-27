package com.useradmin.controller;

import com.useradmin.dto.UsersDTO;
import com.useradmin.models.Users;
import com.useradmin.repositories.*;
import com.useradmin.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @GetMapping
    @RequestMapping("/all/{active}")
    public List<UsersDTO> list(@PathVariable("active")  Boolean active) {
        return userService.findAllByActive(active);
    }

    @GetMapping
    @RequestMapping("{id}")
    public Users get(@PathVariable("id") Long id) {
        return userRepo.getOne(id);
    }

    @GetMapping
    public Users create(@RequestBody final Users user) {
        return userRepo.saveAndFlush(user);
    }
}
