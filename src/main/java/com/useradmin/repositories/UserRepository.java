package com.useradmin.repositories;

import com.useradmin.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users, Long> {

}
