package com.useradmin.services;

import com.useradmin.dto.UsersDTO;
import com.useradmin.mapper.ObjectMapperUtils;
import com.useradmin.models.Users;
import com.useradmin.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<UsersDTO> findAllByActive(boolean active) {
        List<Users> allByActive = userRepo.findByActive(active);
        return ObjectMapperUtils.mapAll(allByActive, UsersDTO.class);
    }

    public Users saveEntity(UsersDTO usersDTO) {
        Users users = ObjectMapperUtils.map(usersDTO, Users.class);
        return userRepo.save(users);
    }
}
