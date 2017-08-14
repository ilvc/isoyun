package me.ilvc.yunso.admin.controller.novel;

import me.ilvc.yunso.novel.model.NOpInfo;
import me.ilvc.yunso.novel.pipeline.NovelChapterPipeline;
import me.ilvc.yunso.novel.service.INOpInfoService;
import me.ilvc.yunso.novel.service.ISpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: iLvc
 * @Date：Create in 15:31 2017/7/24
 * @Description:
 * @Modified By:
 */
@Controller
@RequestMapping("/admin/c/novel/spider")
public class SpiderController {

    @Autowired
    NovelChapterPipeline novelChapterPipeline;

    @Autowired
    private INOpInfoService nOpInfoService;

    @Autowired
    private ISpiderService spiderService;


    @RequestMapping(value = "/start",method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String initTask(@RequestBody NOpInfo nOpInfo){
        nOpInfoService.insert(nOpInfo);
        return "任务已经提交！请到任务管理中进行下一步操作";
    }

    @RequestMapping(value = "/start/{id}",method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String start(@PathVariable("id") Integer id){
        NOpInfo nOpInfo = nOpInfoService.findById(id);
        spiderService.startSpider(id);
        return "任务已执行！";
    }

    @RequestMapping(value = "/stop/{id}",method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String stop(@PathVariable("id") Integer id){
        NOpInfo nOpInfo = nOpInfoService.findById(id);
        spiderService.stopSpider(id);
        return "任务已停止！";
    }

    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String delete(@PathVariable("id") Integer id){
        NOpInfo nOpInfo = nOpInfoService.findById(id);

        return "任务已删除！";
    }

}
