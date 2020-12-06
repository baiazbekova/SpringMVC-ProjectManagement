package com.cybertek.controller;


import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping({"/create", "/add", "/initialize"}) //it's possible to put several endpoints
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());
        //datagenerator

        //model.addAttribute("roles", findAll());
        return "/user/create";
    }

}
