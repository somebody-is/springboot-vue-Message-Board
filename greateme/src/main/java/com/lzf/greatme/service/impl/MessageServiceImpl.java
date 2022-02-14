package com.lzf.greatme.service.impl;

import com.lzf.greatme.entity.Message;
import com.lzf.greatme.entity.MessageExample;
import com.lzf.greatme.mapper.MessageMapper;
import com.lzf.greatme.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageMapper messageMapper;

    private List<Message> setContentNull(List<Message>list){
        for(Message message:list){
            if(message.getIsLocked()==1) {
                message.setMessageContent("");
                message.setMessagePassword("");
            }
        }
        return list;
    }

    @Override
    public int addMessage(Message message) {
        return messageMapper.insertSelective(message);
    }

    @Override
    public List<Message> queryByMessageKey(String messageKey) {
        if(messageKey==null)
            return null;
        MessageExample example=new MessageExample();
        MessageExample.Criteria criteria=example.createCriteria();
        criteria.andMessageKeyEqualTo(messageKey);
        return setContentNull(messageMapper.selectByExampleWithBLOBs(example));
    }

    @Override
    public List<Message> queryAllPublic() {
        MessageExample example=new MessageExample();
        MessageExample.Criteria criteria=example.createCriteria();
        criteria.andIsPublicEqualTo(1);
        example.setOrderByClause("message_date DESC");
        return setContentNull(messageMapper.selectByExampleWithBLOBs(example));
    }

    @Override
    public int deleteByID(Integer id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Message message) {
        return messageMapper.updateByPrimaryKeySelective(message);
    }

    @Override
    public String getContentByIDAndPassword(Integer id, String password) {
        MessageExample example=new MessageExample();
        MessageExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andMessagePasswordEqualTo(password);
        List<Message>list=messageMapper.selectByExampleWithBLOBs(example);
        if(list.size()==0)
            return null;
        else
            return list.get(0).getMessageContent();
    }
}
