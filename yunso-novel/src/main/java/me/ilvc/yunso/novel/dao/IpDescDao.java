package me.ilvc.yunso.novel.dao;

import me.ilvc.yunso.base.dao.BaseDao;
import me.ilvc.yunso.novel.model.IpDesc;
import org.springframework.stereotype.Repository;

@Repository
public interface IpDescDao  {
    int deleteByPrimaryKey(Integer ipId);

    int insert(IpDesc record);

    int insertSelective(IpDesc record);

    IpDesc selectByPrimaryKey(Integer ipId);

    int updateByPrimaryKeySelective(IpDesc record);

    int updateByPrimaryKey(IpDesc record);
}