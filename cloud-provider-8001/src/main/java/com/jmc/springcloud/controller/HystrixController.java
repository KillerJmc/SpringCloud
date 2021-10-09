package com.jmc.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Jmc
 */
@RestController
@RequestMapping("/hystrix")
@DefaultProperties(defaultFallback = "hystrixFallback")
public class HystrixController {
    /**
     * 服务降级
     */
    @GetMapping("/timeout")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "3000")
    })
    public String hystrixTimeout() throws InterruptedException {
        int delaySecs = 5;
        TimeUnit.SECONDS.sleep(delaySecs);
        return "线程名称: " + Thread.currentThread().getName()
                + ", 耗时" + delaySecs + "秒!";
    }

    /**
     * 服务熔断
     */
    @GetMapping("/breaker/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED, value = "true"),
            // 请求次数
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"),
            // 请求失败的比例
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "60"),
            // 窗口期
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "10000")
    })
    public String hystrixCircuitBreaker(@PathVariable Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        return "线程名称: " + Thread.currentThread().getName() + ", 调用成功";
    }

    /**
     * 降级方法
     */
    @SuppressWarnings("unused")
    public String hystrixFallback() {
        return "线程名称: " + Thread.currentThread().getName()
                + ", 系统繁忙或者运行报错，请稍后再试QAQ";
    }
}
