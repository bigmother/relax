package org.xzm.relax.service;

import org.springframework.stereotype.Service;
import org.xzm.relax.model.dto.create.UserCreate;
import org.xzm.relax.model.entity.User;

@Service
public interface UserService {

    User create(UserCreate userCreate);

}
