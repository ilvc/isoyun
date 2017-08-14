package me.ilvc.yunso.novel.model;

import java.sql.Timestamp;
import java.util.Date;

public class NOpInfo {
    private Integer id;

    private String state;

    private String type;

    private String targetUrl=null;

    private String startUrl;

    private Integer chapternum=null;

    private Timestamp addTime;

    private Integer status;

    private String ndesc;

    private Integer ncount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl == null ? null : targetUrl.trim();
    }

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl == null ? null : startUrl.trim();
    }

    public Integer getChapternum() {
        return chapternum;
    }

    public void setChapternum(Integer chapternum) {
        this.chapternum = chapternum;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNdesc() {
        return ndesc;
    }

    public void setNdesc(String ndesc) {
        this.ndesc = ndesc == null ? null : ndesc.trim();
    }

    public Integer getNcount() {
        return ncount;
    }

    public void setNcount(Integer ncount) {
        this.ncount = ncount;
    }


    public NOpInfo(Integer id, String state, String type, String targetUrl, String startUrl, Integer chapternum, Timestamp addTime, Integer status, String ndesc, Integer ncount) {
        this.id = id;
        this.state = state;
        this.type = type;
        this.targetUrl = targetUrl;
        this.startUrl = startUrl;
        this.chapternum = chapternum;
        this.addTime = addTime;
        this.status = status;
        this.ndesc = ndesc;
        this.ncount = ncount;
    }

    public NOpInfo(String state, String type, String startUrl) {
        this.state = state;
        this.type = type;
        this.startUrl = startUrl;
    }

    @Override
    public String toString() {
        return "NOpInfo{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", targetUrl='" + targetUrl + '\'' +
                ", startUrl='" + startUrl + '\'' +
                ", chapternum=" + chapternum +
                ", addTime=" + addTime +
                ", status=" + status +
                ", ndesc='" + ndesc + '\'' +
                ", ncount=" + ncount +
                '}';
    }
}