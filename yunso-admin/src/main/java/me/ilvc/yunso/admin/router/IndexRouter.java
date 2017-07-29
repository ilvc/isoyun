package me.ilvc.yunso.admin.router;

import me.ilvc.yunso.novel.model.NovelInfo;
import me.ilvc.yunso.novel.service.INovelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: iLvc
 * @Date：Create in 16:42 2017/7/23
 * @Description:
 * @Modified By:
 */
@Controller
@RequestMapping(value ="/")
public class IndexRouter {

    @Autowired
    private INovelInfoService novelInfoService;
    @RequestMapping(value = {"/",""},method = RequestMethod.GET)
    public ModelAndView yunsoIndex(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/novel/nindex");
        mav.addObject("novelInfo_all",(List<Object>)novelInfoService.findAll());
        return mav;
    }
}
