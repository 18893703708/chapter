package com.huyun.payment.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyun.payment.dao.PaymentMethodMapper;
import com.huyun.payment.model.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    PaymentMethodMapper paymentMethodMapper;
    @Override
    public List<PaymentMethod> selectAll() {
        return null;
    }

    @Override
    public PaymentMethod findByPrimaryKey(String id) {
        return paymentMethodMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    public int insert(PaymentMethod paymentMethod) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(PaymentMethod paymentMethod) {
        return paymentMethodMapper.updateByPrimaryKeySelective(paymentMethod);
    }

    @Override
    public int deleteByPrimaryKey(String[] id) {
        return 0;
    }

    @Override
    public PageInfo<PaymentMethod> selectByPage(Integer page, Integer pageSize, Map<String, Object> map) {
        PageHelper.startPage(page,pageSize);
        Condition condition = new Condition(PaymentMethod.class);
        if(map!=null){
            if(map.get("name")!=null &&map.get("name")!=""){
                condition.createCriteria().andCondition("name like '%"+map.get("name").toString()+"%'");
            }
        }
        List<PaymentMethod> list =  paymentMethodMapper.selectByExample(condition);
        return new PageInfo<>(list);
    }

    @Override
    public List<PaymentMethod> selectByT(PaymentMethod paymentMethod) {
        return null;
    }

    @Override
    public PaymentMethod findOne(PaymentMethod paymentMethod) {
        return null;
    }

    @Override
    public PaymentMethod findByPcode(String pcode) {
        return paymentMethodMapper.findByPcode(pcode);
    }
}
