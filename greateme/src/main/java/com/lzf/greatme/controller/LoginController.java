package com.lzf.greatme.controller;

import com.google.gson.Gson;
import com.lzf.greatme.utils.VerifyCodeUtil;
import sun.misc.BASE64Encoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzf.greatme.entity.OrdinaryUser;
import com.lzf.greatme.service.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private OrdinaryUserService userService;



    ObjectMapper objectMapper=new ObjectMapper();
    Gson gson=new Gson();


    @RequestMapping(value="/login",produces = {"application/json;charset=UTF-8"})
    @CrossOrigin
    public String login(@RequestBody Map<String,String>request){
        Map<String,Object>result=new HashMap<>();
        String username=request.get("username");
        String passowrd=request.get("password");

        if(username==null||passowrd==null) {
            result.put("result","-1");
            return gson.toJson(result);
        }
        OrdinaryUser user=userService.queryByUserNameAndPsw(username,passowrd);
        OrdinaryUser user2=userService.queryByEmailAndPsw(username,passowrd);
        if(user!=null||user2!=null){
            result.put("result","1");
            result.put("user",user==null?user2:user);
        }else{
            result.put("result","0");
        }
        return gson.toJson(result);
    }


    @RequestMapping(value = "/codeimage")
    @CrossOrigin
    public String getImage() throws IOException {
        BASE64Encoder base64Encoder=new BASE64Encoder();
        String verifyCode=VerifyCodeUtil.generateVerifyCode(4);
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        VerifyCodeUtil.outputImage(200,80,data,verifyCode);
        String base64=base64Encoder.encode(data.toByteArray());
        String src="data:image/jpg;base64," + base64;
        String code=base64Encoder.encode(verifyCode.getBytes(StandardCharsets.UTF_8));
        Map<String,String>result=new HashMap<>();
        src=src.replaceAll("\\r\\n","");
        result.put("src",src);
        result.put("code",code);
        return objectMapper.writeValueAsString(result);
    }
}
