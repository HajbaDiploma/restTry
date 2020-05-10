package com.hajba.restTry.rest.controller.users;

import com.hajba.restTry.model.resume.lishnee.RegisterUser;
import com.hajba.restTry.model.users.User;
import com.hajba.restTry.repository.usersRepositiry.RegisterUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;
import java.util.logging.Logger;

@Controller
public class RegisterUserController {

    Logger log = Logger.getLogger("Controller");

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

    @GetMapping("/")
    public String mainGet(){
        return "registration";
    }

    // Post mapping

    @GetMapping("register/user")
    public String getUser(Map<String, Object> model){
        Iterable<RegisterUser> iterable = registerUserRepo.findAll();
        model.put("name", iterable);
        return "main";
    }

    @PostMapping("post/test")
    public String createTest(
            @RequestParam(name="name", required = true) String name
    ){
        log.info("in method");
        RegisterUser user = new RegisterUser();
        user.setName(name);
        log.info(user.toString());
        registerUserRepo.save(user);
        log.info("was saved");
        return "main";
    }

    @PostMapping("post/register/user")
    public RedirectView createUser(

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

        return new RedirectView("register/user");
    }

    @PostMapping("/filter/by-name")
    public String filterByName(String name, Map <String, Object> model) {
        Iterable<RegisterUser> iterable;
        if (!StringUtils.isEmpty(name)) {
            iterable = registerUserRepo.findByName(name);
        } else {
            iterable = registerUserRepo.findAll();
        }
        model.put("userList", iterable);
        return "find-page";
    }

}
