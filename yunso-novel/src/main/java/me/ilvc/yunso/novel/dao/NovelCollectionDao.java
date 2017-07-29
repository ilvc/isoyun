package me.ilvc.yunso.novel.dao;

import me.ilvc.yunso.novel.model.NovelCollection;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelCollectionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(NovelCollection record);

    int insertSelective(NovelCollection record);

    NovelCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NovelCollection record);

    int updateByPrimaryKey(NovelCollection record);
}