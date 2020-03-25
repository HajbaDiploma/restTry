package com.hajba.restTry.repository.usersRepositiry;

import com.hajba.restTry.model.users.RegisterUser;
import org.springframework.data.repository.CrudRepository;

public interface RegisterUserRepo extends CrudRepository<RegisterUser, Long> {
}
