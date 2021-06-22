package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.HomeworkDescHomework;
import com.cloud.homeworksystem.bean.HomeworkStudentTea;
import com.cloud.homeworksystem.mapper.HomeworkDescHomeworkMapper;
import com.cloud.homeworksystem.mapper.HomeworkDescHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class HomeworkDescHomeworkServiceImpl implements HomeworkDescHomeworkService{
    @Autowired
    HomeworkDescHomeworkMapper homeworkDescHomeworkMapper;

    @Override
    public List<HomeworkDescHomework> selectStudentHomeworkStatus(BigInteger sid){
        return homeworkDescHomeworkMapper.selectStudentHomeworkStatus(sid);
    };

    @Override
    public List<HomeworkStudentTea> selectAllStudentHomework(BigInteger cid, BigInteger hid){
        return homeworkDescHomeworkMapper.selectAllStudentHomework(cid,hid);
    }
}
