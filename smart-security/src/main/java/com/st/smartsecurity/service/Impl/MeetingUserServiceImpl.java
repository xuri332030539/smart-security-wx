package com.st.smartsecurity.service.impl;

import com.st.smartsecurity.service.MeetingUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会议人员接口
 * @author lhm
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MeetingUserServiceImpl implements MeetingUserService {
}
