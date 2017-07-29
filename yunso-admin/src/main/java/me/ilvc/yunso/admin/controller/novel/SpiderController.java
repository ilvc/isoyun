package me.ilvc.yunso.admin.controller.novel;

import me.ilvc.yunso.novel.model.NOpInfo;
import me.ilvc.yunso.novel.pageprocessor.FQXSPageprocessor;
import me.ilvc.yunso.novel.pipeline.NovelChapterPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import us.codecraft.webmagic.Spider;

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

    @RequestMapping(value = "/start",method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String start(@RequestBody NOpInfo nOpInfo){
        NOpInfo info= null;
        System.out.println(nOpInfo);
        if (nOpInfo != null) {
            info = nOpInfo;
            if ("novelInfo".equals(info.getType())){
                Spider.create(new FQXSPageprocessor(info)).addUrl(info.getStartUrl()).addPipeline(novelChapterPipeline).thread(1).run();
            }else {
                Spider.create(new FQXSPageprocessor(info)).addUrl(info.getStartUrl()).addPipeline(novelChapterPipeline).thread(20).run();
            }
        }

        return "任务已经提交并开始执行！";
    }
}
