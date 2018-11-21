package com.huyun.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@SuppressWarnings("serial")  // 实现序列化后不想加序列化字段， 又不想看见黄色警告
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModel implements Serializable {

}
