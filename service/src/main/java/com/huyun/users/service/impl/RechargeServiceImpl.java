//package com.huyun.users.service.impl;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.huyun.users.dao.RechargeMapper;
//import com.huyun.users.dao.UsersMapper;
//import com.huyun.users.model.Recharge;
//import com.huyun.users.model.Users;
//import com.huyun.users.model.vo.RechargeBO;
//import com.huyun.users.service.RechargeService;
//import com.huyun.users.service.UsersCoinLogService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class RechargeServiceImpl implements RechargeService {
//    protected Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    RechargeMapper rechargeMapper;
//    @Autowired
//    UsersMapper usersMapper;
//    @Autowired
//    UsersCoinLogService usersCoinLogService;
//
//    @Override
//    public List<Recharge> selectAll() {
//        return rechargeMapper.selectAll();
//    }
//
//    @Override
//    public Recharge findByPrimaryKey(String id) {
//        return rechargeMapper.selectByPrimaryKey(Integer.parseInt(id));
//    }
//
//    @Override
//    public int insert(Recharge recharge) {
//        return rechargeMapper.insertSelective(recharge);
//    }
//
//    @Override
//    public int updateByPrimaryKey(Recharge recharge) {
//        return rechargeMapper.updateByPrimaryKeySelective(recharge);
//    }
//
//    @Override
//    public int deleteByPrimaryKey(String[] id) {
//        for (String ids:id){
//            rechargeMapper.deleteByPrimaryKey(Integer.parseInt(ids));
//        }
//        return 1;
//    }
//
//    @Override
//    public PageInfo<Recharge> selectByPage(Integer page, Integer pageSize, Map<String, Object> map) {
//        return null;
//    }
//
//    @Override
//    public List<Recharge> selectByT(Recharge recharge) {
//        return rechargeMapper.select(recharge);
//    }
//
//    @Override
//    public Recharge findOne(Recharge recharge) {
//        return rechargeMapper.selectOne(recharge);
//    }
//
//    @Override
//    public PageInfo<RechargeBO> selectByRechargeList(Integer page, Integer pageSize, Map<String,Object> map) {
//        PageHelper.startPage(page,pageSize);
//        List<RechargeBO> list = rechargeMapper.selectByRechargeList(map);
//        return new PageInfo<>(list);
//    }
//
//    @Override
//    public RechargeBO getByRechargeId(Integer RechargeId) {
//        return rechargeMapper.getByRechargeId(RechargeId);
//    }
//
//    @Override
//    public int RechargeCountByAll() {
//        return rechargeMapper.RechargeCountByAll();
//    }
//
//    @Override
//    public int RechargeCountsByToDays() {
//        return rechargeMapper.RechargeCountsByToDays();
//    }
//
//    @Override
//    public Recharge selectByOrderSn(String orderSn) {
//        return rechargeMapper.selectByOrderSn(orderSn);
//    }
//
//    @Override
//    public int updateRecharge(Integer rechargeId, Integer userId, Integer coin, Integer isPay, String thirdpartyTradeId) {
//        Users u = new Users();
//        Recharge recharge = new Recharge();
//        recharge.setRechargeId(rechargeId);
//        recharge.setIsPay(isPay);//已支付
//        recharge.setPayTime(new Date());
//        recharge.setThirdpartyTradeId(thirdpartyTradeId);
//        if(rechargeMapper.updateByPrimaryKeySelective(recharge)>0){
//            //更新用户柒略币
//            Users users = usersMapper.selectByPrimaryKey(userId);
//            Integer users_coin = users.getCoin()+coin;
//            u.setCoin(users_coin);
//            u.setUserId(users.getUserId());
//            if(usersMapper.updateByPrimaryKeySelective(u)>0){
//                String cause = "用户【"+users.getUsername()+"】支付宝充值柒略币"+coin+"，用户现在柒略币为"+users_coin;
//                usersCoinLogService.addUsersCoinLog(userId,coin,cause);
//            }else{
//                String cause = "用户【"+users.getUsername()+"】支付宝充值柒略币失败，用户现在柒略币为"+users.getCoin();
//                usersCoinLogService.addUsersCoinLog(userId,coin,cause);
//            }
//        }
//        return 1;
//    }
//}
