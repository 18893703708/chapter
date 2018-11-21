package com.huyun.base.service;

import com.github.pagehelper.PageInfo;
import com.huyun.base.model.BaseModel;

import java.util.List;
import java.util.Map;

public interface  BaseServer <T extends BaseModel> {
    //查询所有数据
    List<T> selectAll();

    //通过主键查询单个记录
    T findByPrimaryKey(String id);

    //插入记录
    int insert(T t);

    //通过主键列更新数据
    int updateByPrimaryKey(T t);

    //批量删除数据
    int deleteByPrimaryKey(String[] id);


    //分页查询记录
    PageInfo<T> selectByPage(Integer page, Integer pageSize, Map<String,Object> map);



    //查询多条记录
    List<T> selectByT(T t);

    //查询单条记录
    T findOne(T t);
}
