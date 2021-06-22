package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.Course;
import com.cloud.homeworksystem.bean.Student;

import java.math.BigInteger;
import java.util.List;

public interface CourseService {
    public List<Course> getAllCourse();

    public List<Course> getTeaCourse(BigInteger tid);

    public Course getCouById(BigInteger cid);

    public int deleteCouById(BigInteger cid);

    public int insertCou(Course course);

    public int updateCou(Course course);
}

