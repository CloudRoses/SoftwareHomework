package com.cloud.homeworksystem.bean;

import java.math.BigInteger;

public class Homework {
    private BigInteger cid;
    private BigInteger hid;
    private BigInteger sid;
    private int score;

    public BigInteger getCid(){return cid;}

    public void setCid(BigInteger cid){this.cid=cid;}

    public BigInteger getHid() {
        return hid;
    }

    public void setHid(BigInteger hid) {
        this.hid = hid;
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
