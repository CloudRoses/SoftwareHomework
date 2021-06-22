package com.cloud.homeworksystem.services;

import com.cloud.homeworksystem.bean.Sc;
import com.cloud.homeworksystem.bean.Student;
import com.cloud.homeworksystem.mapper.ScMapper;
import com.cloud.homeworksystem.mapper.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ScServiceImpl implements ScService{
    @Autowired
    ScMapper scMapper;

    @Override
    public List<Sc> getScBySid(BigInteger sid){
        return scMapper.getScBySid(sid);
    }

    @Override
    public int deleteScBySid(BigInteger sid){
        return scMapper.deleteScBySid(sid);
    }

    @Override
    public int insertSc(Sc sc){
        return scMapper.insertSc(sc);
    }

    @Override
    public int updateSc(Sc sc){
        return scMapper.updateSc(sc);
    }
}
