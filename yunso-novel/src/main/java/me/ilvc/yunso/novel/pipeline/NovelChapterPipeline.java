package me.ilvc.yunso.novel.pipeline;

import me.ilvc.yunso.novel.dao.NovelChapterDao;
import me.ilvc.yunso.novel.dao.NovelInfoDao;
import me.ilvc.yunso.novel.model.NovelChapter;
import me.ilvc.yunso.novel.model.NovelInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Service
public class NovelChapterPipeline implements Pipeline {

	@Autowired
	private NovelChapterDao novelChapterDao;

	@Autowired
	private NovelInfoDao novelInfoDao;

	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub

		System.out.println("Hell world!");
		if ("novelInfo".equals(resultItems.get("type"))){
			NovelInfo  novelInfo = resultItems.get("novelInfo");
			novelInfoDao.insert(novelInfo);
			if (novelInfoDao==null){
				System.out.println("novelInfoDao==null");
			}else{
				System.out.println("novelInfoDao!=null");

			}

		}else if("novelChapter".equals(resultItems.get("type"))){

			NovelChapter chapter = resultItems.get("chapter");
			System.out.println(chapter);
			System.out.println(novelChapterDao);
			novelChapterDao.insert(chapter);
			if (novelChapterDao==null){
				System.out.println("novelChapterDao==null");
			}else{
				System.out.println("novelChapterDao!=null");

			}
		}
	}



}
