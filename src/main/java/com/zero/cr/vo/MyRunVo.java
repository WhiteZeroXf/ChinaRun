package com.zero.cr.vo;

import com.zero.cr.pojo.Join;
import com.zero.cr.pojo.Subject;
import com.zero.cr.pojo.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lgj
 * @version V1.0
 * @Title:
 * @Description: TODO
 * @date 2018/8/28 14:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyRunVo {
    private Join join;
    private Topic topic;
    private Subject subject;
}
