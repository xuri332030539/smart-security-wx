package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`qd_meeting_user`")
public class QdMeetingUser {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`meeting_id`")
    private Long meetingId;

    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 0:未签到    1:已签到
     */
    @Column(name = "`sign_in`")
    private Integer signIn;

    @Column(name = "`sign_date`")
    private Date signDate;

    @Column(name = "`state`")
    private String state;

    @Column(name = "`create_date`")
    private Date createDate;

    @Column(name = "`version_date`")
    private Date versionDate;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return meeting_id
     */
    public Long getMeetingId() {
        return meetingId;
    }

    /**
     * @param meetingId
     */
    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取0:未签到    1:已签到
     *
     * @return sign_in - 0:未签到    1:已签到
     */
    public Integer getSignIn() {
        return signIn;
    }

    /**
     * 设置0:未签到    1:已签到
     *
     * @param signIn 0:未签到    1:已签到
     */
    public void setSignIn(Integer signIn) {
        this.signIn = signIn;
    }

    /**
     * @return sign_date
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * @param signDate
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return version_date
     */
    public Date getVersionDate() {
        return versionDate;
    }

    /**
     * @param versionDate
     */
    public void setVersionDate(Date versionDate) {
        this.versionDate = versionDate;
    }
}