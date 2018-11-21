package com.huyun.users.dao;


import com.huyun.BaseMapper;
import com.huyun.users.model.Recharge;
import com.huyun.users.model.vo.RechargeBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RechargeMapper extends BaseMapper<Recharge> {
    //后台 根据条件获取充值列表
    @Select({
            "<script>",
            "SELECT r.*,u.account,u.username from tb_users_recharge as r",
            "LEFT JOIN tb_users as u on u.user_id = r.user_id",
            "where 1=1 ",
            "<if test=\"null != map.key and map.key != ''\">",
                "and u.account like concat('%',#{map.key}, '%')",
            "</if>",
            "<if test='null != map.isPay'>",
                "and r.is_pay=#{map.isPay}",
            "</if>",
            "<if test='null != map.userId'>",
                "and r.user_id=#{map.userId}",
            "</if>",
            "ORDER BY r.create_time desc",
            "</script>",
    })
    List<RechargeBO> selectByRechargeList(@Param("map") Map<String, Object> map);

    //根据用户Id查询用户信息
    @Select({
            "<script>",
            "SELECT r.*,u.account,u.mobile,u.username,l.library_name from tb_users_recharge as r",
            "LEFT JOIN tb_users as u on r.user_id=u.user_id",
            "LEFT JOIN tb_library as l on u.lib_id=l.lib_id",
            "WHERE 1=1 and r.recharge_id= #{rechargeId}",
            "</script>"
    })
    RechargeBO getByRechargeId(@Param("rechargeId") Integer rechargeId);


    //统计充值总数
    @Select("select COUNT(*) from tb_users_recharge where is_pay=1")
    int RechargeCountByAll();

    //统计今日新增
    @Select("SELECT count(*) from tb_users_recharge where TO_DAYS(create_time) = TO_DAYS(NOW()) and is_pay=1")
    int RechargeCountsByToDays();

    //根据订单号查询
    @Select("SELECT * FROM tb_users_recharge WHERE order_sn = #{orderSn}")
    Recharge selectByOrderSn(String orderSn);
}
