package org.xzm.relax.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xzm.relax.dao.UserDao;
import org.xzm.relax.exception.ExceptionType;
import org.xzm.relax.exception.ServiceException;
import org.xzm.relax.model.dto.LoginDTO;
import org.xzm.relax.model.dto.UserDTO;
import org.xzm.relax.model.dto.condition.UserCondition;
import org.xzm.relax.model.dto.create.UserCreate;
import org.xzm.relax.model.dto.update.UserUpdate;
import org.xzm.relax.model.entity.User;
import org.xzm.relax.service.UserService;
import org.xzm.relax.util.BeanUtils;
import org.xzm.relax.util.IdUtils;

/**
 * @author xuzhemin
 * 2019/3/20
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO create(UserCreate userCreate) {
        User user = BeanUtils.copyProperties(userCreate, User.class);
        user.setId(IdUtils.id());
        if (userDao.existsByUsername(user.getUsername())) {
            throw new ServiceException(ExceptionType.USERNAME_EXISTS);
        }
        userDao.save(user);
        return BeanUtils.copyProperties(user, UserDTO.class);
    }

    @Override
    public UserDTO update(UserUpdate userUpdate) {
        User user = userDao.findById(userUpdate.getId()).orElseThrow(() ->
                new ServiceException(ExceptionType.USER_NOT_EXISTS));
        userDao.save(user);
        return BeanUtils.copyProperties(user, UserDTO.class);
    }

    @Override
    public Page<UserDTO> page(UserCondition userCondition) {
        User user = BeanUtils.copyProperties(userCondition, User.class);
        return userDao.findAll(Example.of(user), userCondition.getPageRequest())
                .map(u -> BeanUtils.copyProperties(u,UserDTO.class));
    }

    @Override
    public void delete(Long id) {
        userDao.findById(id).ifPresent(user -> userDao.delete(user));
    }

    @Override
    public UserDTO authenticate(LoginDTO loginDTO) {
        String account = loginDTO.getAccount();
        User user = userDao.findByAccount(account);
        if (user==null){
            throw new ServiceException(ExceptionType.USER_NOT_EXISTS);
        }
        if(!passwordEncoder.matches(decodePassword(loginDTO.getPassword()),user.getPassword())){
            throw new ServiceException(ExceptionType.PASSWORD_INVALID);
        }
        return BeanUtils.copyProperties(user,UserDTO.class);
    }

    private String decodePassword(String password){
        return password;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
}
