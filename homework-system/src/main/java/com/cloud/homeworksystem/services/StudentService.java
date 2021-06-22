package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.Student;

import java.math.BigInteger;
import java.util.List;

public interface StudentService {
    public Student getStuById(BigInteger id);

    public int deleteStuById(BigInteger id);

    public int insertStu(Student student);

    public int updateStu(Student student);
}

