package me.ilvc.yunso.admin.router.novel;

import me.ilvc.yunso.novel.service.INovelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: iLvc
 * @Date：Create in 15:56 2017/7/26
 * @Description:
 * @Modified By:
 */
@Controller
@RequestMapping("/novel")
public class NovelRouter {


    @Autowired
    private INovelInfoService novelInfoService;

    @RequestMapping("/read/{novelId}")
    public ModelAndView readNovel(@PathVariable("novelId") int novelId){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("foreground/novel/sidebar");
        mav.addObject("novel",novelInfoService.findNovelAndChapters(novelId));
        return mav;
    }
}
