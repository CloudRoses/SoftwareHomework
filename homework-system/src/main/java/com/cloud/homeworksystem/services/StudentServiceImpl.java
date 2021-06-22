package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.Student;
import com.cloud.homeworksystem.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student getStuById(BigInteger id){
        return studentMapper.getStuById(id);
      }

    @Override
    public int deleteStuById(BigInteger id){
        return studentMapper.deleteStuById(id);
    }

    @Override
    public int insertStu(Student student){
        return studentMapper.insertStu(student);
    }

    @Override
    public int updateStu(Student student){
        return studentMapper.updateStu(student);
    }
}//StudentServiceImpl

