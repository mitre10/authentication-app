package com.mitre.authenticationapp.repository;

import com.mitre.authenticationapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends CrudRepository<User, Integer> {
}
