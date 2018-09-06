package com.zero.cr.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class FansUserBean {
    private Long msgUserId;

    /**
     * 用户id
     */

    private Long userId;

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

    public Integer getType() {
        return type;
    }


    public void setType(Integer type) {
        this.type = type;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 消息类型 1：粉丝关注|2：赞与评论
     */

    private Integer type;

    @Override
    public String toString() {
        return "FansUserBean{" +
                "msgUserId=" + msgUserId +
                ", userId=" + userId +
                ", type=" + type +
                ", typeId=" + typeId +
                ", state=" + state +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", userFansId='" + userFansId + '\'' +
                '}';
    }

    /**
     * 对象id
     */

    private Long typeId;

    /**
     * 状态 0：未读|1：已读（默认：0）
     */

    private Integer state;

    /**
     * 发布时间
     */

    private Date createTime;

    /**
     * 消息内容
     */

    private String content;
    private String username;
    private String userFansId;

    public String getUserFansId() {
        return userFansId;
    }

    public void setUserFansId(String userFansId) {
        this.userFansId = userFansId;
    }
}

