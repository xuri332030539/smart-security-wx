package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`user_feedbacd`")
public class UserFeedbacd {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`user_id`")
    private Long userId;

    @Column(name = "`content`")
    private String content;

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