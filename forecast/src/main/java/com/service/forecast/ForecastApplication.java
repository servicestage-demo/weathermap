package com.service.forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author someguy
 * @version [版本号, 2017年1月3日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@SpringBootApplication
@PropertySource("classpath:config/httpproxy.properties")
public class ForecastApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ForecastApplication.class);
    }
}
