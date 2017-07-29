package me.ilvc.yunso.novel.pageprocessor;

import me.ilvc.yunso.novel.model.NOpInfo;
import me.ilvc.yunso.novel.model.NovelChapter;
import me.ilvc.yunso.novel.model.NovelInfo;
import me.ilvc.yunso.novel.pipeline.NovelChapterPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;


public class BXPageprocessor implements PageProcessor{

	@Autowired
	private NovelChapterPipeline novelChapterPipeline;

	private Site site = Site.me().setRetrySleepTime(5).setSleepTime(300).setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.109 Safari/537.36");

	private NOpInfo nOpInfo;

	public NOpInfo getnOpInfo() {
		return nOpInfo;
	}

	public BXPageprocessor(NOpInfo nOpInfo) {
		this.nOpInfo = nOpInfo;
	}

	public void setnOpInfo(NOpInfo nOpInfo) {
		this.nOpInfo = nOpInfo;
	}

	public void process(Page page) {
		if ("novelInfo".equals(nOpInfo.getType())){
			NovelInfo novelInfo = new NovelInfo();
			novelInfo.setNovelName(page.getHtml().xpath("//*[@id=\"info\"]/h1/text()").toString());
			novelInfo.setAuthor(page.getHtml().xpath("//*[@id=\"info\"]/p[1]/text()").toString().replace("作  者：",""));
			// //*[@id="info"]/p[1]
			novelInfo.setState(page.getHtml().css("#info > p:nth-child(3)","text").toString().replaceAll(",","").replaceAll("状  态：","").replaceAll("中   ",""));

			novelInfo.setNewchapter(page.getHtml().xpath("//*[@id=\"info\"]/p[4]/a/text()").toString());
			// //*[@id="info"]/p[4]/a
			novelInfo.setNewupdate(page.getHtml().xpath("//*[@id=\"info\"]/p[3]/text()").toString().replace("最后更新：",""));
            // //*[@id="info"]/p[3]
            novelInfo.setNovelimg(page.getHtml().xpath("//*[@id=\"fmimg\"]/img/@src").toString());
            // //*[@id="fmimg"]/img
            novelInfo.setBrief(page.getHtml().xpath("//*[@id=\"intro\"]/p[1]/text()").toString());


			novelInfo.setNewchapterurl(page.getHtml().xpath("//*[@id=\"info\"]/p[4]/a/@href").toString());

			novelInfo.setCategory(page.getHtml().css("#wrapper > div:nth-child(4) > div.con_top > a:nth-child(2)","text").toString().replaceAll("小说",""));
			String url =page.getHtml().xpath("//*[@id=\"info\"]/p[4]/a/@href").toString();
			String[] strs= url.replace(".", "/").split("/");
			String novelNum =strs[strs.length-3];
			String chapterNum =strs[strs.length-2];
			System.out.println("小说标识"+novelNum);
			System.out.println("小说章节标识"+chapterNum);
			novelInfo.setNovelnum(novelNum);
			page.putField("novelInfo",novelInfo);
			page.putField("type",nOpInfo.getType());
		}else if ("novelChapter".equals(nOpInfo.getType())){

			if ("first".equals(nOpInfo.getState())){
				page.addTargetRequests(page.getHtml().links().regex("http://www.xfqxsw.com/html/"+nOpInfo.getTargetUrl()+"/\\d+.html").all());
			}else if ("update".equals(nOpInfo.getState())){
				System.out.println(nOpInfo.getState());
				//page.addTargetRequests(page.getHtml().links().regex("http://www.xfqxsw.com/html/"+targetUrl+"/\\d+.html").all());
			}


			NovelChapter chapter = new NovelChapter();
			chapter.setChaptername(page.getHtml().css("body > div.content_read > div.box_con > div.bookname > h1","text").toString());
			chapter.setChapterurl(page.getRequest().getUrl());
			chapter.setContent(page.getHtml().xpath("//*[@id=\"content\"]/text()").toString());
			chapter.setNovelname(page.getHtml().css("body > div.content_read > div.box_con > div.con_top > a:nth-child(3)","text").toString());
			//#wrapper > div.content_read > div > div.con_top > a:nth-child(5)
			String url =page.getRequest().getUrl();
            String[] strs= url.replace(".", "/").split("/");
            String[] novelNums =strs[strs.length-3].split("_");
            String novelNum = strs[strs.length-3].replace("_",novelNums[0]);
            String chapterNum =strs[strs.length-2];
			System.out.println("小说标识"+novelNum);
			System.out.println("小说章节标识"+chapterNum);
			//	chapter.setNovelnum(Integer.parseInt(novelNum));
			chapter.setChapternum(Integer.parseInt(chapterNum));
			chapter.setChapternum(Integer.parseInt(chapterNum));
			if(Integer.parseInt(chapterNum)>=nOpInfo.getChapternum()){
				page.putField("chapter", chapter);
				page.putField("type",nOpInfo.getType());
			}else{
				page.setSkip(true);
			}

		}


	}

	public Site getSite() {
		return site;

	}
	
	public static void main(String[] args){
	//	Spider.create(new FQXSPageprocessor("69999",null,"first","novelChapter")).addUrl("http://www.xfqxsw.com/html/69999/13524860.html").addPipeline(new NovelChapterPipeline()).thread(20).run();
		//Spider.create(new FQXSPageprocessor("null",null,null,"novelInfo")).addUrl("http://www.xfqxsw.com/book/xueyinglingzhu/").addPipeline(new ConsolePipeline()).thread(1).run();
		String url="http://www.bixia.org/45_45883/2643877.html";
		String[] strs= url.replace(".", "/").split("/");
		String[] novelNums =strs[strs.length-3].split("_");
		String novelNum = strs[strs.length-3].replace("_",novelNums[0]);
		String chapterNum =strs[strs.length-2];
		System.out.println("小说标识"+novelNum);
		System.out.println("小说章节标识"+chapterNum);

	}
}
