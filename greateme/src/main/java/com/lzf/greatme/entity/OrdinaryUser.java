package com.lzf.greatme.entity;

import com.lzf.greatme.utils.Entity;
import lombok.Data;

@Data
public class OrdinaryUser extends Entity {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer sex;
    private String birthday;
    private Integer age;

    public OrdinaryUser(){}

    public OrdinaryUser( String email,String password) {
        this.email = email;
        this.password = password;

    }


}
