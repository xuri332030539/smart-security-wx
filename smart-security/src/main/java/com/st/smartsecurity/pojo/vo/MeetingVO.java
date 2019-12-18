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


    @ApiModelProperty(value = "会议名称")
    private String name;

    @ApiModelProperty(value = "主办方")
    private Long initiatorId;

    @ApiModelProperty(value = "会议开始时间")
    private Date startDate;

    @ApiModelProperty(value = "会议结束时间")
    private Date endDate;

    @ApiModelProperty(value = "会议内容")
    private String content;

    @ApiModelProperty(value = "会议地址")
    private String address;

    @ApiModelProperty(value = "联系电话")
    private String initiatorPhone;
}
