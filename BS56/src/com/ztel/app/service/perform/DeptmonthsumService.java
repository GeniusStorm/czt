package com.ztel.app.service.perform;

import java.math.BigDecimal;
import java.util.List;

import com.ztel.app.vo.perform.DeptmonthLineVo;
import com.ztel.app.vo.perform.DeptmonthsumVo;
import com.ztel.framework.vo.Pagination;

public interface DeptmonthsumService {
	
	public List<DeptmonthsumVo>  selectDeptmonthsumPageList(Pagination<?> page);
	/**
	 * 考核新增
	 * @param deptmonthsumVo
	 * @param deptmonthLineVoList
	 * @param obid
	 */
	public void insertDeptmonthsum(DeptmonthsumVo deptmonthsumVo,List<DeptmonthLineVo> deptmonthLineVoList,String obid);
	
	/**
	 * 考核修改
	 * @param deptmonthsumVo
	 * @param deptmonthLineVoList
	 */
	public void updateDeptmonthsum(DeptmonthsumVo deptmonthsumVo,List<DeptmonthLineVo> deptmonthLineVoList);
	
	/**
	 * 修改
	 * @param deptmonthsumVo
	 * @param deptmonthLineVoList
	 */
	public void updateDeptmonthsumByCond(DeptmonthsumVo deptmonthsumVo);
	
	public DeptmonthsumVo selectDeptmonthsumByCond(DeptmonthsumVo deptmonthsumVo);
	
	/**
	 * 修改
	 * @param deptmonthsumVo
	 */
	public void doEdit(DeptmonthsumVo deptmonthsumVo);
	
	/**
	 * 部长审核
	 * @param deptmonthsumVo
	 */
	public void doOneAudit(DeptmonthsumVo deptmonthsumVo);
	
	/**
	 * 总经理评
	 * @param deptmonthsumVo
	 */
	public void doEndAudit(DeptmonthsumVo deptmonthsumVo);
	
	public void doDel(Long id);
}
