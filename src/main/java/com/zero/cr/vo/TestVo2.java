package com.zero.cr.vo;

import com.zero.cr.pojo.Flash;
import com.zero.cr.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class TestVo2 {
    private User user;
    private List<Flash> flashes;
}
