package com.huyun.users.model;


import com.huyun.base.model.BaseModel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_users_coin_log")
public class UsersCoinLog extends BaseModel {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer coinId;
  private Integer userId;
  private Integer coin;
  private Date createTime;
  private String cause;

  public Integer getCoinId() {
    return coinId;
  }

  public void setCoinId(Integer coinId) {
    this.coinId = coinId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getCoin() {
    return coin;
  }

  public void setCoin(Integer coin) {
    this.coin = coin;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }
}
