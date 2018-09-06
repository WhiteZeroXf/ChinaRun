package com.zero.cr.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFlashBean {
    /**
     * 主键id
     */


    private Long userId;

    /**
     * 用户登录名
     */

    private String username;


    /**
     * 性别
     */

    private String gender;

    /**
     * 年龄
     */

    private Integer age;

    /**
     * 生日
     */

    private Date birthday;

    /**
     * 头像
     */

    private String headImg;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 粉丝数
     */
    private Long fansSum;

    /**
     * 关注数
     */
    private Long follwSum;

    /**
     * 贡献小时
     */
/*    @Column(name = "`contribute_hours`")
    private Double contributeHours;*/

    /**
     * 贡献次数
     */
/*    @Column(name = "`contribute_sum`")
    private Integer contributeSum;*/


    /**
     * 日志主键id
     */


    private Long flashId;

    /**
     * 主题id
     */

    private Long subjectId;

    /**
     * 话题id
     */

    private Long topicId;

    /**
     * 标题
     */

    private String title;

    /**
     * 获赞数
     */

    private Long supportSum;

    /**
     * 评论数
     */

    private Long commentSum;

    /**
     * 多媒体文件*该字段暂定，后续可能使用一张表*
     */

    private String media;

    /**
     * 发表时间
     */

    private Date publishTime;

    /**
     * 发表位置
     */

    private Long pointId;

    /**
     * 内容
     */

    private String content;
    /**
     * 主题名
     */

    private String subtitle;

    /**
     * 当前用户当前主题贡献的总里程
     */
    private float totalMils;

    /**
     * 主题图片
     */
    private String img;
    /**
     * 日志点赞id
     */
    private Long flashCommentLogId;
    /**
     * 是否已关注
     */
    private Long isFans;
    /**
     * 是否互相关注
     */
    private Long isFolow;
}
