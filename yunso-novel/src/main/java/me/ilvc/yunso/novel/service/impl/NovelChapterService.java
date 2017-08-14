package me.ilvc.yunso.novel.service.impl;

import me.ilvc.yunso.base.service.impl.BaseService;
import me.ilvc.yunso.novel.dao.NovelChapterDao;
import me.ilvc.yunso.novel.model.NovelChapter;
import me.ilvc.yunso.novel.service.INovelChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: iLvc
 * @Date：Create in 16:27 2017/7/23
 * @Description:
 * @Modified By:
 */
@Service
public class NovelChapterService extends BaseService implements INovelChapterService{

    @Autowired
    private NovelChapterDao novelChapterDao;

    public <T> T findById(Integer id) {
        return this.novelChapterDao.findById(id);
    }

    public <T> int insert(T t) {
        return this.novelChapterDao.insert(t);
    }

    public <T> int update(T t) {
        return this.novelChapterDao.update(t);
    }

    public <T> int delete(T t) {
        return this.novelChapterDao.delete(t);
    }

    public <T> T select(T t) {
        return this.novelChapterDao.select(t);
    }

    public <T> List<T> findAll() {
        return this.findAll();
    }

    public int size() {
        return this.novelChapterDao.size();
    }

    public <T> int sizeByType(T t) {
        return this.novelChapterDao.sizeByType(t);
    }


    public NovelChapter selectById(Integer chapterId) {
        return this.novelChapterDao.selectById(chapterId);
    }
}
