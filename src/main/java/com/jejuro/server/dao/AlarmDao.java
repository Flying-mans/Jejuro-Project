package com.jejuro.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jejuro.server.entity.Alarm;

@Mapper
public interface AlarmDao {
	
	//알람 정보 가져오기
   List<Alarm> getList(int id);
	
	//알람 삭제
	void delete(int id);

	//알람 id로 회원 id 가져오기
	int getMemberId(int id);

	void insert(int memberId, String code, String depDate, int price);


}
