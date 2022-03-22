package com.seal.service;

import com.seal.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: yangkai
 * @Date: 2022/3/22 16:42
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Integer id);
}
