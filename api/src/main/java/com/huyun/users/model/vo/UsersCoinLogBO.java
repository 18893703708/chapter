package com.huyun.users.model.vo;

import com.huyun.users.model.UsersCoinLog;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_users_coin_log")
public class UsersCoinLogBO extends UsersCoinLog {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String username;
    private String account; //会员账号
    private Integer userCoin;//会员的柒略币
    private Integer rechargeCoin;//充值的柒略币

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getUserCoin() {
        return userCoin;
    }

    public void setUserCoin(Integer userCoin) {
        this.userCoin = userCoin;
    }

    public Integer getRechargeCoin() {
        return rechargeCoin;
    }

    public void setRechargeCoin(Integer rechargeCoin) {
        this.rechargeCoin = rechargeCoin;
    }
}
