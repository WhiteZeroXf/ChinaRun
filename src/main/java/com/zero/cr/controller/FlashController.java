package com.zero.cr.controller;

import com.zero.cr.service.FlashCommentLogService;
import com.zero.cr.service.FlashService;
import com.zero.cr.utils.ResponseBeanUtil;
import com.zero.cr.vo.ResponseBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/flash")
public class FlashController {

    @Resource(name = "flashService")
    private FlashService flashService;

    @Resource(name = "flashCommentLogService")
    private FlashCommentLogService flashCommentLogService;

    @RequestMapping(value = "/listAllFlash")
    public ResponseBean listAllFlash(Long topicId,Long userId) {
        return ResponseBeanUtil.success(flashService.getAllFlash(topicId,userId));
    }

    @RequestMapping(value = "LBRun")
    public ResponseBean LBRun(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                                  @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        return ResponseBean.builder().data(flashService.listLBRunByPage(pageNum, pageSize)).build();
    }

    @RequestMapping("/zan")
    public ResponseBean  flashZan(Long userId,Long id){
        int a = flashCommentLogService.selectZanFlashRecord(userId,id);
        int  b=0;
        if (a==0){
             b=flashCommentLogService.insertZanFlashRecord(userId,id);
           if (b>0){
               flashService.updateZan(id);
           }

        }else if (a==1){
            b=flashCommentLogService.deleteZanFlashRecord(userId,id);
            if(b>0){
              flashService.updateNZan(id);
            }

        }

        return ResponseBeanUtil.success(a);
    }
  /*  @RequestMapping("/Nzan")
    public ResponseBean  flashNZan(Long id){
        return ResponseBeanUtil.success(flashService.updateNZan(id));
    }
*/
}