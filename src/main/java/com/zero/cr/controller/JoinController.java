package com.zero.cr.controller;

import com.zero.cr.pojo.Join;
import com.zero.cr.service.JoinService;
import com.zero.cr.utils.ResponseBeanUtil;
import com.zero.cr.vo.MyRunVo;
import com.zero.cr.vo.ResponseBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(value = "join")
public class JoinController {
    @Resource
    private JoinService joinService;

    /**
     * 查询我的快跑
     * @param userId
     * @return
     */
    @RequestMapping("getMyRunById")
    public ResponseBean getById(Long userId) {
        List<Join> join = joinService.getMyRunById(userId);
        return ResponseBeanUtil.success(join);
    }
    /**
     * 查询我的发起
     * @param
     * @param
     * @return
     */
    @RequestMapping("/getMyStart")
    public ResponseBean myStart(Long userId){
        ResponseBean responseBean = new ResponseBean();
        List<MyRunVo> myStartSubjects = joinService.getMyStart(userId);
        responseBean.setData(myStartSubjects);
        responseBean.setCode(1);
        return responseBean;
    }

}
