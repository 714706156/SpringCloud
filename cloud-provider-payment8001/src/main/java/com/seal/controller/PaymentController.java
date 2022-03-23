package com.seal.controller;

import com.seal.pojo.CommonResult;
import com.seal.pojo.Payment;
import com.seal.service.PaymentService;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: yangkai
 * @Date: 2022/3/22 16:49
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result= paymentService.create(payment);
        log.info("结果为： "+result);
        if(result>0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment payment= paymentService.getPaymentById(id);
        log.info("结果为： "+payment);
        if(payment !=null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }

}
