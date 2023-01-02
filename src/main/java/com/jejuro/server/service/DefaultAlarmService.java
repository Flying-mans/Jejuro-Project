package com.jejuro.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jejuro.server.dao.AlarmDao;
import com.jejuro.server.entity.Alarm;

@Service
public class DefaultAlarmService implements AlarmService{

	@Autowired
	private AlarmDao dao;

	//알람 정보 가져오기
	@Override
	public List<Alarm> getList(int id) {
		return dao.getList(id);
	}
	
	//알람 삭제
	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	// 알람 id로 회원 id 가져오기
	@Override
	public int getMemberId(int id) {
		return dao.getMemberId(id);
		
	}



}
