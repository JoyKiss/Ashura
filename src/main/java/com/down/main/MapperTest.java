package com.down.main;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.ashura.dao.mapper.UmRuleStatusMapper;
import com.down.utils.MapperUtils;

@Component
public class MapperTest {

	public static void main(String[] args) {
		show();
	}

	public static void show() {
		UmRuleStatusMapper um = (UmRuleStatusMapper) MapperUtils.getMapper(UmRuleStatusMapper.class);
		Date a = um.selectByExample(null).get(0).getUpdatetime();
		System.out.println(a.getTime());
	}
}
