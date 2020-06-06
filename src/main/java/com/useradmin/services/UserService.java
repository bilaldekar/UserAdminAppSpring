package com.useradmin.services;

import com.useradmin.dto.UsersDTO;
import com.useradmin.mapper.ObjectMapperUtils;
import com.useradmin.models.Users;
import com.useradmin.repositories.UserRepository;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<Users> findAllByActive(boolean active) {
        List<Users> allByActive = userRepo.findByActive(active);
        return allByActive;
    }

    public List<Users> findByAllAttributes(boolean active, String firstName, String lastName, String userName, String email) {
        List<Users> allByActive = userRepo.findByActiveAndFirstNameAndLastNameAndUserNameAndEmail(active,  firstName,  lastName,  userName,  email);
        //return ObjectMapperUtils.mapAll(allByActive, UsersDTO.class);
        return  allByActive;
    }

    public Users getOneUser( Long id){
        return userRepo.getOne(id);
    }

    public Users saveEntity(Users users) {
        //Users users = ObjectMapperUtils.map(usersDTO, Users.class);
        return userRepo.save(users);
    }

    public Users editEntity(Users users, Long id) {
        Users existingUser = userRepo.getOne(id);
        //BeanUtils.copyProperties(ObjectMapperUtils.map(usersDTO, Users.class), existingUser, "id");
        BeanUtils.copyProperties(users, existingUser, "id");
        return userRepo.saveAndFlush(existingUser);
    }
}
