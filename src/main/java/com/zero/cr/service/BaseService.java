package com.zero.cr.service;

import com.github.pagehelper.PageInfo;
import com.zero.cr.utils.MyMapper;

import java.util.List;

/**
 * @author Hxf
 * @version V1.0
 * @Title: 通用 Service
 * @Description: Test
 * @date
 */
public interface BaseService<T> {

    /**
     * 创建的 ServiceImpl 需 @Override 次方法并返回相应的 Mapper
     * @return
     */
    MyMapper<T> getMapper();

    /**
     * 添加一条数据
     * @param t
     * @return
     */
    boolean add(T t);

    /**
     * 动态更新一条数据
     * @param t
     * @return
     */
    boolean update(T t);

    /**
     * 根据 id 删除
     * @param id
     * @return
     */
    boolean deleteById(Long id);

    /**
     * 根据 id 获取一条数据
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 根据不为空的属性获取数据 List 的返回类型
     * @param query
     * @return
     */
    List<T> getByBean(T query);

    /**
     * 获取分页后的数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<T> listByPage(int pageNum, int pageSize);

    /**
     * 获取所有数据
     * @return
     */
    List<T> listAll();

    /**
     * 获取数据条数总数
     * @return
     */
    Integer count() throws Exception;

}
