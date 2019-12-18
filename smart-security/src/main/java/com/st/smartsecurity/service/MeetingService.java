package com.st.smartsecurity.service;

import com.st.smartsecurity.pojo.po.QdMeeting;
import com.st.smartsecurity.pojo.vo.MeetingVO;

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
     * 获取会议详情
     * @param meetingId
     * @return
     */
    QdMeeting getMeetingDetail(long meetingId);
}
