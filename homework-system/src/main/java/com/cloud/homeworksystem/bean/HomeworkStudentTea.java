package com.cloud.homeworksystem.bean;

import java.math.BigInteger;
import java.sql.Date;

public class HomeworkStudentTea {
    private BigInteger hid;
    private String name;
    private BigInteger cid;
    private Date date;
    private BigInteger sid;
    private int score;

    public BigInteger getHid() {
        return hid;
    }

    public void setHid(BigInteger hid) {
        this.hid = hid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCid() {
        return cid;
    }

    public void setCid(BigInteger cid) {
        this.cid = cid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public BigInteger getSid() {
        return sid;
    }

    public void setSid(BigInteger sid) {
        this.sid = sid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
