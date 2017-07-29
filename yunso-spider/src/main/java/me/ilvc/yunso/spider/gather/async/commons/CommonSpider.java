package me.ilvc.yunso.spider.gather.async.commons;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import me.ilvc.yunso.spider.gather.async.AsyncGather;
import me.ilvc.yunso.spider.gather.async.TaskManager;
import me.ilvc.yunso.spider.model.async.State;
import me.ilvc.yunso.spider.model.async.Task;
import me.ilvc.yunso.spider.model.common.SpiderInfo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.HttpHost;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.pipeline.ResultItemsCollectorPipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.PlainText;
import us.codecraft.webmagic.utils.UrlUtils;

import javax.management.JMException;
import java.io.File;
import java.io.IOException;
import java.net.BindException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * CommonSpider
 *
 * @author Gao Shen
 * @version 16/4/11
 */
public class CommonSpider extends AsyncGather {

    /**
     * 在原有的webmagic基础上添加了一些其他功能
     */
    private class MySpider extends Spider {
        private final SpiderInfo SPIDER_INFO;
        private Logger LOG = LogManager.getLogger(MySpider.class);

        MySpider(PageProcessor pageProcessor, SpiderInfo spiderInfo) {
            super(pageProcessor);
            this.SPIDER_INFO = spiderInfo;
        }

        @Override
        protected void onSuccess(Request request) {
            super.onSuccess(request);
            Task task = taskManager.getTaskById(this.getUUID());
            boolean reachMax = false, exceedRatio = false;
            if (
                    (
                            //已抓取数量大于最大抓取页数,退出
                            (reachMax = (SPIDER_INFO.getMaxPageGather() > 0 && task.getCount() >= SPIDER_INFO.getMaxPageGather()))
                                    ||
                                    //如果抓取页面超过最大抓取数量ratio倍的时候,仍未达到最大抓取数量,爬虫也退出
                                    (exceedRatio = (this.getPageCount() > SPIDER_INFO.getMaxPageGather() && SPIDER_INFO.getMaxPageGather() > 0))
                    )
                            && this.getStatus() == Status.Running) {
                LOG.info("爬虫ID{}已处理{}个页面,有效页面{}个,最大抓取页数{},reachMax={},exceedRatio={},退出.", this.getUUID(), this.getPageCount(), task.getCount(), SPIDER_INFO.getMaxPageGather(), reachMax, exceedRatio);
                task.setDescription("爬虫ID%s已处理%s个页面,有效页面%s个,达到最大抓取页数%s,reachMax=%s,exceedRatio=%s,退出.", this.getUUID(), this.getPageCount(), task.getCount(), SPIDER_INFO.getMaxPageGather(), reachMax, exceedRatio);
                this.stop();
            }
        }

        @Override
        protected void onError(Request request) {
            super.onError(request);
            Task task = taskManager.getTaskById(this.getUUID());
            task.setDescription("处理网页%s时发生错误,%s", request.getUrl(), request.getExtras());
        }

        @Override
        public void close() {
            super.close();
            Task task = taskManager.getTaskById(this.getUUID());
            if (task != null) {
                //清除抓取列表缓存
              //  commonWebpagePipeline.deleteUrls(task.getTaskId());
                taskManager.stopTask(task);
            }
        }

        SpiderInfo getSpiderInfo() {
            return SPIDER_INFO;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            MySpider mySpider = (MySpider) o;

            return new EqualsBuilder()
                    .append(this.getUUID(), mySpider.getUUID())
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(this.getUUID())
                    .toHashCode();
        }
    }

    private class MyPageProcessor implements PageProcessor {

        private Site site;
        private SpiderInfo info;
        private Task task;

        public MyPageProcessor(SpiderInfo info, Task task) {
            this.site = Site.me().setDomain(info.getDomain()).setTimeOut(info.getTimeout())
                    .setRetryTimes(info.getRetry()).setSleepTime(info.getSleep())
                    .setCharset(StringUtils.isBlank(info.getCharset()) ? null : info.getCharset())
                    .setUserAgent(info.getUserAgent());
            //设置抓取代理IP与接口
            if (StringUtils.isNotBlank(info.getProxyHost()) && info.getProxyPort() > 0) {
               // this.site.setHttpProxy(new HttpHost(info.getProxyHost(), info.getProxyPort()));
                //设置代理的认证
                if (StringUtils.isNotBlank(info.getProxyUsername()) && StringUtils.isNotBlank(info.getProxyPassword())) {
                 //   this.site.setUsernamePasswordCredentials(new UsernamePasswordCredentials(info.getProxyUsername(), info.getProxyPassword()));
                }
            }
            this.info = info;
            this.task = task;
        }

        @Override
        public void process(Page page) {
          //  spiderInfoPageConsumer.accept(page, info, task);
            if (!page.getResultItems().isSkip()) {//网页正常时再增加数量
                task.increaseCount();
            }
        }

        @Override
        public Site getSite() {
            return site;
        }
    }

}