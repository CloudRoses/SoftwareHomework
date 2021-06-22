package com.cloud.homeworksystem.mapper;

import com.cloud.homeworksystem.bean.Sc;
import com.cloud.homeworksystem.bean.Student;

import java.math.BigInteger;
import java.util.List;

public interface ScService {
    public List<Sc> getScBySid(BigInteger sid);

    public int deleteScBySid(BigInteger sid);

    public int insertSc(Sc sc);

    public int updateSc(Sc sc);
}
