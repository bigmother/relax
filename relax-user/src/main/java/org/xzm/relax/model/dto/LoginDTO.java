package org.xzm.relax.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xuzhemin
 * 2019/3/27
 */
@ApiModel("登录数据")
@Data
public class LoginDTO {
    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("加密密码")
    private String password;
}
