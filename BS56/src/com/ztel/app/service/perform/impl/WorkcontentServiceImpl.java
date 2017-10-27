package com.ztel.app.service.perform.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztel.app.persist.mybatis.perform.WorkcontentVoMapper;
import com.ztel.app.service.perform.WorkcontentService;
import com.ztel.app.vo.perform.WorkcontentVo;

@Service
public class WorkcontentServiceImpl implements WorkcontentService {
	
	@Autowired
	private WorkcontentVoMapper workcontentVoMapper = null;

	@Override
	public List<WorkcontentVo> selectWorkcontentList(WorkcontentVo workcontentVo) {
		// TODO Auto-generated method stub
		return workcontentVoMapper.selectListByCond(workcontentVo);
	}

	@Override
	public void insertWorkcontent(WorkcontentVo workcontentVo) {
		// TODO Auto-generated method stub
		workcontentVoMapper.insertSelective(workcontentVo);

	}

	@Override
	public void doDel(Integer id) {
		// TODO Auto-generated method stub
		workcontentVoMapper.deleteByPrimaryKey(id);
	}

	public void doUpdate(WorkcontentVo workcontentVo){
		workcontentVoMapper.updateByPrimaryKeySelective(workcontentVo);
	}
}
