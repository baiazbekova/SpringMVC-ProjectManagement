package com.cybertek.service;

import com.cybertek.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService <UserDTO, String> {

    //save
    //findBy user by username

   //to be able to use the methods from CrudService we need to extend it as shown above

}
