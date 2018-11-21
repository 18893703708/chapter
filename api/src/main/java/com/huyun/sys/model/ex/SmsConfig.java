package com.huyun.sys.model.ex;

import java.io.Serializable;

/**
 *
 * 短信扩展
 */
public class SmsConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    private String key;//应用的app key
    private String secret;//应用的app secret
    private String signName;//应用签名

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }
}
