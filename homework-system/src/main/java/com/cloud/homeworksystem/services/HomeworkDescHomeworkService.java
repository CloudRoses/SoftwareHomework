package com.cloud.homeworksystem.mapper;

import com.cloud.homeworksystem.bean.HomeworkDescHomework;
import com.cloud.homeworksystem.bean.HomeworkStudentTea;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

public interface HomeworkDescHomeworkService {
    public List<HomeworkDescHomework> selectStudentHomeworkStatus(BigInteger sid);

    public List<HomeworkStudentTea> selectAllStudentHomework(BigInteger cid, BigInteger hid);
}
