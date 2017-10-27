package com.ztel.app.service.wms;

import java.math.BigDecimal;
import java.util.List;

import com.ztel.app.vo.wms.MoveareastockLineVo;
import com.ztel.app.vo.wms.MoveareastockVo;
import com.ztel.framework.vo.Pagination;

public interface MoveareastockService {
	
	/**
	 * 查询
	 * @param page
	 * @return
	 */
	public List<MoveareastockVo>  selectMoveareastockPageList(Pagination<?> page);

	/**
	 * 新增
	 * @param moveareastockVo 主表
	 * @param moveareastockLineVo 明细
	 * @param obid 用于判断是第一次还是第二次插入
	 */
	public void insertMoveareastock(MoveareastockVo moveareastockVo,MoveareastockLineVo moveareastockLineVo,String obid);
	

	/**
	 * 审核
	 * @param moveareastockVo
	 */
	public void doAudit(MoveareastockVo moveareastockVo);
	
	/**
	 * 审核
	 * @param moveareastockVo
	 */
	public void doAuditUniversal(MoveareastockVo moveareastockVo);
	
	/**
	 * 删除
	 * @param id 移库id
	 */
	public void doDel(BigDecimal id);
	
	/**
	 * 检查移库的品牌数量是否合理：需要不大于库存数量
	 * @param cigarettecode 卷烟code
	 * @param areaid 区域id
	 * @param cellno 通道号
	 * @return
	 */
	public BigDecimal doCheckqty(String cigarettecode,String areaid,String cellno);
}
