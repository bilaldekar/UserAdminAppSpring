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

    public List<UsersDTO> findAllByActive(boolean active) {
        List<Users> allByActive = userRepo.findByActive(active);
        return ObjectMapperUtils.mapAll(allByActive, UsersDTO.class);
    }

    public List<UsersDTO> findByAllAttributes(boolean active, String firstName, String lastName, String userName, String email) {
        List<Users> allByActive = userRepo.findByActiveAndFirstNameAndLastNameAndUserNameAndEmail(active,  firstName,  lastName,  userName,  email);

        /*for(int i =0; i<allByActive.size(); i++){
            System.out.println("-----> " + allByActive.get(i).getr);
        }*/

        return ObjectMapperUtils.mapAll(allByActive, UsersDTO.class);
    }

    public UsersDTO getOneUser( Long id){
        return ObjectMapperUtils.map(userRepo.getOne(id), UsersDTO.class);
    }

    public Users saveEntity(UsersDTO usersDTO) {
        Users users = ObjectMapperUtils.map(usersDTO, Users.class);
        return userRepo.save(users);
    }

    public Users editEntity(UsersDTO usersDTO, Long id) {
        Users existingUser = userRepo.getOne(id);
        BeanUtils.copyProperties(ObjectMapperUtils.map(usersDTO, Users.class), existingUser, "id");
        return userRepo.saveAndFlush(existingUser);
    }
}
