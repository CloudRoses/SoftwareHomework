package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.Homework;
import org.apache.ibatis.annotations.*;
import com.cloud.homeworksystem.bean.Student;

import java.math.BigInteger;
import java.util.List;

public interface HomeworkService {

    public Homework getHomByHid(BigInteger hid);

    public int deleteHomByHid(BigInteger hid);

    public int insertHom(Homework homework);

    public int updateHom(Homework homework);

    public List<Homework> getAllUpHomByCidHid(BigInteger cid,BigInteger hid);

    public Homework getHomFisSta(BigInteger cid,BigInteger hid,BigInteger sid);
}
