/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.web.ctrl.wms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ztel.framework.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztel.app.service.wms.ShipOrderLineService;
import com.ztel.app.service.wms.ShipOrderService;
import com.ztel.app.vo.wms.ShipOrderLineVo;
import com.ztel.app.vo.wms.ShipOrderVo;
import com.ztel.framework.util.DateUtil;
import com.ztel.framework.vo.Pagination;
import com.ztel.framework.web.ctrl.BaseCtrl;

/**
 * @author Zeal
 * @since 2017年2月26日
 *订单信息
 */
@Controller
@RequestMapping("/wms/shiporder")
public class ShipOrderCtrl extends BaseCtrl {
	
	private static Logger logger = LogManager.getLogger(ShipOrderCtrl.class);
	
	
	@Autowired
	private ShipOrderService shipOrderService = null;
	
	@Autowired
	private ShipOrderLineService shipOrderLineService = null;
	 
	/**
	 * 订单查询
	 * @param request
	 * @return
	 */
	@RequestMapping("toshiporder")
	public String toshiporder(HttpServletRequest request) {
		//String damagedtype = request.getParameter("damagedtype");//破损类别(10：来烟破损，20：称重异常)
		//request.setAttribute("damagedtype", damagedtype);
		return "/wms/v_shiporder";
	}
	
	/**
	 * 订单分析
	 * @param request
	 * @return
	 */
	@RequestMapping("toshiporderanalyze")
	public String toshiporderanalyze(HttpServletRequest request) {
		//String damagedtype = request.getParameter("damagedtype");//破损类别(10：来烟破损，20：称重异常)
		//request.setAttribute("damagedtype", damagedtype);
		return "/wms/v_shiporderanalyze";
	}
	
	/**
	 * 工商协同：品牌汇总
	 * @param request
	 * @return
	 */
	@RequestMapping("toshiporderbrandreport")
	public String toshiporderbrandreport(HttpServletRequest request) {
		//String damagedtype = request.getParameter("damagedtype");//破损类别(10：来烟破损，20：称重异常)
		//request.setAttribute("damagedtype", damagedtype);
		return "/wms/v_shiporderbrandreport";
	}
	
	/**
	 * 工商协同：销量汇总
	 * @param request
	 * @return
	 */
	@RequestMapping("toshiporderbrandsalereport")
	public String toshiporderbrandsalereport(HttpServletRequest request) {
		//String damagedtype = request.getParameter("damagedtype");//破损类别(10：来烟破损，20：称重异常)
		//request.setAttribute("damagedtype", damagedtype);
		return "/wms/v_shiporderbrandsalereport";
	}
	
