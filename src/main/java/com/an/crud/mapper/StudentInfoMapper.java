package com.an.crud.mapper;

import com.an.crud.bean.StudentInfo;
import com.an.crud.bean.StudentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentInfoMapper {
    int countByExample(StudentInfoExample example);

    int deleteByExample(StudentInfoExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    List<StudentInfo> selectByExample(StudentInfoExample example);

    StudentInfo selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByExample(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}