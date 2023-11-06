package me.hiyacate.passwdBox.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("me.hiyacate.passwdBox.mapper")
public class MybatisPlusConfig {
}