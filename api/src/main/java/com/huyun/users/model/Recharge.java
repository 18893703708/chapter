package com.huyun.users.model;


import com.huyun.base.model.BaseModel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_users_recharge")
public class Recharge extends BaseModel {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer rechargeId;

    private Integer userId;

    private String orderSn;

    private Integer coin;

    private Integer money;

    private Date createTime;

    private String createIp;

    private Date payTime;

    private String payIp;

    private Integer isPay;

    private String thirdpartyTradeId;

    private String payType;

    public Integer getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Integer rechargeId) {
        this.rechargeId = rechargeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayIp() {
        return payIp;
    }

    public void setPayIp(String payIp) {
        this.payIp = payIp;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public String getThirdpartyTradeId() {
        return thirdpartyTradeId;
    }

    public void setThirdpartyTradeId(String thirdpartyTradeId) {
        this.thirdpartyTradeId = thirdpartyTradeId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
