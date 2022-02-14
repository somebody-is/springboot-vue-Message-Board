package com.lzf.greatme.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzf.greatme.entity.Message;
import com.lzf.greatme.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    ObjectMapper objectMapper=new ObjectMapper();

    Logger logger= LoggerFactory.getLogger(MessageController.class);

    @RequestMapping(value="/add",produces = {"application/json;charset=UTF-8"})
    @CrossOrigin
    public String addMessage(@RequestBody Message message) throws JsonProcessingException {
        Map<String,Object>result=new HashMap<>();
        result.put("result",messageService.addMessage(message));
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping(value="/querybykey",produces = {"application/json;charset=UTF-8"})
    @CrossOrigin
    public String queryByMessageKey(@RequestBody Map<String,String>request) throws JsonProcessingException {
        String messageKey=request.get("messageKey");
        Map<String,Object>result=new HashMap<>();
        logger.info(messageKey);
        List<Message> list=messageService.queryByMessageKey(messageKey);
        if(list!=null){
            result.put("result",1);
            result.put("messages",list);
        }else{
            result.put("result",0);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping(value="/queryallpublic",produces = {"application/json;charset=UTF-8"})
    @CrossOrigin
    public String queryAllPublic() throws JsonProcessingException {
        return objectMapper.writeValueAsString(messageService.queryAllPublic());
    }

//    @RequestMapping(value="/deletebyid",produces = {"application/json;charset=UTF-8"})
//    @CrossOrigin
//    public String deleteByID(@RequestBody ) throws JsonProcessingException {
//
//    }

    @RequestMapping(value="/getbyidandpsw",produces = {"application/json;charset=UTF-8"})
    @CrossOrigin
    public String getContentByIDAndPassword(@RequestBody Map<String,String>request) throws JsonProcessingException {
        Integer id=Integer.parseInt(request.get("id"));
        String password=request.get("password");
        Map<String,Object>result=new HashMap<>();
        if(password != null) {
            String content = messageService.getContentByIDAndPassword(id,password);
            if(content!=null){
                result.put("result",1);
                result.put("content",content);
            }else
                result.put("result",-1);
        }
        return objectMapper.writeValueAsString(result);
    }


}
