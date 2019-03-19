package org.xzm.relax.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("获取用户列表")
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public String page(){
        return "1";
    }
}
