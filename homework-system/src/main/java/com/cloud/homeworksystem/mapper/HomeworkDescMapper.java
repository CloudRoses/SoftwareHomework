package com.cloud.homeworksystem.mapper;

import com.cloud.homeworksystem.bean.HomeworkDesc;
import org.apache.ibatis.annotations.*;
import com.cloud.homeworksystem.bean.Student;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface HomeworkDescMapper {

    public List<HomeworkDesc> getAllHomByTid(BigInteger tid);

    public List<HomeworkDesc> getAllHomByCid(BigInteger cid);

    public HomeworkDesc getHomByCidHid(@Param("cid")BigInteger cid,@Param("hid")BigInteger hid);

    public int deleteHomByHid(BigInteger hid);

    public int insertHom(HomeworkDesc homeworkDesc);

    public int updateHom(HomeworkDesc homeworkDesc);
}
