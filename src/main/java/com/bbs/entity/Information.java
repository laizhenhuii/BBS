package com.bbs.entity;


import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

//消息实体类

@Mapper
public class Information {
    private String originContent; //原贴内容
    private String receiverTel;   //接收方手机号
    private String reason;      //修改原因
    private Timestamp postTime;//发送时间
    private String originTitle;//原贴标题
    private boolean haveRead;//是否已读
    private int informationID;//消息id
    private String posterID; //消息发送人id
    private String postID; //回应的帖子的id

    public Information(){};

    public String getOriginContent() {
        return originContent;
    }

    public void setOriginContent(String originContent) {
        this.originContent = originContent;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public boolean isHaveRead() {
        return haveRead;
    }

    public void setHaveRead(boolean haveRead) {
        this.haveRead = haveRead;
    }

    public int getInformationID() {
        return informationID;
    }

    public void setInformationID(int informationID) {
        this.informationID = informationID;
    }

    public String getPosterID() {
        return posterID;
    }

    public void setPosterID(String posterID) {
        this.posterID = posterID;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }
}
