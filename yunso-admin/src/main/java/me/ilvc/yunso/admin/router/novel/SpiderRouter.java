package me.ilvc.yunso.admin.router.novel;

import me.ilvc.yunso.base.router.BaseRouter;
import me.ilvc.yunso.novel.dao.NovelInfoDao;
import me.ilvc.yunso.novel.service.INOpInfoService;
import me.ilvc.yunso.novel.service.INovelInfoService;
import me.ilvc.yunso.novel.service.impl.NovelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: iLvc
 * @Date：Create in 11:29 2017/7/24
 * @Description:
 * @Modified By:
 */
@Controller
@RequestMapping("/admin/r/novel/spider")
public class SpiderRouter extends BaseRouter {

    @Autowired
    private INOpInfoService nOpInfoService;
    @Autowired
    private INovelInfoService novelInfoService;

    @Override
    protected String getPrefix() {
        return "admin/novel/spider";
    }

    @RequestMapping(value = "/editFull",method = RequestMethod.GET)
    public ModelAndView editFull(){
        return new ModelAndView("admin/novel/spider/editSpiderInfo");
    }


    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public ModelAndView edit(){
        return new ModelAndView("admin/novel/spider/edit");
    }


    @RequestMapping(value = "/task",method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public ModelAndView task(){
        ModelAndView mad = new ModelAndView();
        mad.setViewName("admin/novel/spider/task");
        mad.addObject("nOPInfo_list",nOpInfoService.findAll());
        return  mad;
    }


    @RequestMapping(value = "/manager",method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public ModelAndView manager(){
        ModelAndView mad = new ModelAndView();
        mad.setViewName("admin/novel/novelManager");
        mad.addObject("novelInfo_list",novelInfoService.findAll());
        return  mad;
    }
}
