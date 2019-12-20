package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`meeting_notice`")
public class MeetingNotice {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`meeting_id`")
    private Long meetingId;

    /**
     * 通知内容
     */
    @Column(name = "`message`")
    private String message;

    @Column(name = "`message_date`")
    private Date messageDate;

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
     * 获取通知内容
     *
     * @return message - 通知内容
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置通知内容
     *
     * @param message 通知内容
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return message_date
     */
    public Date getMessageDate() {
        return messageDate;
    }

    /**
     * @param messageDate
     */
    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
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