package me.ilvc.yunso.novel.model;

import java.util.Date;

public class NovelChapter {
    private Integer chapterId;

    private String novelname;

    private String chaptername;

    private String chapterurl;

    private String novelnum;

    private Integer chapternum;

    private String content;

    private Date addtime;

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

    @Override
    public String toString() {
        return "NovelChapter{" +
                "chapterId=" + chapterId +
                ", novelname='" + novelname + '\'' +
                ", chaptername='" + chaptername + '\'' +
                ", chapterurl='" + chapterurl + '\'' +
                ", novelnum=" + novelnum +
                ", chapternum=" + chapternum +
                ", content='" + content + '\'' +
                ", addtime=" + addtime +
                '}';
    }
}