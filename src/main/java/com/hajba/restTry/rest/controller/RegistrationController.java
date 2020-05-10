package com.hajba.restTry.rest.controller;

import com.hajba.restTry.model.users.Role;
import com.hajba.restTry.model.users.User;
import com.hajba.restTry.repository.UserRepo;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.Map;

@Log
@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registrationGet() {
        log.info("@GetMapping(\"/registration\")");
        return "registration";
    }

    @PostMapping("/registration")
    public RedirectView addUser(User user, Map<String, Object> model) {
        User dbUser = userRepo.findByUsername(user.getUsername());

        if (dbUser != null) {
            log.info(dbUser.toString());
        }

        log.info(user.toString());
        log.info("/registration with param");

        if (dbUser != null) {
            log.info("/registration dbUser!=null");
            model.put("message", "User exists");
            return new RedirectView("registration");
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        User fromdbUser = userRepo.findByUsername(user.getUsername());
        log.info(fromdbUser.toString());
        log.info("redirect to login");
        return new RedirectView("login");
    }

}
