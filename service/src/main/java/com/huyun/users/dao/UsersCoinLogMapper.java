package com.huyun.users.dao;

import com.huyun.BaseMapper;
import com.huyun.users.model.UsersCoinLog;
import com.huyun.users.model.vo.UsersCoinLogBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UsersCoinLogMapper extends BaseMapper<UsersCoinLog> {
    //PC端查询账户记录
    @Select({
            "<script>",
            "SELECT c.*,u.username as username,u.account as account,u.coin as userCoin,r.coin as rechargeCoin from tb_users_coin_log AS c",
            "LEFT JOIN tb_users as u ON c.user_id = u.user_id",
            "LEFT JOIN tb_library as l ON u.lib_id = l.lib_id",
            "LEFT JOIN tb_province as p ON l.province_id = p.province_id",
            "LEFT JOIN tb_users_recharge as r ON r.user_id = u.user_id",
            "where 1=1",
            "<if test=\"map.username!=null and map.username !=''\">",
            "and u.username like concat('%',#{map.username}, '%')",
            "</if>",
            "<if test=\"map.province!=null and map.province !=''\">",
            "and p.province_id =#{map.province}",
            "</if>",
            "<if test=\"map.libId!=null and map.libId !=''\">",
            "and l.lib_id =#{map.libId}",
            "</if>",
            //"<if test=\"null != map.createTime and map.createTime != ''\">",
            //"and str_to_date(c.create_time,'%Y-%c-%d' )= str_to_date(#{map.createTime},'%Y-%c-%d')",
            //"</if>",
            " <when test=\"null != map.starttime and '' != map.starttime and null != map.endtime and '' != map.endtime \">",
            "   and c.create_time between DATE_FORMAT(#{map.starttime},'%Y-%m-%d 00:00:00') and DATE_FORMAT(#{map.endtime},'%Y-%m-%d 23:59:59')",
            "</when>",
            "ORDER BY c.create_time DESC",
            "</script>",
    })
    List<UsersCoinLogBO> selectUsersCoinLogList(@Param("map") Map<String, Object> map);
}
