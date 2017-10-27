package com.ztel.app.service.sys;

import java.util.HashMap;
import java.util.List;

import com.ztel.app.vo.sys.DeptTreeVo;
import com.ztel.app.vo.sys.DeptVo;


/**
 * 
 * @author SN
 *
 */
public interface DeptVoService {
	/**
	 * 根据用户名密码，验证登录用户是否存在
	 * @param username
	 * @param userpsw
	 * @return
	 */
public List<DeptTreeVo> getDeptTree(String parentId);


	/**
	 * 取部门下拉框
	 * @return
	 */
	public List<HashMap<String, String>>getDeptCombobox();
	/**
	 * 数据翻页
	 * @return
	 */
	//public List<DeptVo> getDeptVoPageList(Pagination<?> page);
	
	public int delDeptVo(List<Integer> ids);

	public int insertDeptVo(DeptVo deptVo);

	public int updateDeptVo(DeptVo deptVo);
	
	public List<DeptVo> getDeptinfoList(DeptVo vo,String keywd);
	 /**
	  * 获取部门信息，用于投诉年报表取车组归宿部门信息
	  * @return
	  */
	public  List<DeptVo> getDeptinfoForReport();
	/**
     * 库存管理领料时只取二级部门，增加此方法
     * @param vo
     * @return
     */
	public List<HashMap<String, String>> getDeptComboboxByCond(DeptVo vo);
}
