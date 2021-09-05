package com.scy.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AdminInfo {
    private String adminName;
    private String adminPwd;
    private String adminPwdR;
    //因为前端过来的参数是个 字符串，所以 这里要 做个类型转换
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date adminTime;
    private String sex;
    private String hobby;
    private String jiuye;
    private String zhuan;
    private List<Lover> loverList;
    private Integer[] aiHao;//1.吃  2.喝  3.玩

    @Override
    public String toString() {
        return "AdminInfo{" +
                "adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminPwdR='" + adminPwdR + '\'' +
                ", adminTime=" + adminTime +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", jiuye='" + jiuye + '\'' +
                ", zhuan='" + zhuan + '\'' +
                ", loverList=" + loverList +
                ", aiHao=" + Arrays.toString(aiHao) +
                '}';
    }

    public Integer[] getAiHao() {
        return aiHao;
    }

    public void setAiHao(Integer[] aiHao) {
        this.aiHao = aiHao;
    }

    public List<Lover> getLoverList() {
        return loverList;
    }

    public void setLoverList(List<Lover> loverList) {
        this.loverList = loverList;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminPwdR() {
        return adminPwdR;
    }

    public void setAdminPwdR(String adminPwdR) {
        this.adminPwdR = adminPwdR;
    }

    public Date getAdminTime() {
        return adminTime;
    }

    public void setAdminTime(Date adminTime) {
        this.adminTime = adminTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getJiuye() {
        return jiuye;
    }

    public void setJiuye(String jiuye) {
        this.jiuye = jiuye;
    }

    public String getZhuan() {
        return zhuan;
    }

    public void setZhuan(String zhuan) {
        this.zhuan = zhuan;
    }
}
