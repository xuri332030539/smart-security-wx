package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 会议DTO
 * @author lhm
 */
@Data
@ApiModel(value = "会议DTO")
public class MeetingDTO {

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

    @ApiModelProperty(value = "会议id")
    private Long id;

    @ApiModelProperty(value = "会议状态")
    String meetingState;

    @ApiModelProperty(value = "主办方名称")
    String initiatorName;

    @ApiModelProperty(value = "参加总人数")
    Integer sumPeople;

    @ApiModelProperty(value = "签到人数")
    Integer signPeople;

    @ApiModelProperty(value = "未签到人数")
    Integer absentPeople;
}
