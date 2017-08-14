package me.ilvc.yunso.novel.dao;

import me.ilvc.yunso.base.dao.BaseDao;
import me.ilvc.yunso.novel.model.NovelChapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelChapterDao extends BaseDao{
    int deleteByPrimaryKey(Integer chapterId);

    int insertSelective(NovelChapter record);

    NovelChapter selectById(@Param("chapterId") Integer chapterId);

    int updateByPrimaryKeySelective(NovelChapter record);

    int updateByPrimaryKey(NovelChapter record);





}