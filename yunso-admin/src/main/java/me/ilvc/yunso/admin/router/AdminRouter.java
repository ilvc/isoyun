package me.ilvc.yunso.admin.router;

import me.ilvc.yunso.novel.service.INovelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: iLvc
 * @Date：Create in 10:01 2017/7/30
 * @Description: 后台管理首页
 * @Modified By:
 */
@Controller
@RequestMapping("/admin/admin")
public class AdminRouter {

    @Autowired
    private INovelInfoService novelInfoService;

    @RequestMapping("/index")
    public ModelAndView admin(){

        return  new ModelAndView("admin/novel/index");
    }

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/novel/nindex");
        mav.addObject("novelInfo_all",novelInfoService.findAll());
        return mav;
    }
}
