package org.xzm.relax.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author xuzhemin
 * 2019/3/27
 */
@Data
@ApiModel("Token数据")
public class TokenDTO {
    @ApiModelProperty("Token")
    private String token;
    @ApiModelProperty("刷新Token")
    private String refreshToken;
    @ApiModelProperty("过期时间")
    private Date expiredDate;
}
