package com.huyun.sys.model.ex;

import java.io.Serializable;

/**
 * 上传扩展类
 */
public class QiniuConfig implements Serializable{
    private static final long serialVersionUID = 1L;
    private String accesskey;//七牛云上传的app key
    private String secretkey;//七牛云上传secretkey
    private String domain;//七牛云的外链默认域名
    private String bucketname;//七牛云要上传的空间

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getAccesskey() {
        return accesskey;
    }

    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey;
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getBucketname() {
        return bucketname;
    }

    public void setBucketname(String bucketname) {
        this.bucketname = bucketname;
    }
}
