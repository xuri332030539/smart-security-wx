package com.st.smartsecurity.pojo.po;

import javax.persistence.*;

@Table(name = "`meeting_manager`")
public class MeetingManager {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`meeting_id`")
    private Long meetingId;

    @Column(name = "`manager_id`")
    private Long managerId;

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
     * @return manager_id
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * @param managerId
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}