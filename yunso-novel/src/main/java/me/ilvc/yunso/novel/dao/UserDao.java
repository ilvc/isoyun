package me.ilvc.yunso.novel.dao;

import me.ilvc.yunso.base.dao.BaseDao;
import me.ilvc.yunso.novel.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}