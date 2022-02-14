package com.lzf.greatme;

import com.lzf.greatme.config.EmailConfig;
import com.lzf.greatme.utils.CommonsEmail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

//@EnableConfigurationProperties(EmailConfig.class)
@SpringBootTest
class GreatemeApplicationTests {

    @Autowired
    private  EmailConfig emailConfig;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    void contextLoads() throws Exception {
        System.out.println(emailConfig.getPort());
        new CommonsEmail().sendTextMail(emailConfig,"111","asfasf","1697712297@qq.com");
    }

}
