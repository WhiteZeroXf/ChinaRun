package com.zero.cr.dao;

import com.zero.cr.vo.TestVo;
import com.zero.cr.vo.TestVo2;

import java.util.List;

public interface TestMapper {

    List<TestVo> listAll();

    List<TestVo2> listAll2();

}
