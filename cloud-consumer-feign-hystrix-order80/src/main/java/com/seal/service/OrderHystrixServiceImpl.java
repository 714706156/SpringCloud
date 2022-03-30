package com.seal.service;

import org.springframework.stereotype.Component;

/**
 * @Author: yangkai
 * @Date: 2022/3/29 10:43
 */
@Component
public class OrderHystrixServiceImpl implements OrderHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "OrderHystrixService-paymentInfo_OK--o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TIMEOUT(Integer id) {
        return "OrderHystrixService-paymentInfo_TIMEOUT--o(╥﹏╥)o";
    }
}
