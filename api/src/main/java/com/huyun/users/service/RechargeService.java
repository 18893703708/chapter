package com.huyun.users.service;

import com.github.pagehelper.PageInfo;
import com.huyun.base.service.BaseServer;
import com.huyun.users.model.Recharge;
import com.huyun.users.model.vo.RechargeBO;

import java.util.Map;

public interface RechargeService extends BaseServer<Recharge> {
    PageInfo<RechargeBO> selectByRechargeList(Integer page, Integer pageSize, Map<String, Object> map);

    RechargeBO getByRechargeId(Integer RechargeId);

    //充值总数
    int RechargeCountByAll();

    //今日新增
    int RechargeCountsByToDays();


    //根据订单号查询
    Recharge selectByOrderSn(String orderSn);

    //修改订单信息
    int  updateRecharge(Integer rechargeId, Integer userId, Integer coin, Integer isPay, String thirdpartyTradeId);
}
