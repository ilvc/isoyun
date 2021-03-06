package me.ilvc.yunso.novel.service;

import me.ilvc.yunso.base.service.IBaseService;
import me.ilvc.yunso.novel.model.NovelChapter;

/**
 * @Author: iLvc
 * @Date：Create in 16:19 2017/7/23
 * @Description:
 * @Modified By:
 */
public interface INovelChapterService extends IBaseService {
    NovelChapter selectById(Integer chapterId);
}
