package com.bbs.entity;


import java.sql.Timestamp;

//帖子实体类
public class Post {
    private String posterID; //发帖人ID（手机号）
    private String posterName;//发帖人用户名
    private int postID; //帖子ID
    private String postTitle;//帖子标题
    private int mainPost;//是否是主贴，该字段为-1时是主贴
    private Timestamp postTime; //发表时间
    private int likeNumber;//点赞数
    private int pageView;//浏览量
    private String content;//帖子内容
    private boolean homeTop; //是否首页置顶，为1时置顶
    private boolean personalTop;//是否个人主页置顶，为1时置顶
    private boolean postBoutique;//是否加精，为1时加精
    private int postIntegral;//积分数
    private String moudleType;//模块类型，如天健轶事

    public Post(String posterID, String posterName, int postID, String postTitle, int mainPost, Timestamp postTime, int likeNumber, int pageView, String content, boolean homeTop, boolean personalTop, boolean postBoutique, int postIntegral, String moudleType) {
        this.posterID = posterID;
        this.posterName = posterName;
        this.postID = postID;
        this.postTitle = postTitle;
        this.mainPost = mainPost;
        this.postTime = postTime;
        this.likeNumber = likeNumber;
        this.pageView = pageView;
        this.content = content;
        this.homeTop = homeTop;
        this.personalTop = personalTop;
        this.postBoutique = postBoutique;
        this.postIntegral = postIntegral;
        this.moudleType = moudleType;
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

    public String getContent() {
        return content;
    }

    public boolean getHomeTop() {
        return homeTop;
    }

    public boolean getPersonalTop() {
        return personalTop;
    }

    public boolean getPostBoutique() {
        return postBoutique;
    }

    public int getPostIntegral() {
        return postIntegral;
    }

    public String getMoudleType() {
        return moudleType;
    }

    public void setPosterID(String posterID) {
        this.posterID = posterID;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public void setPostID(int postID) {
        this.postID = postID;
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

    public void setContent(String content) {
        this.content = content;
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

    public void setMoudleType(String moudleType) {
        this.moudleType = moudleType;
    }
}
