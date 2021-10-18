package com.example.shop_buyer_web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author tai
 * @date: 2021-09-12 23:12
 * @description: 配置类，需要扫描MyBatis的Mapper接口所在的包
 */
@Configuration
@MapperScan("com.example.shop_dao.dao")
public class MybatisConfig {

    /**
     * 读取文件application.yml中前缀为spring.datasource的属性的值,并注入到数据源的属性
     * */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

}