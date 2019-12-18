package com.st.smartsecurity.pojo.po;

import javax.persistence.*;

@Table(name = "`feedback_img`")
public class FeedbackImg {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`feedback_id`")
    private Long feedbackId;

    @Column(name = "`img`")
    private String img;

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
     * @return feedback_id
     */
    public Long getFeedbackId() {
        return feedbackId;
    }

    /**
     * @param feedbackId
     */
    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }
}