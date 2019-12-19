package com.bbs.entity;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.sql.Timestamp;

@Mapper
public class User {
    private String name;  //用户姓名
    private String password;  //用户密码，不可为空
    private String tel;      //用户手机号，不可为空
    private String sex;     //用户性别
    private String sign;    //用户签名
    private String head;    //用户头像
    private String email;     //用户邮箱
    private String studyArea;    //用户学习区域
    private Timestamp registerTime;    //用户注册时间
    private Date birthday;       //用户生日
    private String home;          //用户家乡
    private int integral;            //用户积分
    private int reputationValue;         //用户信誉值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudyArea() {
        return studyArea;
    }

    public void setStudyArea(String studyArea) {
        this.studyArea = studyArea;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
}

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getReputationValue() {
        return reputationValue;
    }

    public void setReputationValue(int reputationValue) {
        this.reputationValue = reputationValue;
    }
}
