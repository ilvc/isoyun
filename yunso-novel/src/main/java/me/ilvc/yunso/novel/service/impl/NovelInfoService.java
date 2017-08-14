package me.ilvc.yunso.novel.service.impl;

import me.ilvc.yunso.base.service.impl.BaseService;
import me.ilvc.yunso.novel.dao.NovelInfoDao;
import me.ilvc.yunso.novel.model.NovelInfo;
import me.ilvc.yunso.novel.service.INovelInfoService;
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
public class NovelInfoService extends BaseService implements INovelInfoService{

    @Autowired
    private NovelInfoDao novelInfoDao;

    public <T> T findById(Integer id) {
        return this.novelInfoDao.findById(id);
    }

    public <T> int insert(T t) {
        return this.novelInfoDao.insert(t);
    }

    public <T> int update(T t) {
        return this.novelInfoDao.update(t);
    }

    public <T> int delete(T t) {
        return this.novelInfoDao.delete(t);
    }

    public <T> T select(T t) {
        return this.novelInfoDao.select(t);
    }

    public <T> List<T> findAll() {
        return novelInfoDao.findAll();
    }

    public int size() {
        return this.novelInfoDao.size();
    }

    public <T> int sizeByType(T t) {
        return this.novelInfoDao.sizeByType(t);
    }

    public NovelInfo findNovelAndChapters(int novelId) {
        return this.novelInfoDao.findNovelAndChapters(novelId);
    }
}
