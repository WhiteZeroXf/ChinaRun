package com.zero.cr.controller;

import com.zero.cr.pojo.MsgUser;
import com.zero.cr.service.impl.FansServiceImpl;
import com.zero.cr.service.impl.MsgUserServiceImpl;
import com.zero.cr.vo.FansUserBean;
import com.zero.cr.vo.FocusUserBean;
import com.zero.cr.vo.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@RequestMapping(value = "msgUser")
public class MsgUserController {

    @Autowired
    MsgUserServiceImpl msgUserService;
    @RequestMapping(value = "findAllFocus")
    @ResponseBody
    public ResponseBean findAll(@RequestParam Long userId) {

        ResponseBean responseBean = new ResponseBean();
        List<FansUserBean> fansUserBeanList = msgUserService.selectUnreadFocus(userId);
        responseBean.setData(fansUserBeanList);
        responseBean.setCode(1);
        return responseBean;
    }
    @RequestMapping(value = "findAllZans")
    @ResponseBody
    public ResponseBean findAllZans(@RequestParam Long userId) {

        ResponseBean responseBean = new ResponseBean();
        List<FocusUserBean> focusUserBeanList = msgUserService.selectUnreadZans(userId);
        responseBean.setData(focusUserBeanList);
        responseBean.setCode(1);
        return responseBean;
    }
    @RequestMapping(value = "upState")
    @ResponseBody
    public ResponseBean upState(@RequestParam Long msgUserId){
        ResponseBean responseBean = new ResponseBean();
        MsgUser msg = new MsgUser();
        msg.setMsgUserId(msgUserId);
        msg.setState(1);
        boolean index = msgUserService.update(msg);
        responseBean.setData(index);
        responseBean.setCode(1);
        return responseBean;
    }

}