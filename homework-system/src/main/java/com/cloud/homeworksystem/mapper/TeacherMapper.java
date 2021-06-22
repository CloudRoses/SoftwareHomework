package com.cloud.homeworksystem.mapper;

import com.cloud.homeworksystem.bean.Teacher;
import org.apache.ibatis.annotations.*;
import com.cloud.homeworksystem.bean.Student;

import java.math.BigInteger;

@Mapper
public interface TeacherMapper {

    public Teacher getTeaById(BigInteger id);

    public int deleteTeaById(BigInteger id);

    public int insertTea(Teacher teacher);

    public int updateTea(Teacher teacher);
}
