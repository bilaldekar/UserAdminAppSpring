package com.useradmin.repositories;

import com.useradmin.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface UserRepository  extends JpaRepository<Users, Long> {
    List<Users> findByActive(boolean active);

    @Query("SELECT u FROM users u WHERE (:active is null or u.active = :active) and (:firstName is null or u.firstName like %:firstName%) and (:lastName is null or u.lastName like %:lastName%) and (:userName is null or u.userName like %:userName%) and (:email is null or u.email like %:email%)")
    List<Users> findByActiveAndFirstNameAndLastNameAndUserNameAndEmail(@Param("active")   boolean active,
                                                                       @Param("firstName") @Nullable  String firstName,
                                                                       @Param("lastName") @Nullable  String lastName,
                                                                       @Param("userName") @Nullable  String userName,
                                                                       @Param("email")  @Nullable String email);

}
