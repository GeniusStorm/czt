package com.ztel.app.persist.mybatis.perform;

import java.util.List;

import com.ztel.app.vo.perform.DeptmonthsumVo;
import com.ztel.framework.vo.Pagination;

public interface DeptmonthsumVoMapper {
	
	List<DeptmonthsumVo> selectDeptmonthsumPageList(Pagination<?> page);
	
	DeptmonthsumVo selectDeptmonthsumByCond(DeptmonthsumVo deptmonthsumVo);
    /**
     *
     * @mbggenerated 2017-10-10
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-10-10
     */
    int insert(DeptmonthsumVo record);

    /**
     *
     * @mbggenerated 2017-10-10
     */
    int insertSelective(DeptmonthsumVo record);

    /**
     *
     * @mbggenerated 2017-10-10
     */
    DeptmonthsumVo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-10-10
     */
    int updateByPrimaryKeySelective(DeptmonthsumVo record);

    /**
     *
     * @mbggenerated 2017-10-10
     */
    int updateByPrimaryKey(DeptmonthsumVo record);
}