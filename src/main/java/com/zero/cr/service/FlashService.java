package com.zero.cr.service;

import com.github.pagehelper.PageInfo;
import com.zero.cr.pojo.Flash;
import com.zero.cr.vo.UserFlashBean;

import java.util.List;
import java.util.Map;

public interface FlashService extends BaseService<Flash> {

    List<UserFlashBean>   getAllFlash(Long topicId, Long userId);//查询当前话题下的用户动态详情

    /**
     * 获取分页后的李白跑地球首页的日志+发表用户+主题
     * 最后修改：Hxf
     * @param pageNum 起始页
     * @param pageSize 每页条数
     * @return 分页包装后的 PageInfo
     */
    PageInfo<Map> listLBRunByPage(int pageNum, int pageSize);


    int  updateZan(Long id);//日志获赞

    int  updateNZan(Long id); //取消赞

}
