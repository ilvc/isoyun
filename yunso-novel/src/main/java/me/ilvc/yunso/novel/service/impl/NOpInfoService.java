package me.ilvc.yunso.novel.service.impl;

import me.ilvc.yunso.base.service.impl.BaseService;
import me.ilvc.yunso.novel.dao.NOpInfoDao;
import me.ilvc.yunso.novel.model.NOpInfo;
import me.ilvc.yunso.novel.service.INOpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: iLvc
 * @Date：Create in 22:07 2017/8/13
 * @Description:
 * @Modified By:
 */
@Service
public class NOpInfoService extends BaseService implements INOpInfoService {

    @Autowired
    private NOpInfoDao nOpInfoDao;

    public <T> T findById(Integer id) {
        return null;
    }

    public <T> int insert(T t) {

        return nOpInfoDao.insert(t);
    }

    public <T> int update(T t) {
        return 0;
    }

    public <T> int delete(T t) {
        return 0;
    }

    public <T> T select(T t) {
        return null;
    }

    public  List<NOpInfo> findAll() {
        return nOpInfoDao.findAll();
    }

    public int size() {
        return 0;
    }

    public <T> int sizeByType(T t) {
        return 0;
    }
}
