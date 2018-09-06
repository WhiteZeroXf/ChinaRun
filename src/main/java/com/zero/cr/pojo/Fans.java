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

@Table(name = "`fans`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fans {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`fans_id`")
    @GeneratedValue(generator = "JDBC")
    private Long fansId;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 粉丝id
     */
    @Column(name = "`user_fans_id`")
    private Long userFansId;

    /**
     * 关注时间
     */
    @Column(name = "`create_time`")
    private Date createTime;
}