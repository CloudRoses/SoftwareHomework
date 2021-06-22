package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.HomeworkDesc;
import com.cloud.homeworksystem.mapper.HomeworkDescMapper;
import com.cloud.homeworksystem.services.HomeworkDescService;
import org.apache.ibatis.annotations.*;
import com.cloud.homeworksystem.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class HomeworkDescServiceImpl implements HomeworkDescService{

    @Autowired
    HomeworkDescMapper homeworkDescMapper;

    @Override
    public List<HomeworkDesc> getAllHomByTid(BigInteger tid){
        return homeworkDescMapper.getAllHomByTid(tid);
    }

    @Override
    public List<HomeworkDesc> getAllHomByCid(BigInteger cid){
        return homeworkDescMapper.getAllHomByCid(cid);
    }

    @Override
    public HomeworkDesc getHomByCidHid(BigInteger cid,BigInteger hid){
        return homeworkDescMapper.getHomByCidHid(cid,hid);
    }

    @Override
    public int deleteHomByHid(BigInteger hid){
        return homeworkDescMapper.deleteHomByHid(hid);
    }

    @Override
    public int insertHom(HomeworkDesc homeworkDesc){
        return homeworkDescMapper.insertHom(homeworkDesc);
    }

    @Override
    public int updateHom(HomeworkDesc homeworkDesc){
        return homeworkDescMapper.updateHom(homeworkDesc);
    }
}
