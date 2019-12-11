package com.dfbz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/11 13:54
 */
@Configuration
@ComponentScan("com.dfbz")
@PropertySource("classpath:db.properties")
public class ConfigBean {


}
