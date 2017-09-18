package com.ashura.dao.mapper;

import com.ashura.entity.VideoInfo;
import com.ashura.entity.VideoInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoInfoMapper {
    long countByExample(VideoInfoExample example);

    int deleteByExample(VideoInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VideoInfo record);

    int insertSelective(VideoInfo record);

    List<VideoInfo> selectByExample(VideoInfoExample example);

    VideoInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VideoInfo record, @Param("example") VideoInfoExample example);

    int updateByExample(@Param("record") VideoInfo record, @Param("example") VideoInfoExample example);

    int updateByPrimaryKeySelective(VideoInfo record);

    int updateByPrimaryKey(VideoInfo record);
}