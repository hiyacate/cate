package me.hiyacate.passwdBox;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class PwdBoxApplication {
    public static void main(String[] args) {
        SpringApplication.run(PwdBoxApplication.class, args);
        log.info("密码管理箱服务启动完成");
    }
}
