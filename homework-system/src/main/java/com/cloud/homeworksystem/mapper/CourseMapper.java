package com.cloud.homeworksystem.mapper;

import com.cloud.homeworksystem.bean.Course;
import org.apache.ibatis.annotations.*;
import com.cloud.homeworksystem.bean.Student;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CourseMapper {

    public List<Course> getAllCourse();

    public List<Course> getTeaCourse(BigInteger tid);

    public Course getCouById(BigInteger cid);

    public int deleteCouById(BigInteger cid);

    public int insertCou(Course course);

    public int updateCou(Course course);
}
