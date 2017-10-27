package com.ztel.app.web.ctrl.produce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztel.app.service.produce.SortTroughService;
import com.ztel.app.util.Constant;
import com.ztel.app.vo.produce.SortTroughVo;
import com.ztel.app.vo.wms.ATSCellInfoDetailVo;
import com.ztel.app.vo.wms.InventoryLineVo;
import com.ztel.app.vo.wms.StorageAreaInOutVo;
import com.ztel.framework.vo.Pagination;
import com.ztel.framework.web.ctrl.BaseCtrl;
@Controller
@RequestMapping("/produce/sorttrough")
public class SortTroughCtrl extends BaseCtrl {
	
	
	@Autowired
	private SortTroughService sortTroughVoService = null;
	@RequestMapping("")
	public String index(HttpServletRequest request) {
		return "/produce/index";
	}
	@RequestMapping(value="/detail/{type}/{ctype}")
	public String index(HttpServletRequest request,@PathVariable(value="type") String ty,@PathVariable(value="ctype") String cty) {
		request.setAttribute("type", ty);
		request.setAttribute("ctype", cty);
		return "/produce/v_sorttrough";
	}
		
	@RequestMapping("toSorttrough")
	public String index1(HttpServletRequest request) {
			
		return "/produce/v_sorttroughinfo";
	}
	@RequestMapping("getSortTroughinfo")
	 @ResponseBody
	public  Map<String, Object> GetSortTrough(HttpServletRequest request,SortTroughVo vo)
	{
		 Pagination<?> page = this.getPagination(request);

		 Map<String, Object> result=new HashMap<String, Object>();  
		 //System.out.println("------");
		 if (vo!=null) {
			 //System.out.println("roleinfo="+roleinfo.getRolename()+","+roleinfo.getId()); 
			 page.setParam(vo);
		}
		 List<SortTroughVo> paras = sortTroughVoService.getSortTroughPageList(page);
		 result.put("rows",paras);  
		 result.put("total",page.getTotalCount());  

		 return result;
	}
	
	@RequestMapping("UpdateMainssa")
	 @ResponseBody
	public String UpdateMainssa(SortTroughVo vo)
	{
		
		vo.setLastmantissa(vo.getMantissa());
		sortTroughVoService.updateByPrimaryKeySelective(vo);
		return "10";
	}
	
	/**
	  * 获取通道信息列表
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("getSorttroughList")
	 @ResponseBody
	 public  Map<String, Object> getSorttroughList(SortTroughVo sorttroughVo,HttpServletRequest request) throws Exception {
		 Pagination<?> page = this.getPagination(request);
		 Map<String, Object> result=new HashMap<String, Object>();  
		 if (sorttroughVo!=null) {
			 page.setParam(sorttroughVo);
		}
		 List<SortTroughVo> paras = sortTroughVoService.getSorttroughList(sorttroughVo);
		 System.out.println(paras.size());
		 result.put("rows",paras);  
		 result.put("total",page.getTotalCount());  
		 return result;
	 }	
	 
	 /**
	  * 根据查询条件获取通道信息列表
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("selectListByCond")
	 @ResponseBody
	 public  List<SortTroughVo> selectListByCond(HttpServletRequest request) throws Exception {
		 String cigarettecode = request.getParameter("cigarettecode");
		 String troughtype = request.getParameter("troughtype");//类型(分拣通道:10 重力式货架:20 皮带机:30 分拣出口:40 )
		 String keyword = request.getParameter("keyword");
		 
		 SortTroughVo sorttroughVo = new SortTroughVo();
		 if(cigarettecode!=null)sorttroughVo.setCigarettecode(cigarettecode);
		 sorttroughVo.setTroughtype(new BigDecimal(troughtype));
		 if(keyword!=null)sorttroughVo.setKeyword(keyword);
		 List<SortTroughVo> paras = sortTroughVoService.selectListByCond(sorttroughVo);
		 return paras;
	 }	
	 
	 /**
		 * 获分拣通道盘点信息
		 * @param atsCellInfoDetailVo
		 * @param request
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="getSortTroughInfoSummary")
		 @ResponseBody
		 public Map<String, Object> getSortTroughInfoSummary(StorageAreaInOutVo storageAreaInOutVo,HttpServletRequest request) throws Exception{
			 Map<String, Object> result=new HashMap<String, Object>();  
			 
			 //最近一次盘点信息查询条件
//			 InventoryLineVo inventoryLineVo=new InventoryLineVo();
//			 inventoryLineVo.setInventorytype(new BigDecimal(10));
//			 inventoryLineVo.setAreaid(new BigDecimal(Constant.storagearea_sy));
			 
			 //通道尾数查询条件
			 SortTroughVo sortTroughVo=new SortTroughVo();
			 sortTroughVo.setCigarettetype(new BigDecimal(20));
			 sortTroughVo.setTroughtype(new BigDecimal(10));
			 
			 //调拨移库信息
			 //StorageAreaInOutVo storageAreaInOutVo=new StorageAreaInOutVo();
			 storageAreaInOutVo.setAreaid(new BigDecimal(Constant.storagearea_fj));
			 
			 List<SortTroughVo>  troughList=new ArrayList<SortTroughVo>();
			 troughList=sortTroughVoService.getSortTroughSummaryByCond(storageAreaInOutVo, sortTroughVo);
			
			 result.put("rows",troughList);  
			 result.put("total",troughList.size());  
			 
			return result;
		}
		
		/**
		 * 获重力式货架盘点信息
		 * @param atsCellInfoDetailVo
		 * @param request
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="getShelfInfoSummary")
		@ResponseBody
		public Map<String, Object> getShelfInfoSummary(StorageAreaInOutVo storageAreaInOutVo,HttpServletRequest request) throws Exception{
			Map<String, Object> result=new HashMap<String, Object>();  
			
			//最近一次盘点信息查询条件
//			 InventoryLineVo inventoryLineVo=new InventoryLineVo();
//			 inventoryLineVo.setInventorytype(new BigDecimal(10));
//			 inventoryLineVo.setAreaid(new BigDecimal(Constant.storagearea_sy));
			
			//通道尾数查询条件
			SortTroughVo sortTroughVo=new SortTroughVo();
			sortTroughVo.setCigarettetype(new BigDecimal(20));
			sortTroughVo.setTroughtype(new BigDecimal(20));
			
			//调拨移库信息
			//StorageAreaInOutVo storageAreaInOutVo=new StorageAreaInOutVo();
			storageAreaInOutVo.setAreaid(new BigDecimal(Constant.storagearea_zlshj));
			
			List<SortTroughVo>  troughList=new ArrayList<SortTroughVo>();
			troughList=sortTroughVoService.getSortTroughSummaryByCond(storageAreaInOutVo, sortTroughVo);
			
			result.put("rows",troughList);  
			result.put("total",troughList.size());  
			
			return result;
		}
}
