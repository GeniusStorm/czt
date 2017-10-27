package com.ztel.app.service.cost;

import java.util.List;

import com.ztel.app.vo.cost.EquipmentRepairVo;
import com.ztel.app.vo.cost.EquipmentVo;
import com.ztel.app.vo.sq.IndustrialdriverVo;
import com.ztel.framework.vo.Pagination;

public interface EquipmentRepairService {
	
	public List<EquipmentRepairVo> selectEquipmentRepairPageList(Pagination<?> page);
	
	public int updateEquipmentRepair(EquipmentRepairVo equipmentrepairVo);
	public int delEquipmentRepair(List<Integer> ids);

	public int insertEquipmentRepair(EquipmentRepairVo equipmentrepairVo);
	public List<EquipmentRepairVo> getEquipmentRepairVoListByEquipId(Integer equipid);
}
