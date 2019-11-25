package com.societe.generale.service;


import com.societe.generale.model.User;

public interface UserService {

    User save(User user);

    User findOne(String username);

   
}
