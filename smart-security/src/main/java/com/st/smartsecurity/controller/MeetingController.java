package com.st.smartsecurity.controller;

import com.google.common.base.Preconditions;
import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.pojo.vo.params.MeetingParamsVO;
import com.st.smartsecurity.pojo.vo.MeetingVO;
import com.st.smartsecurity.service.MeetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会议接口
 * @author lhm
 */
@RestController
@RequestMapping("meeting")
@Api(value = "meeting", tags = "会议接口", position = 1)
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @PostMapping("addMeeting")
    @ApiOperation(value = "新增会议接口")
    @PassToken
    public BaseResponse addMeeting(@RequestBody MeetingVO meetingVO){
        Preconditions.checkNotNull(meetingVO.getName(),"名称不可为空");
        Preconditions.checkNotNull(meetingVO.getInitiatorId(),"主办方不可为空");
        Preconditions.checkNotNull(meetingVO.getInitiatorPhone(),"主办方联系方式不可为空");
        return BaseResponse.success(meetingService.addMeeting(meetingVO));
    }

    @PassToken
    @PostMapping("deleteMeeting")
    @ApiOperation(value = "删除会议接口")
    public BaseResponse deleteMeeting(long meetingId){
        Preconditions.checkNotNull(meetingId,"请选择要删除的会议");
        meetingService.deleteMeeting(meetingId);
        return BaseResponse.success();
    }

    @PassToken
    @PostMapping("updateMeeting")
    @ApiOperation(value = "修改会议信息")
    public BaseResponse updateMeeting(@RequestBody MeetingVO meetingVO){
        Preconditions.checkNotNull(meetingVO.getId(),"id不可为空");
        Preconditions.checkNotNull(meetingVO.getName(),"名称不可为空");
        Preconditions.checkNotNull(meetingVO.getInitiatorId(),"主办方不可为空");
        Preconditions.checkNotNull(meetingVO.getInitiatorPhone(),"主办方联系方式不可为空");
        meetingService.updateMeeting(meetingVO);
        return BaseResponse.success();
    }

    @PostMapping("getMeetingDetail")
    @ApiOperation("获取会议详情")
    @PassToken
    public BaseResponse getMeetingDetail(long meetingId){
        Preconditions.checkNotNull(meetingId,"会议id不可为空");
        return BaseResponse.success(meetingService.getMeetingDetail(meetingId));
    }

    @PassToken
    @PostMapping("listMeeting")
    @ApiOperation(value = "会议列表")
    public BaseResponse listMeeting(@RequestBody MeetingParamsVO meetingParamsVO){
        return BaseResponse.success(meetingService.listMeeting(meetingParamsVO));
    }

}
