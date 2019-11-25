package com.societe.generale.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.societe.generale.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
