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

@Table(name = "`msg_system`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgSystem {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`mst_system_id`")
    @GeneratedValue(generator = "JDBC")
    private Long mstSystemId;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 消息内容
     */
    @Column(name = "`content`")
    private String content;

    /**
     * 状态
     */
    @Column(name = "`state`")
    private Integer state;

    /**
     * 发布时间
     */
    @Column(name = "`create_time`")
    private Date createTime;
}