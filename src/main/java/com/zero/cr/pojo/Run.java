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

@Table(name = "`run`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Run {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`run_id`")
    @GeneratedValue(generator = "JDBC")
    private Long runId;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 主题id
     */
    @Column(name = "`subject_id`")
    private Long subjectId;

    /**
     * 本次跑总里程数
     */
    @Column(name = "`total_mileage`")
    private Double totalMileage;

    /**
     * 用时(单位：秒/s）
     */
    @Column(name = "`total_time`")
    private String totalTime;

    /**
     * 起始点
     */
    @Column(name = "`start_point_id`")
    private Long startPointId;

    /**
     * 结束点
     */
    @Column(name = "`end_point_id`")
    private Long endPointId;

    /**
     * 起始时间
     */
    @Column(name = "`start_time`")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "`end_time`")
    private Date endTime;
}