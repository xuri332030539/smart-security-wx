package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`qd_user`")
public class QdUser {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`name`")
    private String name;

    /**
     * 工号
     */
    @Column(name = "`work_number`")
    private String workNumber;

    @Column(name = "`phone`")
    private String phone;

    /**
     * 微信唯一标识符
     */
    @Column(name = "`open_id`")
    private String openId;

    @Column(name = "`head_url`")
    private String headUrl;

    @Column(name = "`state`")
    private String state;

    @Column(name = "`create_date`")
    private Date createDate;

    @Column(name = "`version_date`")
    private Date versionDate;

    @Column(name = "`nickName`")
    private String nickname;

    /**
     * 0:男    1:女
     */
    @Column(name = "`gender`")
    private Integer gender;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取工号
     *
     * @return work_number - 工号
     */
    public String getWorkNumber() {
        return workNumber;
    }

    /**
     * 设置工号
     *
     * @param workNumber 工号
     */
    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取微信唯一标识符
     *
     * @return open_id - 微信唯一标识符
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信唯一标识符
     *
     * @param openId 微信唯一标识符
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return head_url
     */
    public String getHeadUrl() {
        return headUrl;
    }

    /**
     * @param headUrl
     */
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
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

    /**
     * @return nickName
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取0:男    1:女
     *
     * @return gender - 0:男    1:女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置0:男    1:女
     *
     * @param gender 0:男    1:女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }
}