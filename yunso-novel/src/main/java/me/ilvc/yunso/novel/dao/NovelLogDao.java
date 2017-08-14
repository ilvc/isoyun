package me.ilvc.yunso.novel.dao;

import me.ilvc.yunso.novel.model.NovelLog;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelLogDao  {
    int deleteByPrimaryKey(Integer logId);

    int insert(NovelLog record);

    int insertSelective(NovelLog record);

    NovelLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(NovelLog record);

    int updateByPrimaryKey(NovelLog record);
}