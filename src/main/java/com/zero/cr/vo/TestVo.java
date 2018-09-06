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
 * @Title:
 * @Description: TODO
 * @date 2018/8/27 19:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestVo {

    private User user;
    private Topic topic;
    private Flash flash;

}
