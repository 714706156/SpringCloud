package com.seal.mapper;

import com.seal.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: yangkai
 * @Date: 2022/3/22 16:19
 */
@Mapper
public interface PaymentMapper {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Integer id);
}
