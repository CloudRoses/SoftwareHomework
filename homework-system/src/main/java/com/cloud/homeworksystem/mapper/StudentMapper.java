package com.cloud.homeworksystem.mapper;

import org.apache.ibatis.annotations.*;
import com.cloud.homeworksystem.bean.Student;

import java.math.BigInteger;

@Mapper
public interface StudentMapper {

    public Student getStuById(BigInteger id);

    public int deleteStuById(BigInteger id);

    public int insertStu(Student student);

    public int updateStu(Student student);
}
