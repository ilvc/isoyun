package me.ilvc.yunso.novel.dao;

import me.ilvc.yunso.base.dao.BaseDao;
import me.ilvc.yunso.novel.model.NovelChapter;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelChapterDao {
    int deleteByPrimaryKey(Integer chapterId);

    int insert(NovelChapter record);

    int insertSelective(NovelChapter record);

    NovelChapter selectByPrimaryKey(Integer chapterId);

    int updateByPrimaryKeySelective(NovelChapter record);

    int updateByPrimaryKey(NovelChapter record);
}