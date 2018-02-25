package kr.co.test.junit.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.LogDeclare;
import common.spring.resolver.ParamCollector;
import common.util.map.ResultSetMap;
import kr.co.test.junit.db.mapper.MemberMapper;

@Service
public class MyBatisServiceImpl extends LogDeclare implements MyBatisService {
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public List<ResultSetMap> listUser() {
		return memberMapper.selectAll();
	}

	@Override
	public void addUser(ParamCollector paramCollector) {
		memberMapper.insert(paramCollector.getMapAll());
	}

	@Override
	public ResultSetMap getUser(ParamCollector paramCollector) {
		return memberMapper.selectOne(paramCollector.getMapAll());
	}

	@Override
	public void modifyUser(ParamCollector paramCollector) {
		memberMapper.update(paramCollector.getMapAll());
	}

	@Override
	public void removeUser(ParamCollector paramCollector) {
		memberMapper.delete(paramCollector.getMapAll());
	}
	
}
