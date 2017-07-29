package me.ilvc.yunso.novel.dao;

import me.ilvc.yunso.base.dao.BaseDao;
import me.ilvc.yunso.novel.model.NovelInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelInfoDao extends BaseDao{
    int deleteByPrimaryKey(Integer novelId);

    int insertSelective(NovelInfo record);

    NovelInfo selectByPrimaryKey(Integer novelId);

    int updateByPrimaryKeySelective(NovelInfo record);

    int updateByPrimaryKey(NovelInfo record);
    NovelInfo findNovelAndChapters(@Param("novelId") int novelId);
}