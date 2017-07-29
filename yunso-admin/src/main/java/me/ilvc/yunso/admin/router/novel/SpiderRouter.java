package me.ilvc.yunso.admin.router.novel;

import me.ilvc.yunso.base.router.BaseRouter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
