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

@Table(name = "`comment`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    /**
     * id主键
     */
    @Id
    @Column(name = "`comment_id`")
    @GeneratedValue(generator = "JDBC")
    private Long commentId;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 日志id
     */
    @Column(name = "`flash_id`")
    private Long flashId;

    /**
     * 获赞数
     */
    @Column(name = "`support_sum`")
    private Long supportSum;

    /**
     * 评论时间
     */
    @Column(name = "`comment_time`")
    private Date commentTime;

    /**
     * 内容
     */
    @Column(name = "`content`")
    private String content;
    /**
    * 用户
    */
    private User user;

    /**
     * 评论点赞记录
     */
    private  FlashCommentLog flashCommentLog;

    /**
    * 当前登陆用户的是否点赞该用户
    */
    private Integer isZan;
}