package me.ilvc.yunso.novel.service;

import me.ilvc.yunso.base.service.IBaseService;
import me.ilvc.yunso.novel.model.NOpInfo;

import java.util.List;

/**
 * @Author: iLvc
 * @Date：Create in 22:07 2017/8/13
 * @Description:
 * @Modified By:
 */
public interface INOpInfoService extends IBaseService {

    List<NOpInfo> findAll();

}
