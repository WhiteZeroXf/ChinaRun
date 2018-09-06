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

@Table(name = "`subject`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`subject_id`")
    @GeneratedValue(generator = "JDBC")
    private Long subjectId;

    /**
     * 标题
     */
    @Column(name = "`title`")
    private String title;

    /**
     * 话题id
     */
    @Column(name = "`topic_id`")
    private Long topicId;

    /**
     * 主题图片
     */
    @Column(name = "`img`")
    private String img;

    /**
     * 总里程数
     */
    @Column(name = "`mileage_total`")
    private Double mileageTotal;

    /**
     * 已完成里程数
     */
    @Column(name = "`mileage_finish`")
    private Double mileageFinish;

    /**
     * 参与人数
     */
    @Column(name = "`person_sum`")
    private Long personSum;

    /**
     * 发起人id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 发起时间
     */
    @Column(name = "`start_time`")
    private Date startTime;

    /**
     * 完成时间
     */
    @Column(name = "`finish_time`")
    private Date finishTime;

    /**
     * 发起地点
     */
    @Column(name = "`point_id`")
    private Long pointId;

    /**
     * 状态 0：未审核|1：未完成|2：已完成（默认：0）

     */
    @Column(name = "`state`")
    private Integer state;

    /**
     * 内容
     */
    @Column(name = "`content`")
    private String content;
}