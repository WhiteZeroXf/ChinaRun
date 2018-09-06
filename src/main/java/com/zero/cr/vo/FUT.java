package com.zero.cr.vo;

import com.zero.cr.pojo.Flash;
import com.zero.cr.pojo.Topic;
import com.zero.cr.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hxf
 * @version V1.0
 * @Title: 发现 李白跑地球 vo 实体类
 * @Description: Flash + User + Topic 视图类
 * @date 2018/8/28 15:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FUT {

    private Flash flash;
    private Topic topic;
    private User user;

}
