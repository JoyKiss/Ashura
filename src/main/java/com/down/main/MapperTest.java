package com.down.main;

import org.springframework.stereotype.Component;

import com.ashura.dao.mapper.VideoInfoMapper;
import com.ashura.entity.VideoInfo;
import com.down.utils.MapperUtils;

@Component
public class MapperTest {
	public static void main(String[] args) {
		VideoInfoMapper videoMapper = (VideoInfoMapper) MapperUtils.getMapper(VideoInfoMapper.class);
		VideoInfo record = new VideoInfo();
		record.setAvid("15843716");
		record.setVideoname("假如室外温度达到60-70℃，人类多久会灭亡？");
		record.setUpuser("喵米拉希");
		record.setClassify("趣味科普人文 ");
		videoMapper.insert(record);
		MapperUtils.commit();
//		show();
	}

	public static void show() {
		VideoInfoMapper videoMapper = (VideoInfoMapper) MapperUtils.getMapper(VideoInfoMapper.class);
		VideoInfo videoInfo = videoMapper.selectByPrimaryKey(1);
		System.out.println(videoInfo.getVideoname());
	}
}
