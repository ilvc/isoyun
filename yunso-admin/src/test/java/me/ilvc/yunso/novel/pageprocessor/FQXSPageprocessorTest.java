package me.ilvc.yunso.novel.pageprocessor;

import me.ilvc.yunso.novel.model.NOpInfo;
import me.ilvc.yunso.novel.pipeline.NovelChapterPipeline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 * @Author: iLvc
 * @Date：Create in 02:08 2017/7/24
 * @Description:
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        {"classpath:spring-context.xml",
                "classpath:spring-mvc.xml"})
public class FQXSPageprocessorTest {

    @Autowired
    private NovelChapterPipeline novelChapterPipeline;

    @Test
    public void test(){
        NOpInfo info = new NOpInfo("11778262","http://www.xfqxsw.com/html/64181/11778262.html","first","novelChapter");
       // Spider.create(new FQXSPageprocessor("69999",null,"first","novelChapter")).addUrl("http://www.xfqxsw.com/html/69999/16998140.html").addPipeline(novelChapterPipeline).thread(20).run();
        Spider.create(new FQXSPageprocessor(info)).addUrl(info.getStartUrl()).addPipeline(new ConsolePipeline()).thread(5).run();
    }

}
