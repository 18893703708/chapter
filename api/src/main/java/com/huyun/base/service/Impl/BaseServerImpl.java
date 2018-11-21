package com.huyun.base.service.Impl;

import com.github.pagehelper.PageInfo;
import com.huyun.BaseMapper;
import com.huyun.base.model.BaseModel;
import com.huyun.base.service.BaseServer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class BaseServerImpl<T extends BaseModel> implements BaseServer<T> {

    @Autowired
    protected BaseMapper<T> mapper;

    //查询所有数据
    @Override
    public List<T> selectAll(){
        return mapper.selectAll();
    }

    //通过主键查询单个记录
    @Override
    public T findByPrimaryKey(String id){
        return mapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    //插入记录
    @Override
    public int insert(T t){
        return mapper.insertSelective(t);
    }

    //通过主键列更新数据
    @Override
    public int updateByPrimaryKey(T t){
        return mapper.updateByPrimaryKeySelective(t);
    }

    //批量删除数据
    @Override
    public int deleteByPrimaryKey(String[] ids){
        for(String id : ids){
            mapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
        return 1;
    }


    //分页查询记录
    @Override
    public PageInfo<T> selectByPage(Integer page, Integer pageSize, Map<String,Object> map){
//		PageHelper.startPage(page,pageSize);
//		Condition condition=new Condition(Role.class);
//		if(map!=null){
//			if(map.get("key")!=null &&map.get("key")!=""){
//				condition.createCriteria().andCondition("role_name like '%"+map.get("key").toString()+"%'");
//			}
//		}
//		condition.setOrderByClause("create_time desc");
//		List<T> list=mapper.selectByExample(condition);
//		return new PageInfo<>(list);
        return null;
    }



    //查询多条记录
    @Override
    public List<T> selectByT(T t){
        return mapper.select(t);
    }

    //查询单条记录
    @Override
    public T findOne(T t){
        return mapper.selectOne(t);
    }

}
