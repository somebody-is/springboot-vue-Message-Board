package com.lzf.greatme.entity;

import lombok.Data;

@Data
public class Message {
    private Integer id;
    private String messageKey;
    private String messageContent;
    private String messageDate;
    private Integer messageMaster;
    private String masterName;
    private Integer isLocked;
    private String messagePassword;
    private Integer isPublic;

    public Message(String messageKey, String messageContent, Integer messageMaster,String masterName, Integer isLocked, String messagePassword,Integer isPublic) {
        this.messageKey = messageKey;
        this.messageContent = messageContent;
        this.masterName=masterName;
        this.messageMaster = messageMaster;
        this.isLocked = isLocked;
        this.messagePassword = messagePassword;
        this.isPublic=isPublic;
    }

    public Message() {
    }
}
