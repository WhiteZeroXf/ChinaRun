package com.zero.cr.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "`msg_user`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgUser {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`msg_user_id`")
    @GeneratedValue(generator = "JDBC")
    private Long msgUserId;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 消息类型 1：粉丝关注|2：赞与评论
     */
    @Column(name = "`type`")
    private Integer type;

    /**
     * 对象id
     */
    @Column(name = "`type_id`")
    private Long typeId;

    /**
     * 状态 0：未读|1：已读（默认：0）
     */
    @Column(name = "`state`")
    private Integer state;

    /**
     * 发布时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 消息内容
     */
    @Column(name = "`content`")
    private String content;

    /**
    *粉丝
    */
    @Column(name = "`fans_id`")
    private Long  fansId;

    /**
     *点评记录表
     */
    @Column(name = "`flash_comment_log_id`")
    private Long flashCommentLogId;
}