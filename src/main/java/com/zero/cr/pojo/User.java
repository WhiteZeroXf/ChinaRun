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

@Table(name = "`user`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`user_id`")
    @GeneratedValue(generator = "JDBC")
    private Long userId;

    /**
     * 用户登录名
     */
    @Column(name = "`username`")
    private String username;

    /**
     * 登录密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 性别
     */
    @Column(name = "`gender`")
    private String gender;

    /**
     * 年龄
     */
    @Column(name = "`age`")
    private Integer age;

    /**
     * 生日
     */
    @Column(name = "`birthday`")
    private Date birthday;

    /**
     * 头像
     */
    @Column(name = "`head_img`")
    private String headImg;

    /**
     * 个性签名
     */
    @Column(name = "`sign`")
    private String sign;

    /**
     * 粉丝数
     */
    @Column(name = "`fans_sum`")
    private Long fansSum;

    /**
     * 关注数
     */
    @Column(name = "`follow_sum`")
    private Long followSum;

    /**
     * 贡献小时
     */
    @Column(name = "`contribute_hours`")
    private Double contributeHours;

    /**
     * 贡献次数
     */
    @Column(name = "`contribute_sum`")
    private Integer contributeSum;

    /**
     * 未读消息数
     */
    @Column(name = "`message_sum`")
    private Integer messageSum;

    /**
     * 总贡献里程数
     */
    @Column(name = "`contribute_mils`")
    private Double contributeMils;
}