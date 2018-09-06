package com.zero.cr.pojo;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "`flash_comment_log`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlashCommentLog {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`flash_comment_log_id`")
    @GeneratedValue(generator = "JDBC")
    private Long flashCommentLogId;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 类型 1：评论日志|2：赞日志|3：赞评论
     */
    @Column(name = "`type`")
    private Long type;

    /**
     * 所赞对象id

     */
    @Column(name = "`type_id`")
    private Long typeId;

    /**
     * 发布时间
     */
    @Column(name = "`create_time`")
    private Date createTime;
}