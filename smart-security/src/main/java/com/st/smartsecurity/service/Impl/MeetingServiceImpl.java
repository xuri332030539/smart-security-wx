package com.st.smartsecurity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.constant.MeetingConstant;
import com.st.smartsecurity.mapper.QdMeetingMapper;
import com.st.smartsecurity.mapper.QdMeetingUserMapper;
import com.st.smartsecurity.mapper.QdUserMapper;
import com.st.smartsecurity.pojo.dto.MeetingDTO;
import com.st.smartsecurity.pojo.po.QdMeeting;
import com.st.smartsecurity.pojo.po.QdMeetingUser;
import com.st.smartsecurity.pojo.po.QdUser;
import com.st.smartsecurity.pojo.vo.params.MeetingParamsVO;
import com.st.smartsecurity.pojo.vo.MeetingVO;
import com.st.smartsecurity.service.MeetingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**会议接口
 * @author lhm
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MeetingServiceImpl implements MeetingService {

    @Resource
    QdMeetingMapper qdMeetingMapper;
    @Resource
    QdUserMapper qdUserMapper;
    @Resource
    QdMeetingUserMapper qdMeetingUserMapper;

    @Override
    public long addMeeting(MeetingVO meetingVO) {
        if(meetingVO.getStartDate() != null && meetingVO.getEndDate() != null){
            long startTime = meetingVO.getStartDate().getTime();
            long endTime = meetingVO.getEndDate().getTime();
            Preconditions.checkArgument(startTime <= endTime,"开始时间不能小于结束时间");
        }
        QdMeeting qdMeeting = BeanUtil.copyProperties(meetingVO, QdMeeting.class);
        qdMeeting.setCreateDate(new Date());
        qdMeeting.setVersionDate(new Date());
        qdMeeting.setState(MeetingConstant.STATE_NORMAL);
        qdMeetingMapper.insertSelective(qdMeeting);
        return qdMeeting.getId();
    }

    @Override
    public void deleteMeeting(long meetingId) {
        QdMeeting qdMeeting = new QdMeeting();
        qdMeeting.setId(meetingId);
        qdMeeting.setState(MeetingConstant.STATE_DELETE);
        qdMeeting.setVersionDate(new Date());
        qdMeetingMapper.updateByPrimaryKeySelective(qdMeeting);
    }

    @Override
    public void updateMeeting(MeetingVO meetingVO) {
        QdMeeting qdMeeting = BeanUtil.copyProperties(meetingVO, QdMeeting.class);
        qdMeeting.setVersionDate(new Date());
        qdMeetingMapper.updateByPrimaryKeySelective(qdMeeting);
    }

    @Override
    public MeetingDTO getMeetingDetail(long meetingId) {
        QdMeeting qdMeeting = qdMeetingMapper.selectByPrimaryKey(meetingId);
        MeetingDTO meetingDTO = BeanUtil.copyProperties(qdMeeting, MeetingDTO.class);
        meetingDTO.setMeetingState(checkMeetingState(meetingDTO.getStartDate(),meetingDTO.getEndDate() != null?meetingDTO.getEndDate():null));
        QdUser qdUser = qdUserMapper.selectByPrimaryKey(meetingDTO.getInitiatorId());
        if(qdUser != null){
            meetingDTO.setInitiatorName(qdUser.getName());
        }
        //查看所有用户
        QdMeetingUser qdMeetingUser = new QdMeetingUser();
        qdMeetingUser.setMeetingId(meetingId);
        qdMeetingUser.setState(MeetingConstant.STATE_NORMAL);
        int sumPeople = qdMeetingUserMapper.selectCount(qdMeetingUser);
        meetingDTO.setSumPeople(sumPeople);
        //查看未签到用户
        Example example = new Example(QdMeetingUser.class);
        example.createCriteria().andEqualTo("meetingId",meetingId).andEqualTo("state",MeetingConstant.STATE_NORMAL).andIsNotNull("signDate");
        int signPeople = qdMeetingUserMapper.selectCountByExample(example);
        meetingDTO.setSignPeople(signPeople);
        meetingDTO.setAbsentPeople(sumPeople - signPeople);
        return meetingDTO;
    }

    @Override
    public PageInfo listMeeting(MeetingParamsVO meetingParamsVO) {
        //查询参数
        Example example = new Example(QdMeeting.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andNotEqualTo("state",MeetingConstant.STATE_DELETE);
        example.setOrderByClause("start_date DESC");
        PageHelper.startPage(meetingParamsVO.getPageNum(), meetingParamsVO.getPageSize());
        List<QdMeeting> meetingList = qdMeetingMapper.selectByExample(example);
        //处理结果
        PageInfo pageInfo = new PageInfo(meetingList);
        List<MeetingDTO> meetingDTOList = Lists.newArrayList();
        List<QdMeeting> qdMeetings = pageInfo.getList();
        for (QdMeeting qdMeeting:qdMeetings) {
            MeetingDTO meetingDTO = BeanUtil.copyProperties(qdMeeting, MeetingDTO.class);
            meetingDTO.setMeetingState(checkMeetingState(meetingDTO.getStartDate(),meetingDTO.getEndDate() != null?meetingDTO.getEndDate():null));
            meetingDTOList.add(meetingDTO);
        }
        pageInfo.setList(meetingDTOList);
        return pageInfo;
    }

    @Override
    public String checkMeetingState(Date startDate, Date endDate) {
        String string = "时间未确定";
        if(endDate == null){
            int timeFlag = new Date().compareTo(startDate);
            if(timeFlag > 0){
                string = "会议已结束";
            }
            if(timeFlag == 0){
                string = "会议进行中";
            }
            if(timeFlag < 0){
                string = "会议未开始";
            }
        }else {
            Date date = new Date();
            if(date.before(startDate)){
                string = "会议未开始";
            }
            if(date.after(endDate)){
                string = "会议已结束";
            }
            if(date.after(startDate) && date.before(endDate)){
                string = "会议进行中";
            }
        }
        return string;
    }
}
