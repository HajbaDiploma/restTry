package com.hajba.restTry.rest.controller;

import com.hajba.restTry.model.users.RegisterUser;
import com.hajba.restTry.repository.usersRepositiry.RegisterUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegisterUserController {

    @Autowired
    private RegisterUserRepo registerUserRepo;

    @GetMapping("/get/test/user")
    public String getRegisterUSer(
            @RequestParam(name="name", required = true) String name,
            @RequestParam(name="sName", required = false) String sName,
            @RequestParam(name="fName", required = false) String fName,
            @RequestParam(name="phone", required = false) String phone,
            @RequestParam(name="skype", required = false) String skype,
            @RequestParam(name="otherSocial", required = false) String otherSocial,
            Map<String, Object> model
    ){
        RegisterUser registerUser = new RegisterUser();
        registerUser.setName(name);

        if(!StringUtils.isEmpty(fName)){
            registerUser.setfName(fName);
        }
        if(!StringUtils.isEmpty(sName)){
            registerUser.setsName(sName);
        }
        if(!StringUtils.isEmpty(phone)){
            registerUser.setPhoneNumber(phone);
        }
        if(!StringUtils.isEmpty(skype)){
            registerUser.setSkypeLogin(skype);
        }
        if(!StringUtils.isEmpty(otherSocial)){
            registerUser.setOtherSocialNet(otherSocial);
        }

        model.put("name", name);
        model.put("sName", registerUser.getsName());
        model.put("fName", registerUser.getfName());
        model.put("phone", registerUser.getSkypeLogin());
        model.put("skype", registerUser.getSkypeLogin());
        model.put("otherSocial", registerUser.getOtherSocialNet());

        return "user";
    }

    @GetMapping
    public String mainGet(Map<String, Object> model){
        Iterable<RegisterUser> iterable = registerUserRepo.findAll();
        model.put("name", iterable);
        return "main";
    }


    // Post mapping

    @PostMapping("post/register/user")
    public String createUser(
            @RequestParam(name="name", required = true) String name,
            @RequestParam(name="sName", required = false) String sName,
            @RequestParam(name="fName", required = false) String fName,
            @RequestParam(name="phone", required = false) String phone,
            @RequestParam(name="skype", required = false) String skype,
            @RequestParam(name="otherSocial", required = false) String otherSocial,
            Map<String, Object> model){

        RegisterUser registerUser = new RegisterUser();
        registerUser.setName(name);

        if(!StringUtils.isEmpty(fName)){
            registerUser.setfName(fName);
        }
        if(!StringUtils.isEmpty(sName)){
            registerUser.setsName(sName);
        }
        if(!StringUtils.isEmpty(phone)){
            registerUser.setPhoneNumber(phone);
        }
        if(!StringUtils.isEmpty(skype)){
            registerUser.setSkypeLogin(skype);
        }
        if(!StringUtils.isEmpty(otherSocial)){
            registerUser.setOtherSocialNet(otherSocial);
        }

        registerUserRepo.save(registerUser);

        Iterable<RegisterUser> iterable = registerUserRepo.findAll();
        model.put("name", iterable);
        return "main";
    }

}
