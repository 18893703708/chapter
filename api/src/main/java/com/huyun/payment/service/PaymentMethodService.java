package com.huyun.payment.service;


import com.huyun.base.service.BaseServer;
import com.huyun.payment.model.PaymentMethod;

public interface PaymentMethodService extends BaseServer<PaymentMethod> {
    //根据支付编码查询
    PaymentMethod findByPcode(String pcode);
}
