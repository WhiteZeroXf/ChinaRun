package com.zero.cr.controller;

import com.github.pagehelper.PageInfo;
import com.zero.cr.pojo.MsgSystem;
import com.zero.cr.pojo.User;
import com.zero.cr.service.BaseService;
import com.zero.cr.service.impl.MsgSystemServiceImpl;
import com.zero.cr.service.impl.UserServiceImpl;
import com.zero.cr.utils.ResponseBeanUtil;
import com.zero.cr.vo.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "msgSystem")
public class MsgSystemController {
    @Autowired
    MsgSystemServiceImpl msgSystemService;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "findUnread")
    @ResponseBody
    public ResponseBean findUnread(@RequestParam Long userId) {
            ResponseBean responseBean = new ResponseBean();
            List<MsgSystem> msgSystemList = msgSystemService.listUnread(userId);
            responseBean.setData(msgSystemList);
            responseBean.setCode(1);
            return responseBean;
    }
    @RequestMapping(value = "findById")
    @ResponseBody
    public ResponseBean selectById(@RequestParam Long mstSystemId){
        MsgSystem msg = new MsgSystem();
        msg.setMstSystemId(mstSystemId);
        List<MsgSystem> msgSystem =msgSystemService.getByBean(msg);
        MsgSystem msgSystem1 = msgSystem.get(0);
        Long userId =msgSystem1 .getUserId();
        User user1 = new User();
        user1.setUserId(userId);
        List<User> users = userService.getByBean(user1);
        User user = users.get(0);
        Map<String,Object> map = new HashMap<>();
        map.put("msg",msgSystem1);
        map.put("user",user);
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(map);
        responseBean.setCode(1);
        return responseBean;
    }
    @RequestMapping(value = "upState")
    @ResponseBody
    public ResponseBean upState(@RequestParam Long mstSystemId){
        ResponseBean responseBean = new ResponseBean();
        MsgSystem msg = new MsgSystem();
        msg.setMstSystemId(mstSystemId);
        msg.setState(1);
        boolean index = msgSystemService.update(msg);
        responseBean.setData(index);
        responseBean.setCode(1);
        return responseBean;
    }
}
 /*
 @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "3"
 try {
         PageInfo<MsgSystem> msgSystemPageInfo = msgSystemService.listByPage(pageNum, pageSize);
        return ResponseBeanUtil.success(msgSystemPageInfo);
        } catch (Exception e) {
        return ResponseBean.builder().code(-1).msg(e.getMessage()).build();
        }*/