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

@Table(name = "`inform`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inform {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`inform_id`")
    @GeneratedValue(generator = "JDBC")
    private Long informId;

    /**
     * 类型 1：举报日志|2：举报评论
     */
    @Column(name = "`type`")
    private Integer type;

    /**
     * 所赞对象id
     */
    @Column(name = "`type_id`")
    private Long typeId;

    /**
     * 举报用户id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 举报原因
     */
    @Column(name = "`reason`")
    private String reason;

    /**
     * 举报时间
     */
    @Column(name = "`create_time`")
    private Date createTime;
}