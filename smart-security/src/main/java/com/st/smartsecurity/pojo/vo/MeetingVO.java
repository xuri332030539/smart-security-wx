package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 添加会议VO
 * @author lhm
 */
@ApiModel(value = "添加会议VO")
@Data
public class MeetingVO {

    @ApiModelProperty(value = "会议名称,必填")
    private String name;

    @ApiModelProperty(value = "主办方，必填")
    private Long initiatorId;

    @ApiModelProperty(value = "会议开始时间,格式如:2019-12-18 10:33:32")
    private Date startDate;

    @ApiModelProperty(value = "会议结束时间")
    private Date endDate;

    @ApiModelProperty(value = "会议内容")
    private String content;

    @ApiModelProperty(value = "会议地址")
    private String address;

    @ApiModelProperty(value = "联系电话，必填")
    private String initiatorPhone;

    @ApiModelProperty(value = "会议id,更新时必填")
    private Long id;
}
