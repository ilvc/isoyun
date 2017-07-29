package me.ilvc.yunso.novel.model;

import me.ilvc.yunso.utils.String2Unicode;

import java.util.Date;

public class RNovelChapter {

    private Integer chapterId;

    private String novelname;

    private String chaptername;

    private String chapterurl;

    private String novelnum;

    private Integer chapternum;

    private String content;

    private Date addtime;
    private NovelChapter novelChapter;

    public NovelChapter getNovelChapter() {
        return novelChapter;
    }

    public void setNovelChapter(NovelChapter novelChapter) {
        this.novelChapter = novelChapter;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getNovelname() {
        return novelname;
    }

    public void setNovelname(String novelname) {
        this.novelname = novelname == null ? null : novelname.trim();
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername == null ? null : chaptername.trim();
    }

    public String getChapterurl() {
        return chapterurl;
    }

    public void setChapterurl(String chapterurl) {
        this.chapterurl = chapterurl == null ? null : chapterurl.trim();
    }

    public String getNovelnum() {
        return novelnum;
    }

    public void setNovelnum(String novelnum) {
        this.novelnum = novelnum;
    }

    public Integer getChapternum() {
        return chapternum;
    }

    public void setChapternum(Integer chapternum) {
        this.chapternum = chapternum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }


    public RNovelChapter(NovelChapter novelChapter) {
        this.novelChapter = novelChapter;
        this.chapterId=novelChapter.getChapterId();
        this.chaptername= String2Unicode.unicode2String(novelChapter.getChaptername());
        this.chapterurl=String2Unicode.unicode2String(novelChapter.getChapterurl()) ;
        this.content=String2Unicode.unicode2String(novelChapter.getContent()) ;
        this.novelname=String2Unicode.unicode2String(novelChapter.getNovelname());
        this.chapternum=novelChapter.getChapternum();
        this.novelnum=novelChapter.getNovelnum();

    }
}