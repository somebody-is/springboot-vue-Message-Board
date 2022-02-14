package com.lzf.greatme.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzf.greatme.config.EmailConfig;
import com.lzf.greatme.service.OrdinaryUserService;
import com.lzf.greatme.utils.CommonsEmail;
import com.lzf.greatme.utils.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private OrdinaryUserService userService;

    @Autowired
    private EmailConfig emailConfig;

    ObjectMapper objectMapper=new ObjectMapper();

    @RequestMapping(value="/verify",produces = {"application/json;charset=UTF-8"})
    @CrossOrigin
    public String getCode(@RequestBody Map<String,String>request) throws JsonProcessingException {
        String email=request.get("email");
        Map<String,String>map=new HashMap<>();
        if(email==null){
            map.put("result","0");
        }else {
            if(userService.queryEmail(email)!=0){
                map.put("result","-1");
            }else {
                BASE64Encoder base64Encoder = new BASE64Encoder();
                String code = VerifyCodeUtil.generateVerifyCode(4);
                try {
                    new CommonsEmail().sendTextMail(emailConfig,"GREATME验证码", "【GREATME】验证码：" + code + " 此验证码用于注册，10分钟内有效", email);
                    map.put("result", "1");
                    map.put("code", base64Encoder.encode(code.getBytes(StandardCharsets.UTF_8)));
                    return objectMapper.writeValueAsString(map);
                } catch (Exception e) {
                    e.printStackTrace();
                    map.put("result", "0");
                }
            }
        }
        return objectMapper.writeValueAsString(map);
    }


    @RequestMapping("/register")
    @CrossOrigin
    public String register(@RequestBody Map<String,String> request) throws Exception {
        Map<String,Object>result=new HashMap<>();
        String email=request.get("email");
        String password=request.get("password");
        result.put("result",userService.addUser(email,password));
        return objectMapper.writeValueAsString(result);
    }


}
