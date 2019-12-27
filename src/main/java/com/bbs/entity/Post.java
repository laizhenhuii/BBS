package com.bbs.entity;


import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

//帖子实体类

@Mapper
public class Post {
    private String posterID; //发帖人ID（手机号）
    private String posterName;//发帖人用户名
    private int postID; //帖子ID
    private String postTitle;//帖子标题
    private int mainPost;//是否是主贴，该字段为-1时是主贴
    private Timestamp postTime; //发表时间
    private int likeNumber;//点赞数
    private int pageView;//浏览量
    private String postContent;//帖子内容
    private boolean homeTop; //是否首页置顶，为true时置顶
    private boolean personalTop;//是否个人主页置顶，为true时置顶
    private boolean postBoutique;//是否加精，为true时加精
    private int postIntegral;//积分数,是否为需求贴
    private String moduleType;//版块类型，如天健轶事
    private Timestamp lastPost; //如果该贴是主贴，记录该贴的最后回帖时间
    private String imageAddress; //帖子图片地址

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    private int parentID;   //上一级评论


    public Post(){}


    public void setPostID(int postID) {
        this.postID = postID;
    }

    public boolean isHomeTop() {
        return homeTop;
    }

    public boolean isPersonalTop() {
        return personalTop;
    }

    public boolean isPostBoutique() {
        return postBoutique;
    }



    public String getPosterID() {
        return posterID;
    }

    public String getPosterName() {
        return posterName;
    }

    public int getPostID() {
        return postID;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public int getMainPost() {
        return mainPost;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public int getPageView() {
        return pageView;
    }

    public String getPostContent() {
        return postContent;
    }



    public int getPostIntegral() {
        return postIntegral;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setPosterID(String posterID) {
        this.posterID = posterID;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }


    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setMainPost(int mainPost) {
        this.mainPost = mainPost;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public void setPageView(int pageView) {
        this.pageView = pageView;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public void setHomeTop(boolean homeTop) {
        this.homeTop = homeTop;
    }

    public void setPersonalTop(boolean personalTop) {
        this.personalTop = personalTop;
    }

    public void setPostBoutique(boolean postBoutique) {
        this.postBoutique = postBoutique;
    }

    public void setPostIntegral(int postIntegral) {
        this.postIntegral = postIntegral;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public Timestamp getLastPost() {
        return lastPost;
    }

    public void setLastPost(Timestamp lastPost) {
        this.lastPost = lastPost;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }
}
