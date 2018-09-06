package com.zero.cr.controller;

import com.zero.cr.vo.ResponseBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @RequestMapping(value = "upload")
    public ResponseBean upload(String[] imgs, MultipartFile[] files) {
        System.out.println("file:" + files);
        System.out.println(Arrays.toString(imgs));
        return ResponseBean.builder().build();
    }

}
