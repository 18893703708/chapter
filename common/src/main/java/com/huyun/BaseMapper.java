package com.huyun;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
//这个接口不能被扫描到
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
