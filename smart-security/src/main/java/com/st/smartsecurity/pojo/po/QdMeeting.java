package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`qd_meeting`")
public class QdMeeting {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 发起人
     */
    @Column(name = "`name`")
    private String name;

    @Column(name = "`initiator_id`")
    private Long initiatorId;

    @Column(name = "`start_date`")
    private Date startDate;

    @Column(name = "`state`")
    private String state;

    @Column(name = "`end_date`")
    private Date endDate;

    @Column(name = "`content`")
    private String content;

    @Column(name = "`address`")
    private String address;

    @Column(name = "`initiator_phone`")
    private String initiatorPhone;

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
     * 获取发起人
     *
     * @return name - 发起人
     */
    public String getName() {
        return name;
    }

    /**
     * 设置发起人
     *
     * @param name 发起人
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return initiator_id
     */
    public Long getInitiatorId() {
        return initiatorId;
    }

    /**
     * @param initiatorId
     */
    public void setInitiatorId(Long initiatorId) {
        this.initiatorId = initiatorId;
    }

    /**
     * @return start_date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
     * @return end_date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return initiator_phone
     */
    public String getInitiatorPhone() {
        return initiatorPhone;
    }

    /**
     * @param initiatorPhone
     */
    public void setInitiatorPhone(String initiatorPhone) {
        this.initiatorPhone = initiatorPhone;
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