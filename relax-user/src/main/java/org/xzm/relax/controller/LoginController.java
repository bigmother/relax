package org.xzm.relax.controller;

import com.nimbusds.jose.JOSEException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xzm.relax.exception.ExceptionType;
import org.xzm.relax.exception.ServiceException;
import org.xzm.relax.model.dto.LoginDTO;
import org.xzm.relax.model.dto.Result;
import org.xzm.relax.model.dto.TokenDTO;
import org.xzm.relax.model.dto.UserDTO;
import org.xzm.relax.service.UserService;
import org.xzm.relax.util.SecurityUtils;
import org.xzm.relax.util.TokenUtils;

/**
 * @author xuzhemin
 * 2019年3月27日 20点35分
 */
@Api(tags = "登录接口")
@RequestMapping("/login")
@RestController
public class LoginController {

    private UserService userService;

    @PostMapping
    public Result<TokenDTO> login(@RequestBody LoginDTO loginDTO){
        UserDTO user = userService.authenticate(loginDTO);
        try {
            return Result.success(TokenUtils.getToken(user.getId()));
        } catch (JOSEException e) {
            throw new ServiceException(ExceptionType.LOGGING_ERROR);
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
