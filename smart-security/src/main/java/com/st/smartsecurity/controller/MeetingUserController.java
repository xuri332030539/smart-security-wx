package com.st.smartsecurity.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会议人员接口
 * @author lhm
 */
@RestController
@RequestMapping("meetingUser")
@Api(value = "meetingUser", tags = "会议人员接口", position = 1)
public class MeetingUserController {
}
