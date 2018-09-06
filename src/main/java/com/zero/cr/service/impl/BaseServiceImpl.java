package com.zero.cr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zero.cr.service.BaseService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings(value = {"unchecked"})
@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private Class clazz;

    BaseServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @CacheEvict(value = {"default"}, allEntries = true)
    @Override
    public boolean add(T t) {
        if (t == null)
            return false;
        return getMapper().insert(t) > 0;
    }

    @CacheEvict(value = {"default"}, allEntries = true)
    @Override
    public boolean update(T t) {
        if (t == null)
            return false;
        return getMapper().updateByPrimaryKeySelective(t) > 0;
    }

    @CacheEvict(value = {"default"}, allEntries = true)
    @Override
    public boolean deleteById(Long id) {
        if (id < 1)
            return false;
        return getMapper().deleteByPrimaryKey(id) > 0;
    }

    @Cacheable(value = "default")
    @Override
    public T getById(Long id) {
        if (id < 0)
            return null;
        return getMapper().selectByPrimaryKey(id);
    }

    @Cacheable(value = "default")
    @Override
    public List<T> getByBean(T query) {
        return getMapper().select(query);
    }

    @Cacheable(value = "default")
    @Override
    public PageInfo<T> listByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = getMapper().selectAll();
        return new PageInfo<>(list);
    }

    @Cacheable(value = "default")
    @Override
    public Integer count() throws Exception {
        if (clazz != null) {
            T t = (T) clazz.getConstructor().newInstance();
            return getMapper().selectCount(t);
        }
        return -1;
    }

    @Cacheable(value = "default")
    @Override
    public List<T> listAll() {
        return getMapper().selectAll();
    }
}
