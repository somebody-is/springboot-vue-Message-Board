package com.lzf.greatme.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "email", ignoreUnknownFields = false)
@PropertySource("classpath:config/email.properties")
@Data
@Component
public class EmailConfig {
    private String host;
    private int port;
    private String userName;
    private String pickName;
    private String password;
    private String charset;
}
