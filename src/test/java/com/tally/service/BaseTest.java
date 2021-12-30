package com.tally.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

/**
 * 单元测试基类
 * @author 131****2893
 * @date 2020/10/26 16:38
 */
@Slf4j
@ComponentScan("com.tally")
public class BaseTest {

    /**
     * 打印测试结果
     * @author 131****2893
     * @date 2020/10/26 16:38
     */
    protected void print(Object obj) {
        log.info("测试结果: {}", obj == null ? "无返回" : JSON.toJSONString(obj));
    }

}