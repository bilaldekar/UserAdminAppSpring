package com.useradmin.services;

import com.useradmin.dto.RolesDTO;
import com.useradmin.mapper.ObjectMapperUtils;
import com.useradmin.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepo;

    public List<RolesDTO> findAllRoles() {
        return ObjectMapperUtils.mapAll(roleRepo.findAll(), RolesDTO.class);
    }

}
