package me.ilvc.yunso.spider.gather.async.commons;

import me.ilvc.yunso.spider.model.async.Task;
import me.ilvc.yunso.spider.model.common.SpiderInfo;
import us.codecraft.webmagic.Page;

/**
 * PageConsumer
 *
 * @author Gao Shen
 * @version 16/7/8
 */
@FunctionalInterface
public interface PageConsumer {
    void accept(Page page, SpiderInfo info, Task task);
}
