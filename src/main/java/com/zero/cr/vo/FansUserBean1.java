package com.zero.cr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FansUserBean1 {

    /**
     * 粉丝id
     */
    private Long userFansId;
    /**
     * 粉丝的名称
     */
    private String username;
    /**
     * 粉丝的总里程
     */
    private Float contributeMils;
    /**
     * 粉丝的性别
     */
    private String gender;
    /**
     * 粉丝的头像
     */
    private String headImg;
}

