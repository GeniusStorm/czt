package com.ztel.app.persist.mybatis.perform;

import java.util.List;

import com.ztel.app.vo.perform.DeptmonthLineVo;

public interface DeptmonthLineVoMapper {
	//根据fid和考核项id更新
	int updateByCondSelective(DeptmonthLineVo record);
	
	/**
	 * 根据查询条件获取列表，与重点工作表关联
	 * @param deptmonthLineVo
	 * @return
	 */
	List<DeptmonthLineVo> selectDeptmonthLineKWByCond(DeptmonthLineVo deptmonthLineVo);
	
	/**
	 * 根据查询条件获取列表，与日常工作表关联
	 * @param deptmonthLineVo
	 * @return
	 */
	List<DeptmonthLineVo> selectDeptmonthLineWCByCond(DeptmonthLineVo deptmonthLineVo);
    /**
     *
     * @mbggenerated 2017-10-10
     */
    int deleteByPrimaryKey(Long id);
    
    int deleteByParentid(Long id);

    /**
     *
     * @mbggenerated 2017-10-10
     */
    int insert(DeptmonthLineVo record);

    /**
     *
     * @mbggenerated 2017-10-10
     */
    int insertSelective(DeptmonthLineVo record);

    /**
     *
     * @mbggenerated 2017-10-10
     */
    DeptmonthLineVo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-10-10
     */
    int updateByPrimaryKeySelective(DeptmonthLineVo record);
    
    /**
     *
     * @mbggenerated 2017-10-10
     */
    int updateByPrimaryKey(DeptmonthLineVo record);
}