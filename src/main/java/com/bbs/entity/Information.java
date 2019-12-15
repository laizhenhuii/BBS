package com.bbs.entity;


import java.sql.Timestamp;

//消息实体类
public class Information {
    private String content; //原贴内容
    private String posterTel;//接收方手机号
    private String reason;//修改原因
    private Timestamp time;//发送时间
    private String originalTitle;//原贴标题
    private boolean haveRead;//是否已读

    public Information(String content, String posterTel, String reason, Timestamp time, String originalTitle, boolean haveRead) {
        this.content = content;
        this.posterTel = posterTel;
        this.reason = reason;
        this.time = time;
        this.originalTitle = originalTitle;
        this.haveRead = haveRead;
    }

    public String getContent() {
        return content;
    }

    public String getPosterTel() {
        return posterTel;
    }

    public String getReason() {
        return reason;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public boolean getHaveRead() {
        return haveRead;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPosterTel(String posterTel) {
        this.posterTel = posterTel;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setHaveRead(boolean haveRead) {
        this.haveRead = haveRead;
    }
}
