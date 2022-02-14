package com.lzf.greatme.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzf.greatme.entity.OrdinaryUser;
import com.lzf.greatme.entity.OrdinaryUserExample;
import com.lzf.greatme.mapper.OrdinaryUserMapper;
import com.lzf.greatme.service.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdinaryUserServiceImpl implements OrdinaryUserService {

    @Autowired
    private OrdinaryUserMapper userMapper;

    public int addUser(String email,String password){
        return userMapper.insertSelective(new OrdinaryUser(email,password));
    }

    public OrdinaryUser queryByUserNameAndPsw(String username,String password){
        OrdinaryUserExample example=new OrdinaryUserExample();
        OrdinaryUserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<OrdinaryUser>list= userMapper.selectByExample(example);
        if(list.size()!=0)
            return list.get(0);
        else
            return null;
    }

    public PageInfo<OrdinaryUser> queryAll(OrdinaryUser user){
        if(user!=null&&user.getPage()!=null)
            PageHelper.startPage(user.getPage(),user.getLimit());
        PageInfo<OrdinaryUser>pageInfo=new PageInfo(userMapper.queryAll(user));
        return pageInfo;
    }

    @Override
    public int queryUsername(String username) {
        OrdinaryUserExample example=new OrdinaryUserExample();
        OrdinaryUserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userMapper.selectByExample(example).size();
    }

    @Override
    public int queryEmail(String email) {
        OrdinaryUserExample example=new OrdinaryUserExample();
        OrdinaryUserExample.Criteria criteria=example.createCriteria();
        criteria.andEmailEqualTo(email);
        return userMapper.selectByExample(example).size();
    }

    @Override
    public OrdinaryUser queryByEmailAndPsw(String email, String password) {
        OrdinaryUserExample example=new OrdinaryUserExample();
        OrdinaryUserExample.Criteria criteria=example.createCriteria();
        criteria.andEmailEqualTo(email);
        criteria.andPasswordEqualTo(password);
        List<OrdinaryUser>list= userMapper.selectByExample(example);
        if(list.size()!=0)
            return list.get(0);
        else
            return null;
    }
}
