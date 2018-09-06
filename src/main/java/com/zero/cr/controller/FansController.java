package com.zero.cr.controller;

import com.zero.cr.pojo.MsgUser;
import com.zero.cr.pojo.User;
import com.zero.cr.service.MsgUserService;
import com.zero.cr.service.impl.FansServiceImpl;
import com.zero.cr.utils.ResponseBeanUtil;
import com.zero.cr.vo.FansUserBean;
import com.zero.cr.vo.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "fans")
public class FansController {
    @Autowired
    FansServiceImpl fansService;
    @Autowired
    private MsgUserService msgUserService;
    @RequestMapping(value = "findAll")
    @ResponseBody
    public ResponseBean findAll() {

            ResponseBean responseBean = new ResponseBean();
            List<FansUserBean> fansUserBeanPageInfo= fansService.listFansUser();
            responseBean.setData(fansUserBeanPageInfo);
            return responseBean;
    }
    /**
     * 根据当前用户ID查询粉丝信息
     * @param userId
     * @return user
     */
    @RequestMapping(value = "getFansById")
    @ResponseBody
    public ResponseBean getFansById(Long userId) {
        List<User> user = fansService.getFansById(userId);
        return ResponseBeanUtil.success(user);
    }
    /**
     * 根据当前用户ID查询关注信息
     * @param userId
     * @return user
     */
    @RequestMapping(value = "getFollowById")
    @ResponseBody
    public ResponseBean getFollowById(Long userId) {
        List<User> user = fansService.getFollowById(userId);
        return ResponseBeanUtil.success(user);
    }
    /**
     * 粉丝关注
     * @param userId,userFansId
     * @return boolean
     */

    @RequestMapping("/addFans")
    @ResponseBody
    public ResponseBean   addFans(Integer state , Long userId, Long userFansId, MsgUser msgUser) throws  Exception{
        int ok = fansService.follow(state,userId,userFansId);
        if (ok>0){
            Number number = fansService.selectFansId(userId, userFansId);
            Long FansId = number.longValue();
            msgUser.setUserId(userId);
            msgUser.setTypeId(userFansId);
            msgUser.setFansId(FansId);
            msgUser.setType(1);
            msgUser.setState(0);
            msgUserService.add(msgUser);

        }
        return  ResponseBeanUtil.success(ok);

    }


}
