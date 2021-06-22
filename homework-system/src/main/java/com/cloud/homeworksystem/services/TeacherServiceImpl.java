package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.Student;
import com.cloud.homeworksystem.bean.Teacher;
import com.cloud.homeworksystem.mapper.StudentMapper;
import com.cloud.homeworksystem.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Teacher getTeaById(BigInteger id){
        return teacherMapper.getTeaById(id);
    }

    @Override
    public int deleteTeaById(BigInteger id){
        return teacherMapper.deleteTeaById(id);
    }

    @Override
    public int insertTea(Teacher teacher){
        return teacherMapper.insertTea(teacher);
    }

    @Override
    public int updateTea(Teacher teacher){
        return teacherMapper.updateTea(teacher);
    }
}//StudentServiceImpl

