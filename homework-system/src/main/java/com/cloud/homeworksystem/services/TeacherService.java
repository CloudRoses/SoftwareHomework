package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.Student;
import com.cloud.homeworksystem.bean.Teacher;

import java.math.BigInteger;
import java.util.List;

public interface TeacherService {
    public Teacher getTeaById(BigInteger id);

    public int deleteTeaById(BigInteger id);

    public int insertTea(Teacher teacher);

    public int updateTea(Teacher teacher);
}

