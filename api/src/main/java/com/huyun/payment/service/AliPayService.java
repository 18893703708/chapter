package com.huyun.payment.service;

import com.huyun.payment.model.Product;

public interface AliPayService {
    /**
     * APP支付
     */
    String appPay(Product product);
}
