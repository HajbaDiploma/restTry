package com.hajba.restTry.repository.usersRepositiry;

import com.hajba.restTry.model.resume.lishnee.RegisterUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegisterUserRepo extends CrudRepository<RegisterUser, Long> {
    List<RegisterUser> findByName(String RegisterUserName);
    //List<RegisterUser> findBySName(String name);
    //List<RegisterUser> findByFName(String name);
}
