package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 *
 * @author xuri
 * @date 201912/17
 */
@Data
@ToString
@ApiModel(value = "用户dto")
public class QdUserDTO {
    @ApiModelProperty(value = "id")
    private long id;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "工号")
    private String workNumber;
    @ApiModelProperty(value = "手机号码")
    private String phone;
    @ApiModelProperty(value = "头像")
    private String headUrl;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "性别")
    private int gender;
    @ApiModelProperty(value = "token")
    private String token;
}
