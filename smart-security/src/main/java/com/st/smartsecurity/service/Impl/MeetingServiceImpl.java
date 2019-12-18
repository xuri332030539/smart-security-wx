package com.st.smartsecurity.service.Impl;

import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.constant.MeetingConstant;
import com.st.smartsecurity.mapper.QdMeetingMapper;
import com.st.smartsecurity.pojo.po.QdMeeting;
import com.st.smartsecurity.pojo.vo.MeetingVO;
import com.st.smartsecurity.service.MeetingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**会议接口
 * @author lhm
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MeetingServiceImpl implements MeetingService {

    @Resource
    QdMeetingMapper qdMeetingMapper;

    @Override
    public long addMeeting(MeetingVO meetingVO) {
        QdMeeting qdMeeting = BeanUtil.copyProperties(meetingVO, QdMeeting.class);
        qdMeeting.setVersionDate(new Date());
        qdMeeting.setState(MeetingConstant.STATE_DELETE);
        qdMeetingMapper.insertSelective(qdMeeting);
        return qdMeeting.getId();
    }

    @Override
    public QdMeeting getMeetingDetail(long meetingId) {
        QdMeeting qdMeeting = qdMeetingMapper.selectByPrimaryKey(meetingId);
        return qdMeeting;
    }
}
