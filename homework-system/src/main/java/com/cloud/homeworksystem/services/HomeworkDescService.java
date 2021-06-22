package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.HomeworkDesc;
import org.apache.ibatis.annotations.*;
import com.cloud.homeworksystem.bean.Student;

import java.math.BigInteger;
import java.util.List;

public interface HomeworkDescService {
    public List<HomeworkDesc> getAllHomByTid(BigInteger tid);

    public List<HomeworkDesc> getAllHomByCid(BigInteger cid);

    public HomeworkDesc getHomByCidHid(BigInteger cid,BigInteger hid);

    public int deleteHomByHid(BigInteger hid);

    public int insertHom(HomeworkDesc homeworkDesc);

    public int updateHom(HomeworkDesc homeworkDesc);
}
