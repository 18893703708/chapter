package com.huyun.sys.model.ex;

import java.io.Serializable;

/**
 * 平台设置扩展类
 */
public class SystemConfig implements Serializable {
    private String sysName;//系统名称

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }
}