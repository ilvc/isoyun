package me.ilvc.yunso.novel.pageprocessor;

import me.ilvc.yunso.novel.model.*;
import me.ilvc.yunso.novel.pipeline.NovelChapterPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;


public class FQXSPageprocessor implements PageProcessor{

	@Autowired
	private NovelChapterPipeline novelChapterPipeline;

	private Site site = Site.me().setRetrySleepTime(5).setSleepTime(300).setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.109 Safari/537.36");

	private NOpInfo nOpInfo;

	public NOpInfo getnOpInfo() {
		return nOpInfo;
	}

	public FQXSPageprocessor(NOpInfo nOpInfo) {
		this.nOpInfo = nOpInfo;
	}

	public void setnOpInfo(NOpInfo nOpInfo) {
		this.nOpInfo = nOpInfo;
	}

	public void process(Page page) {

		if ("novelInfo".equals(nOpInfo.getType())){
			NovelInfo novelInfo = new NovelInfo();
			novelInfo.setNovelName(page.getHtml().xpath("//*[@id=\"info\"]/h1/text()").toString());
			novelInfo.setAuthor(page.getHtml().xpath("//*[@id=\"info\"]/p[1]/text()").toString().replaceAll(" ","").replace("作者：",""));
			novelInfo.setState(page.getHtml().css("#info > p:nth-child(3)","text").toString().replace(",","").replace("状  态：","").replace("中   ",""));
			novelInfo.setNewchapter(page.getHtml().xpath("//*[@id=\"info\"]/p[4]/a/text()").toString());
			novelInfo.setNewupdate(page.getHtml().xpath("//*[@id=\"info\"]/p[3]/text()").toString().replace("最后更新：",""));
			novelInfo.setNovelimg(page.getHtml().xpath("//*[@id=\"fmimg\"]/img/@src").toString());
			novelInfo.setBrief(page.getHtml().xpath("//*[@id=\"intro\"]/p[1]/text()").toString());
			novelInfo.setNewchapterurl(page.getHtml().xpath("//*[@id=\"info\"]/p[4]/a/@href").toString());
			novelInfo.setCurrentPageUrl(page.getUrl().toString());

			// 如果抓取的页面的是笔下文学 就不抽取 分类
			if (!page.getHtml().toString().contains("www.bixia.org")){
				String cate=page.getHtml().css("#wrapper > div:nth-child(4) > div.con_top > a:nth-child(2)","text").toString().replace("小说","");
				novelInfo.setCategory(cate==null?" ":cate);
			}
			String url =page.getHtml().xpath("//*[@id=\"info\"]/p[4]/a/@href").toString();
			String[] strs= this.urlConvert(url);
			novelInfo.setNovelnum(strs[1]);
			page.putField("novelInfo",novelInfo);
			page.putField("type",nOpInfo.getType());
		}else if ("novelChapter".equals(nOpInfo.getType())){

			if ("first".equals(nOpInfo.getState())){
				page.addTargetRequests(page.getHtml().links().regex(nOpInfo.getTargetUrl()+"/\\d+.html").all());
				System.out.println(nOpInfo.getState());
				System.out.println(nOpInfo.getTargetUrl());
			}else if ("update".equals(nOpInfo.getState())){
				System.out.println(nOpInfo.getState());
				//page.addTargetRequests(page.getHtml().links().regex("http://www.xfqxsw.com/html/"+targetUrl+"/\\d+.html").all());
			}


		//	page.addTargetRequests(page.getHtml().links().regex("http://www.xfqxsw.com/html/"+targetUrl+"/\\d+.html").all());
			NovelChapter chapter = new NovelChapter();
			// //*[@id="wrapper"]/div[4]/div/div[2]/h1
			// #wrapper > div.content_read > div > div.bookname > h1
			chapter.setChaptername(page.getHtml().css("#wrapper > div.content_read > div > div.bookname > h1","text").toString());
			chapter.setChapterurl(page.getRequest().getUrl());
			chapter.setContent(page.getHtml().xpath("//*[@id=\"content\"]/text()").toString());
			chapter.setNovelname(page.getHtml().css("#wrapper > div.content_read > div > div.con_top > a:nth-child(4)","text").toString());
			//#wrapper > div.content_read > div > div.con_top > a:nth-child(5)
			String[] nums = this.urlConvert(page.getRequest().getUrl());
			chapter.setNovelnum(nums[1]);
			chapter.setChapternum(Integer.parseInt(nums[0]));
			if(chapter.getChapternum()>=nOpInfo.getChapternum()){
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

	private static String[] urlConvert(String url){
		String[] num =new String[2];
		String[]  urls =url.replace(".","/").split("/");

		//章节号
		num[0]=urls[urls.length-2].trim();

		if(urls.length>=3){
			num[1]=urls[urls.length-3];
		}
		return num;
	}

	public static String remove(String resource,char ch)
	{
		StringBuffer buffer=new StringBuffer();
		int position=0;
		char currentChar;

		while(position<resource.length())
		{
			currentChar=resource.charAt(position++);
			if(currentChar!=ch) buffer.append(currentChar); } return buffer.toString();
	}
	
	public static void main(String[] args){
	//	Spider.create(new FQXSPageprocessor("69999",null,"first","novelChapter")).addUrl("http://www.xfqxsw.com/html/69999/13524860.html").addPipeline(new NovelChapterPipeline()).thread(20).run();
		//Spider.create(new FQXSPageprocessor("null",null,null,"novelInfo")).addUrl("http://www.xfqxsw.com/book/xueyinglingzhu/").addPipeline(new ConsolePipeline()).thread(1).run();
/*
		String url="http://www.xfqxsw.com/html/70334/13872627.html";
		String url2="2728855.html";
		String url3="http://www.biquzi.com/0_703/7364624.html";
	//	String[]  urls =url.replace(".","/").split("/");
		for (String i:urlConvert(url)
			 ) {
			System.out.println(i);
		}

		System.out.println("==============================");
		for (String i:urlConvert(url2)
				) {
			System.out.println(i);
		}
		System.out.println("==============================");
		for (String i:urlConvert(url3)
				) {
			System.out.println(i);
		}*/

		System.out.println("作    者：骷髅精灵".replaceAll(" ","").replace("作者：",""));
		
		System.out.println(remove("作    者：骷髅精灵",' '));


	}
}
