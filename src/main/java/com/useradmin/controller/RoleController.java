package com.useradmin.controller;

import com.useradmin.dto.RolesDTO;
import com.useradmin.dto.UsersDTO;
import com.useradmin.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    @RequestMapping("/all")
    public List<RolesDTO> list() {
        return roleService.findAllRoles();
    }

}
