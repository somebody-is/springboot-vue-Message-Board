package com.lzf.greatme.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzf.greatme.entity.OrdinaryUser;
import com.lzf.greatme.mapper.OrdinaryUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrdinaryUserService {


    public int addUser(String email,String password);

    public OrdinaryUser queryByUserNameAndPsw(String username,String password);

    public PageInfo<OrdinaryUser> queryAll(OrdinaryUser user);

    public int queryUsername(String username);

    public int queryEmail(String email);

    public OrdinaryUser queryByEmailAndPsw(String email,String password);
}
