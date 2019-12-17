package com.bbs.entity;

public class Manager {
    private String id;  //管理员id，不可为空
    private String name;  //管理员姓名
    private String password;  //管理员密码，不可为空

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
