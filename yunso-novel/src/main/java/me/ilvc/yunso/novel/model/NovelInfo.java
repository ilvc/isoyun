package me.ilvc.yunso.novel.model;



import java.util.List;

import java.util.Date;

public class NovelInfo {
    private Integer novelId;

    private String novelName;

    private String author;

    private String category;

    private String brief;

    private String state;

    private String newupdate;

    private String newchapter;

    private Date addtime;

    private Date lastupdate;

    private String novelnum;

    private String newchapterurl;

    private String novelimg;

    private String currentPageUrl;

    /*章节*/
    private List<NovelChapter> chapters;

    public List<NovelChapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<NovelChapter> chapters) {
        this.chapters = chapters;
    }

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName == null ? null : novelName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getNewupdate() {
        return newupdate;
    }

    public void setNewupdate(String newupdate) {
        this.newupdate = newupdate == null ? null : newupdate.trim();
    }

    public String getNewchapter() {
        return newchapter;
    }

    public void setNewchapter(String newchapter) {
        this.newchapter = newchapter == null ? null : newchapter.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getNovelnum() {
        return novelnum;
    }

    public void setNovelnum(String novelnum) {
        this.novelnum = novelnum == null ? null : novelnum.trim();
    }

    public String getNewchapterurl() {
        return newchapterurl;
    }

    public void setNewchapterurl(String newchapterurl) {
        this.newchapterurl = newchapterurl == null ? null : newchapterurl.trim();
    }

    public String getNovelimg() {
        return novelimg;
    }

    public void setNovelimg(String novelimg) {
        this.novelimg = novelimg == null ? null : novelimg.trim();
    }

    public String getCurrentPageUrl() {
        return currentPageUrl;
    }

    public void setCurrentPageUrl(String currentPageUrl) {
        this.currentPageUrl = currentPageUrl == null ? null : currentPageUrl.trim();
    }

    @Override
    public String toString() {
        return "NovelInfo{" +
                "novelId=" + novelId +
                ", novelName='" + novelName + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", brief='" + brief + '\'' +
                ", state='" + state + '\'' +
                ", newupdate='" + newupdate + '\'' +
                ", newchapter='" + newchapter + '\'' +
                ", addtime=" + addtime +
                ", lastupdate=" + lastupdate +
                ", novelnum='" + novelnum + '\'' +
                ", newchapterurl='" + newchapterurl + '\'' +
                ", novelimg='" + novelimg + '\'' +
                ", currentPageUrl='" + currentPageUrl + '\'' +
                ", chapters=" + chapters +
                '}';
    }
}