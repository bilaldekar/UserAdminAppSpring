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
    private UserService userService;

    @GetMapping
    @RequestMapping("/all/{active}/{firstName}/{lastName}/{userName}/{email}")
    public List<Users> list(@PathVariable("active") Boolean active,
                               @PathVariable("firstName") String firstName,
                               @PathVariable("lastName") String lastName,
                               @PathVariable("userName") String userName,
                               @PathVariable("email") String email) {

        if (firstName.toString().equals("null")) {
            firstName = null;
        }
        if (lastName.toString().equals("null")) {
            lastName = null;
        }
        if (userName.toString().equals("null")) {
            userName = null;
        }
        if (email.toString().equals("null")) {
            email = null;
        }

        return userService.findByAllAttributes(active, firstName, lastName, userName, email);
    }

    @GetMapping
    @RequestMapping("{id}")
    public Users get(@PathVariable("id") Long id) {
        return userService.getOneUser(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> addUser(@Valid @RequestBody Users users, BindingResult result) {
        //  Un map pour gérer les erreurs
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Users usersList = userService.saveEntity(users);
        return new ResponseEntity<Users>(usersList, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editUser(@Valid @RequestBody Users users, @PathVariable("id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Users usersList = userService.editEntity(users, id);
        return new ResponseEntity<Users>(usersList, HttpStatus.CREATED);
        //Users users = userService.editEntity(usersDTO, id);
        //return new ResponseEntity<UsersDTO>(ObjectMapperUtils.map(users, UsersDTO.class), HttpStatus.CREATED);
    }
}
