package com.useradmin.controller;

import com.useradmin.dto.UsersDTO;
import com.useradmin.mapper.ObjectMapperUtils;
import com.useradmin.models.Users;
import com.useradmin.repositories.*;
import com.useradmin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//test push


@RestController
@CrossOrigin(origins = "*")
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

    @PostMapping("/save")
    public ResponseEntity<?> addUser(@Valid @RequestBody UsersDTO usersDTO, BindingResult result) {
        //  Un map pour gérer les erreurs
        if (result.hasErrors()){
            Map<String,String> errorMap= new HashMap<>();

            for (FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Users users = userService.saveEntity(usersDTO);
        return new ResponseEntity<UsersDTO>(ObjectMapperUtils.map(users, UsersDTO.class), HttpStatus.CREATED);
    }
}
