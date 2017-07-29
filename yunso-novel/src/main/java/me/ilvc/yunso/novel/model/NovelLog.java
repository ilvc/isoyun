package me.ilvc.yunso.novel.model;

import java.util.Date;

public class NovelLog {
    private Integer logId;

    private String url;

    private Integer uid;

    private Date addtime;

    private String visitorip;

    private String describe;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getVisitorip() {
        return visitorip;
    }

    public void setVisitorip(String visitorip) {
        this.visitorip = visitorip == null ? null : visitorip.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}