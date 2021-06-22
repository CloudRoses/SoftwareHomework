package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.Course;
import com.cloud.homeworksystem.bean.Student;
import com.cloud.homeworksystem.mapper.CourseMapper;
import com.cloud.homeworksystem.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourse(){
        return courseMapper.getAllCourse();
    }

    @Override
    public List<Course> getTeaCourse(BigInteger tid){
        return courseMapper.getTeaCourse(tid);
    }

    @Override
    public Course getCouById(BigInteger cid){
        return courseMapper.getCouById(cid);
    }

    @Override
    public int deleteCouById(BigInteger cid){
        return courseMapper.deleteCouById(cid);
    }

    @Override
    public int insertCou(Course course){
        return courseMapper.insertCou(course);
    }

    @Override
    public int updateCou(Course course){
        return courseMapper.updateCou(course);
    }
}//StudentServiceImpl

