package org.xzm.relax.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Ticket:
 *
 * @author xuzhemin
 * 2019/3/20 13:04
 */
@Data
@ApiModel("用户信息")
public class UserDTO {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("年龄")
    private Integer age;
}
