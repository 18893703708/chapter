package com.huyun.sys.model.ex;

import java.io.Serializable;

/**
 *
 * 推送设置
 */

public class PushConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    private String key1;
    private String secret1;
    private String key2;
    private String secret2;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getSecret1() {
        return secret1;
    }

    public void setSecret1(String secret1) {
        this.secret1 = secret1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getSecret2() {
        return secret2;
    }

    public void setSecret2(String secret2) {
        this.secret2 = secret2;
    }

}
