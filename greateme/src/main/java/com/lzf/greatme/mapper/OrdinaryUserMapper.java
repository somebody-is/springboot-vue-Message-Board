package com.lzf.greatme.mapper;

import com.lzf.greatme.entity.OrdinaryUser;
import com.lzf.greatme.entity.OrdinaryUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrdinaryUserMapper{
    public int addUser(OrdinaryUser user);

    public OrdinaryUser queryByUserNameAndPsw(String username,String password);

    public List<OrdinaryUser> queryAll(OrdinaryUser user);

    int countByExample(OrdinaryUserExample example);

    int deleteByExample(OrdinaryUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrdinaryUser record);

    int insertSelective(OrdinaryUser record);

    List<OrdinaryUser> selectByExample(OrdinaryUserExample example);

    OrdinaryUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrdinaryUser record, @Param("example") OrdinaryUserExample example);

    int updateByExample(@Param("record") OrdinaryUser record, @Param("example") OrdinaryUserExample example);

    int updateByPrimaryKeySelective(OrdinaryUser record);

    int updateByPrimaryKey(OrdinaryUser record);

}
