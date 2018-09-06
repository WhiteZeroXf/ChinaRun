package com.zero.cr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zero.cr.dao.FlashMapper;
import com.zero.cr.pojo.Flash;
import com.zero.cr.service.FlashService;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.UserFlashBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: Test
 * @date 2018-08-23 17:30
 */

@Service(value = "flashService")
public class FlashServiceImpl extends BaseServiceImpl<Flash> implements FlashService {

    @Resource
    private FlashMapper flashMapper;

    @Override
    public MyMapper<Flash> getMapper() {
        return flashMapper;
    }

    @Override
    public List<UserFlashBean> getAllFlash(Long topicId, Long userId) {
        return flashMapper.selectFalshByTopicId(topicId, userId);
    }

    @Override
    public PageInfo<Map> listLBRunByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = flashMapper.listAllLBRun();
        return new PageInfo<>(list);
    }

    @Override
    public int updateZan(Long id) {
        return flashMapper.updateZan(id);
    }

    @Override
    public int updateNZan(Long id) {
        return flashMapper.updateNZan(id);
    }
}
