package com.zero.cr.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class FocusUserBean {

    private Long msgUserId;

    public Long getMsgUserId() {
        return msgUserId;
    }

    public void setMsgUserId(Long msgUserId) {
        this.msgUserId = msgUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFoucusType() {
        return foucusType;
    }

    public void setFoucusType(String foucusType) {
        this.foucusType = foucusType;
    }

    private Long userId;

    private Integer userType;

    private Long typeId;

    private Integer state;

    private Date createTime;

    private String content;
    //
    private String foucusType;



    public Long getGiveZanUserId() {
        return giveZanUserId;
    }

    public void setGiveZanUserId(Long giveZanUserId) {
        this.giveZanUserId = giveZanUserId;
    }

    private Long giveZanUserId;

    @Override
    public String toString() {
        return "FocusUserBean{" +
                "msgUserId=" + msgUserId +
                ", userId=" + userId +
                ", userType=" + userType +
                ", typeId=" + typeId +
                ", state=" + state +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", foucusType='" + foucusType + '\'' +
                ", giveZanUserId=" + giveZanUserId +
                ", username='" + username + '\'' +
                '}';
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
