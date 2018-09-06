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

@Table(name = "`flash`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flash {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`flash_id`")
    @GeneratedValue(generator = "JDBC")
    private Long flashId;

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
     * 话题id
     */
    @Column(name = "`topic_id`")
    private Long topicId;

    /**
     * 标题
     */
    @Column(name = "`title`")
    private String title;

    /**
     * 获赞数
     */
    @Column(name = "`support_sum`")
    private Long supportSum;

    /**
     * 评论数
     */
    @Column(name = "`comment_sum`")
    private Long commentSum;

    /**
     * 多媒体文件*该字段暂定，后续可能使用一张表*
     */
    @Column(name = "`media`")
    private String media;

    /**
     * 发表时间
     */
    @Column(name = "`publish_time`")
    private Date publishTime;

    /**
     * 发表位置
     */
    @Column(name = "`point_id`")
    private Long pointId;

    /**
     * 内容
     */
    @Column(name = "`content`")
    private String content;
}