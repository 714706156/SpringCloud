package com.seal.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.seal.pojo.CommonResult;
import com.seal.pojo.Payment;

/**
 * @Author: yangkai
 * @Date: 2022/4/7 16:28
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException e){
        return new CommonResult(444,"按客户自定义,global----1");
    }

    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(444,"按客户自定义,global----2");
    }
}
