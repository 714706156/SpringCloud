package com.seal.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.naming.Name;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yangkai
 * @Date: 2022/3/28 16:06
 */
@Service
public class PaymentService {
    //正常访问
    public String paymentInfo_OK(Integer id){
        return "线程池 "+Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t";
    }
    //模拟出错
    @HystrixCommand(fallbackMethod="paymentInfo_TIMEOUTHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TIMEOUT(Integer id){
        int timeNumber=3000;
        try{
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池 "+Thread.currentThread().getName()+" paymentInfo_TIMEOUT,id: "+id+"\t"+"耗时"+timeNumber+"秒钟";
    }

    public String paymentInfo_TIMEOUTHandler(Integer id){
        return "线程池 "+Thread.currentThread().getName()+" 8001系统繁忙或运行错误，请稍后再试,id: "+id+"\t"+"o(╥﹏╥)o";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        String serialNum= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号： "+serialNum;
    }
    public String paymentCircuitBreaker_Fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试，o(╥﹏╥)o";
    }
}
