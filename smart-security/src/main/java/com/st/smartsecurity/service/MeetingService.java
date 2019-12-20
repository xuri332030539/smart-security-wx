package com.st.smartsecurity.service;

import com.github.pagehelper.PageInfo;
import com.st.smartsecurity.pojo.dto.MeetingDTO;
import com.st.smartsecurity.pojo.vo.params.MeetingParamsVO;
import com.st.smartsecurity.pojo.vo.MeetingVO;

import java.util.Date;

/**
 * @author lhm
 * 会议接口
 */
public interface MeetingService {

    /**
     * 新增会议
     * @param meetingVO
     * @return
     */
    long addMeeting(MeetingVO meetingVO);

    /**
     * 删除会议
     * @param meetingId
     */
    void deleteMeeting(long meetingId);

    /**
     * 修改会议
     * @param meetingVO
     */
    void updateMeeting(MeetingVO meetingVO);

    /**
     * 获取会议详情
     * @param meetingId
     * @return
     */
    MeetingDTO getMeetingDetail(long meetingId);

    /**
     * 会议列表
     * @param meetingParamsVO
     * @return
     */
    PageInfo listMeeting(MeetingParamsVO meetingParamsVO);

    /**
     * 判断会议状态
     * @param startDate
     * @param endDate
     * @return
     */
    String checkMeetingState(Date startDate, Date endDate);
}
