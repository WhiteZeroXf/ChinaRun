dao 的 Mapper 已经实现了如下方法：
常用方法：
    查询数据：
        条件查询：mapper.select(T t);字段不为空时自动关联查询条件
        主键查询：mapper.selectByPrimaryKey(Object object);
        查询所有：mapper.selectAll();
    更新数据：
        动态更新：mapper.updateByPrimaryKeySelective(T t);
    删除数据：
        主键删除：mapper.deleteByPrimaryKey(Object object);
        条件删除：mapper.delete(T t);
    添加数据：
        单条插入：mapper.insert(T t);
        批量插入：mapper.insertList(List<T> list);
    获取数据总数：
        根据类型获取总数：mapper.selectCount(T t);
如需添加自己的方法直接在 Mapper 中添加，并实现其在xml中的sql映射

Service 已集成部分方法，方法详见 BaseService 接口