package com.jejuro.server.service;

import java.util.List;

import com.jejuro.server.entity.Alarm;

public interface AlarmService {
	//알람 정보 가져오기
	List<Alarm> getList(int id);

	//알람 삭제
	void delete(int id);

	// 알람 id로 회원 id 가져오기
	int getMemberId(int id);

}
