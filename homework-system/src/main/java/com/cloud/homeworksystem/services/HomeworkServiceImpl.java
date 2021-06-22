package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.Homework;
import com.cloud.homeworksystem.mapper.HomeworkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    HomeworkMapper homeworkMapper;

    @Override
    public Homework getHomByHid(BigInteger hid){
        return homeworkMapper.getHomByHid(hid);
    }

    @Override
    public int deleteHomByHid(BigInteger hid){
        return homeworkMapper.deleteHomByHid(hid);
    }

    @Override
    public int insertHom(Homework homework){
        return homeworkMapper.insertHom(homework);
    }

    @Override
    public int updateHom(Homework homework){
        return homeworkMapper.updateHom(homework);
    }

    @Override
    public List<Homework> getAllUpHomByCidHid(BigInteger cid,BigInteger hid){
        return homeworkMapper.getAllUpHomByCidHid(cid,hid);
    }

    @Override
    public Homework getHomFisSta(BigInteger cid,BigInteger hid,BigInteger sid){
        return homeworkMapper.getHomFisSta(cid,hid,sid);
    }
}
