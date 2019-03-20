package org.xzm.relax.model.dto.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("用户查询条件")
public class UserCondition extends PageBean {

    @ApiModelProperty("用户名")
    private String username;

}
