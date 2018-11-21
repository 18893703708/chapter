package com.huyun.payment.dao;

import com.huyun.BaseMapper;
import com.huyun.payment.model.PaymentMethod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaymentMethodMapper extends BaseMapper<PaymentMethod> {


    //根据支付编码查询
    @Select("select * from tb_payment_method where pcode=#{pcode}")
    PaymentMethod findByPcode(@Param("pcode") String pcode);
}


