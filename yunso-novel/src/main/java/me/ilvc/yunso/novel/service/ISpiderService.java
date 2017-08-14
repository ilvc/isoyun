package me.ilvc.yunso.novel.service;

/**
 * @Author: iLvc
 * @Date：Create in 09:52 2017/8/14
 * @Description:
 * @Modified By:
 */
public interface ISpiderService  {

    String startSpider(Integer id);
    String stopSpider(Integer id);
    String deleteSpider(Integer id);


}
