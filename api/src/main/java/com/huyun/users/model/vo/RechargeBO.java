package com.huyun.users.model.vo;


import com.huyun.users.model.Recharge;

/**
 * @Auther: 张琛栋 QQ：847890638
 * @Date: 2018/7/10 09:09
 * @Description:
 */
public class RechargeBO extends Recharge {
    private String account;

    private String mobile;

    private String username;

    private String libraryName;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
}
