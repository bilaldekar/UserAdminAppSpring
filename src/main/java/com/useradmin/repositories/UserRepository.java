package com.useradmin.repositories;

import com.useradmin.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface UserRepository  extends JpaRepository<Users, Long> {
    List<Users> findByActive(boolean active);

    List<Users> findByActiveAndFirstNameAndLastNameAndUserNameAndEmail(boolean active, String firstName, String lastname, String userName, String email);

}
