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

@Table(name = "`point`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Point {

    /**
     * 主键id
     */
    @Id
    @Column(name = "`point_id`")
    @GeneratedValue(generator = "JDBC")
    private Long pointId;

    @Column(name = "`run_id`")
    private Long runId;

    @Column(name = "`lng`")
    private Float lng;

    @Column(name = "`lat`")
    private Float lat;

    @Column(name = "`type`")
    private Integer type;

    @Column(name = "`create_time`")
    private Date createTime;

}
