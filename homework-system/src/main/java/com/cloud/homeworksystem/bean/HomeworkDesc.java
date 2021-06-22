package com.cloud.homeworksystem.bean;

import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeWithZoneIdSerializer;

import java.math.BigInteger;
import java.sql.Date;

public class HomeworkDesc {
    private BigInteger hid;
    private String name;
    private String path;
    private BigInteger tid;
    private BigInteger cid;
    private Date date;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BigInteger getTid() {
        return tid;
    }

    public void setTid(BigInteger tid) {
        this.tid = tid;
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
}
