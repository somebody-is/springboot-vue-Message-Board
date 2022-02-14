package com.lzf.greatme.service;

import com.lzf.greatme.entity.Message;

import java.util.List;

public interface MessageService {

    public int addMessage(Message message);

    public List<Message> queryByMessageKey(String messageKey);

    public List<Message> queryAllPublic();

    public int deleteByID(Integer id);

    public int update(Message message);

    public String getContentByIDAndPassword(Integer id,String password);



}
