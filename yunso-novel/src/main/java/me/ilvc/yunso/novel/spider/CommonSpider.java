package me.ilvc.yunso.novel.spider;

import me.ilvc.yunso.novel.model.NOpInfo;
import me.ilvc.yunso.novel.pageprocessor.FQXSPageprocessor;
import me.ilvc.yunso.novel.pipeline.NovelChapterPipeline;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: iLvc
 * @Date：Create in 10:02 2017/8/14
 * @Description:
 * @Modified By:
 */
@Component
public class CommonSpider {

  static private final   Map<Integer,MySpider> spiderMap = new HashMap<>();

    @Autowired
    private NovelChapterPipeline novelChapterPipeline;

    public MySpider makeSpider(NOpInfo info){
        MySpider spider = (MySpider) new MySpider(new FQXSPageprocessor(info),info);
        spider.addUrl(info.getStartUrl());
        if ("novelinfo".equals(info.getType())){
            spider.thread(2);
        }else if ("first".equals(info.getState())){
         spider.thread(50);
        }else{
            spider.thread(5);
        }
        spider.addPipeline(novelChapterPipeline);
        spiderMap.put(info.getId(),spider);
        return spider;
    }

    public void start(NOpInfo info){
        MySpider spider =spiderMap.get(info.getId());
        spider.start();
        info.setStatus(1);
    }

    public void start(MySpider spider,NOpInfo info){
        spider.start();
        info.setStatus(1);
    }

    public void stop(NOpInfo info){
        MySpider spider =spiderMap.get(info.getId());
        spider.stop();
        info.setStatus(2);
    }



    private class MySpider extends Spider{

         private  NOpInfo info;

        public MySpider(PageProcessor pageProcessor, NOpInfo info) {
            super(pageProcessor);
            this.info = info;
        }

        public MySpider(PageProcessor pageProcessor) {
            super(pageProcessor);
        }

        @Override
        protected void onError(Request request) {
            super.onError(request);
        }

        @Override
        protected void onSuccess(Request request) {
            super.onSuccess(request);
           // info.setNcount(info.getNcount()+1);
        }


    }
}