	/**
	 * 订单查询，带翻页
	 * @param shipOrderVo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="getShiporderPageList")
	 @ResponseBody
	 public Map<String, Object> getShiporderPageList(ShipOrderVo shipOrderVo, HttpServletRequest request) throws Exception{
		 Map<String, Object> result=new HashMap<String, Object>();  
		 
		 String keyword = shipOrderVo.getKeywd();
		//判断keyword是否是数字
		 if(keyword!=null&&!keyword.equals("")&&StringUtils.isNumeric(keyword)){//是数字
			 shipOrderVo.setKeywdnumber(keyword);
			 shipOrderVo.setKeywd("");
		 }
		 String searchtime = request.getParameter("searchtime");
		 if(searchtime==null)searchtime=DateUtil.getyyyy_mm_dd();
		 //if(searchtime==null)searchtime="2017-02-01";
		 String searchtime2 = request.getParameter("searchtime2");
		 if(searchtime2==null)searchtime2=DateUtil.getyyyy_mm_dd();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		 if(searchtime!=null&&!searchtime.equals("")){
				Date searchtimeD = sdf.parse(searchtime);
				Date searchtime2D = sdf.parse(searchtime2);
				shipOrderVo.setBegintime(searchtimeD);
				shipOrderVo.setEndtime(searchtime2D);
		 }
		 String searchitemid = request.getParameter("searchitemid");//品牌
		 if(searchitemid!=null&&!searchitemid.equals(""))
			 shipOrderVo.setItemid(searchitemid);
		 
		Pagination<?> page = this.getPagination(request);
		if (shipOrderVo!=null) {
			 page.setParam(shipOrderVo);
		}
		List<ShipOrderVo> shipOrderVoList = new ArrayList<ShipOrderVo>();
		shipOrderVoList = shipOrderService.selectShiporderPageList(page);
		
		 result.put("rows",shipOrderVoList);  
		 result.put("total",page.getTotalCount());  
		 
		return result;
	}

	/**
	 * 获取订单明细列表
	 * @param outBoundVo 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="getShiporderAnalyzeList")
	 @ResponseBody
	 public List<ShipOrderVo> getShiporderAnalyzeList(HttpServletRequest request) throws Exception{
		 List<ShipOrderVo> result=new ArrayList<ShipOrderVo>(); 
		 ShipOrderVo shipOrderVo = new ShipOrderVo();
		 
		 String searchtime = request.getParameter("searchtime");
		 if(searchtime==null)searchtime=DateUtil.getyyyy_mm_dd();
		 String searchtime2 = request.getParameter("searchtime2");
		 if(searchtime2==null)searchtime2=DateUtil.getyyyy_mm_dd();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		 if(searchtime!=null&&!searchtime.equals("")){
				Date searchtimeD = sdf.parse(searchtime);
				Date searchtime2D = sdf.parse(searchtime2);
				shipOrderVo.setBegintime(searchtimeD);
				shipOrderVo.setEndtime(searchtime2D);
		 }
		 
		// shipOrderVo.setOrderdate(orderdate);
		 result = shipOrderService.selectShiporderAnalyzeList(shipOrderVo);
		return result;
	}
	
	/**
	 * 获取主键获取主订单
	 * @param outBoundVo 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="getShiporderByNo")
	 @ResponseBody
	 public ShipOrderVo getShiporderByNo(HttpServletRequest request) throws Exception{
		 String orderNo = request.getParameter("orderNo");//订单号
		 ShipOrderVo result = shipOrderService.getShipOrderByOrderNo(orderNo);
		return result;
	}
	
	 
		 /**
			 * 获取订单明细列表
			 * @param outBoundVo 
			 * @param request
			 * @return
			 * @throws Exception
			 */
			@RequestMapping(value="getShiporderlineByNo")
			 @ResponseBody
			 public List<ShipOrderLineVo> getShiporderline(HttpServletRequest request) throws Exception{
				 List<ShipOrderLineVo> result=new ArrayList<ShipOrderLineVo>(); 
				 String orderNo = request.getParameter("orderNo");//订单号
				// shipOrderVo.setOrderdate(orderdate);
				 result = shipOrderLineService.getShipOrderLineByOrderNo(orderNo);
				return result;
			}
			
			 /**
			 * 工商协同：品牌汇总列表
			 * @param outBoundVo 
			 * @param request
			 * @return
			 * @throws Exception
			 */
			@RequestMapping(value="getShiporderBrandReport")
			 @ResponseBody
			 public List<ShipOrderLineVo> getShiporderBrandReport(HttpServletRequest request) throws Exception{
				 List<ShipOrderLineVo> result=new ArrayList<ShipOrderLineVo>(); 
				 String orderdate = request.getParameter("orderdate");//订单号
				 if(orderdate==null||orderdate.equals(""))orderdate=DateUtil.getyyyy_mm_dd();
				// shipOrderVo.setOrderdate(orderdate);
				 result = shipOrderLineService.getShiporderBrandReport(orderdate);
				return result;
			}
			
			/**
			 * 工商协同：品牌销售汇总列表
			 * @param orderdatestr
			 * @return
			 */
			@RequestMapping(value="getShiporderBrandSaleReport")
			 @ResponseBody
			public List<ShipOrderVo> getShiporderBrandSaleReport(HttpServletRequest request){
				List<ShipOrderVo> resultList = new ArrayList<ShipOrderVo>();
				ShipOrderVo shipOrderVo = new ShipOrderVo();
				
				try{
					
				String searchtime = request.getParameter("searchtime");
				 if(searchtime==null)searchtime=DateUtil.getyyyy_mm_dd();
				 String searchtime2 = request.getParameter("searchtime2");
				 if(searchtime2==null)searchtime2=DateUtil.getyyyy_mm_dd();
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				 if(searchtime!=null&&!searchtime.equals("")){
						Date searchtimeD = sdf.parse(searchtime);
						Date searchtime2D = sdf.parse(searchtime2);
						shipOrderVo.setBegintime(searchtimeD);
						shipOrderVo.setEndtime(searchtime2D);
				 }
				 String searchitemid = request.getParameter("searchitemid");
				 if(searchitemid==null||searchitemid.equals("")) searchitemid = "0";
				  shipOrderVo.setItemid(searchitemid);
					 
				 resultList = shipOrderService.selectShiporderBrandSaleReport(shipOrderVo);
				}catch(Exception e){
					e.printStackTrace();
				}
				return resultList;
			}

			
}
