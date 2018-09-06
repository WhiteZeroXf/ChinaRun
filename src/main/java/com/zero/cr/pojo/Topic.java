package com.zero.cr.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "`topic`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`topic_id`")
    @GeneratedValue(generator = "JDBC")
    private Long topicId;

    /**
     * 话题名称
     */
    @Column(name = "`topic_name`")
    private String topicName;

    /**
     * 参与人数
     */
    @Column(name = "`person_sum`")
    private Long personSum;
}