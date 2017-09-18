package com.ashura.dao.mapper;

import com.ashura.entity.UmRuleStatus;
import com.ashura.entity.UmRuleStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmRuleStatusMapper {
    long countByExample(UmRuleStatusExample example);

    int deleteByExample(UmRuleStatusExample example);

    int insert(UmRuleStatus record);

    int insertSelective(UmRuleStatus record);

    List<UmRuleStatus> selectByExample(UmRuleStatusExample example);

    int updateByExampleSelective(@Param("record") UmRuleStatus record, @Param("example") UmRuleStatusExample example);

    int updateByExample(@Param("record") UmRuleStatus record, @Param("example") UmRuleStatusExample example);
}