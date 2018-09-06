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

@Table(name = "`join`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Join {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`join_id`")
    @GeneratedValue(generator = "JDBC")
    private Long joinId;

    /**
     * 主题id
     */
    @Column(name = "`subject_id`")
    private Long subjectId;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 参加时间
     */
    @Column(name = "`join_time`")
    private Date joinTime;
/**
     * 当前主题用户跑步总里程数
     */
    @Column(name = "`total_mils`")
    private Float totalMils;
}