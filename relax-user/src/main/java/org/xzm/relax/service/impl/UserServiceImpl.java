package org.xzm.relax.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.xzm.relax.dao.UserDao;
import org.xzm.relax.model.dto.UserDTO;
import org.xzm.relax.model.dto.condition.UserCondition;
import org.xzm.relax.model.dto.create.UserCreate;
import org.xzm.relax.model.dto.update.UserUpdate;
import org.xzm.relax.service.UserService;

/**
 * @author xuzhemin
 * 2019/3/20
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public UserDTO create(UserCreate userCreate) {
        return null;
    }

    @Override
    public UserDTO update(UserUpdate userUpdate) {
        return null;
    }

    @Override
    public Page<UserDTO> page(UserCondition userCondition) {
        return null;
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
