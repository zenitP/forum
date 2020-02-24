package com.internet.forum.controller;

import com.internet.forum.domain.Role;
import com.internet.forum.domain.User;
import com.internet.forum.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){

         return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, @RequestParam() String username, @RequestParam() String password, Map<String, Object> model){

        User userFromDb = userRepo.findByUsername(user.getUsername());

        if(userFromDb != null){

            model.put("message", "Пользователь существует или незаполнены поля!");
            return "registration";
        }

        if(username.isEmpty() || username == null || password.isEmpty() || password == null){

            model.put("message", "В одном из полей отсутствуют данные!");
            return  "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        userRepo.save(user);

        return "redirect:/login";
    }

}
