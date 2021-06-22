package com.cloud.homeworksystem.mapper;

import com.cloud.homeworksystem.bean.HomeworkDescHomework;
import com.cloud.homeworksystem.bean.HomeworkStudentTea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface HomeworkDescHomeworkMapper {
    public List<HomeworkDescHomework> selectStudentHomeworkStatus(BigInteger sid);

    public List<HomeworkStudentTea> selectAllStudentHomework(@Param("cid")BigInteger cid, @Param("hid")BigInteger hid);
}
