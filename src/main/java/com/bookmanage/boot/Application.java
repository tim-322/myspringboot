package com.bookmanage.boot;

import com.bookmanage.boot.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@EnableConfigurationProperties(ServiceConfig.class)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /*比配置文件等级更高的设定，就会覆盖配置文件的配置*/
        //让热部署失效
        // System.setProperty("spring.devtools.restart.enabled","false");
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        ServiceConfig serviceConfig = run.getBean(ServiceConfig.class);
        System.out.println(serviceConfig);
        System.out.println("master version3");
    }

}
