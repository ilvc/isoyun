package me.ilvc.yunso.novel.model;

/**
 * @Author: iLvc
 * @Date：Create in 14:47 2017/7/24
 * @Description:
 * @Modified By:
 */
public class NOpInfo {

    private String targetUrl;
    private String startUrl;
    private String state;
    private String type;
    private int chapternum=0;

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getChapternum() {
        return chapternum;
    }

    public void setChapternum(int chapternum) {
        this.chapternum = chapternum;
    }

    public NOpInfo(String targetUrl, String startUrl, String state, String type) {
        this.targetUrl = targetUrl;
        this.startUrl = startUrl;
        this.state = state;
        this.type = type;
    }

    @Override
    public String toString() {
        return "NOpInfo{" +
                "targetUrl='" + targetUrl + '\'' +
                ", startUrl='" + startUrl + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", chapternum=" + chapternum +
                '}';
    }
}
