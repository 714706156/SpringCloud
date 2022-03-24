package com.seal.service.impl;

import com.seal.mapper.PaymentMapper;
import com.seal.pojo.Payment;
import com.seal.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: yangkai
 * @Date: 2022/3/22 16:45
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    public int create(Payment payment){
        return paymentMapper.create(payment);
    }
    public Payment getPaymentById(@Param("id") Integer id){
        return paymentMapper.getPaymentById(id);
    }
}
