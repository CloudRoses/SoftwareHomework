package com.cloud.homeworksystem.bean;

import java.math.BigInteger;

public class Course {
    private BigInteger cid;
    private String name;
    private BigInteger tid;

    public BigInteger getCid() {
        return cid;
    }

    public void setCid(BigInteger cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getTid() {
        return tid;
    }

    public void setTid(BigInteger tid) {
        this.tid = tid;
    }
}
