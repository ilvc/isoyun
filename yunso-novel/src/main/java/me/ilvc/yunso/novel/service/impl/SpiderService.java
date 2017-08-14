package me.ilvc.yunso.novel.service.impl;

import me.ilvc.yunso.novel.dao.NOpInfoDao;
import me.ilvc.yunso.novel.model.NOpInfo;
import me.ilvc.yunso.novel.service.ISpiderService;
import me.ilvc.yunso.novel.spider.CommonSpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: iLvc
 * @Date：Create in 09:52 2017/8/14
 * @Description:
 * @Modified By:
 */
@Service
public class SpiderService implements ISpiderService {

    @Autowired
    private NOpInfoDao nOpInfoDao;
    @Autowired
    private CommonSpider commonSpider;

    @Override
    public String startSpider(Integer id) {
        NOpInfo nOpInfo = nOpInfoDao.findById(id);


            //commonSpider.makeSpider(nOpInfo);
           // commonSpider.start(nOpInfo);
            commonSpider.start(commonSpider.makeSpider(nOpInfo),nOpInfo);


        return "任务已经开始执行";
    }

    @Override
    public String stopSpider(Integer id) {
        NOpInfo nOpInfo = nOpInfoDao.findById(id);

        commonSpider.stop(nOpInfo);
        return "任务已停止";
    }

    @Override
    public String deleteSpider(Integer id) {
        NOpInfo nOpInfo = nOpInfoDao.findById(id);

        return "任务已删除";
    }
}
