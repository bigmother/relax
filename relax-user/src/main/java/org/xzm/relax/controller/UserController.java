package org.xzm.relax.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.xzm.relax.model.dto.Result;
import org.xzm.relax.model.dto.UserDTO;
import org.xzm.relax.model.dto.condition.UserCondition;
import org.xzm.relax.model.dto.create.UserCreate;
import org.xzm.relax.model.dto.update.UserUpdate;
import org.xzm.relax.service.UserService;

import javax.validation.Valid;

@Api(tags="用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @ApiOperation("获取用户列表")
    @GetMapping("/page")
    public Result<Page<UserDTO>> page(@Valid UserCondition userCondition){
        return Result.success(userService.page(userCondition));
    }

    @ApiOperation("创建用户")
    @PostMapping
    public Result<UserDTO> create(@Valid UserCreate userCreate){
        return Result.success(userService.create(userCreate));
    }

    @ApiOperation("修改用户")
    @PutMapping
    public Result<UserDTO> update(@Valid UserUpdate userUpdate){
        return Result.success(userService.update(userUpdate));
    }

    @ApiOperation("删除用户")
    @DeleteMapping
    public Result<String> delete(@RequestParam Long id){
        userService.delete(id);
        return Result.success();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
