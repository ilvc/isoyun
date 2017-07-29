package me.ilvc.yunso.novel.utils;


import me.ilvc.yunso.novel.model.NovelChapter;
import me.ilvc.yunso.novel.model.RNovelChapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: iLvc
 * @Date：Create in 00:02 2017/7/24
 * @Description: mode 转换 ，由于编码问题 ，只能采取存UNicode 的形式，在转码
 * @Modified By:
 */
public class ModeConvertUtil {

    public static List<RNovelChapter> novelChapterConvert(List<NovelChapter> chapters) {
        List<RNovelChapter> realList = new ArrayList<RNovelChapter>();
        for (NovelChapter novelChapter : chapters) {
            realList.add(new RNovelChapter(novelChapter));
        }
        return realList;
    }

    public static RNovelChapter novelChapterConvert(NovelChapter chapters) {
        return new RNovelChapter(chapters);
    }


}
