/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.web.ctrl.wms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztel.app.service.wms.ItemstockService;
import com.ztel.app.vo.wms.InBoundVo;
import com.ztel.app.vo.wms.ItemVo;
import com.ztel.app.vo.wms.ItemstockLineVo;
import com.ztel.framework.util.FileUtil;
import com.ztel.framework.vo.Pagination;
import com.ztel.framework.web.ctrl.BaseCtrl;

/**
 * 卷烟库存账面量
 * @author lcf
 * @since 2017年9月11日
 */
@Controller
@RequestMapping("/wms/itemstock")
public class ItemstockCtrl extends BaseCtrl {
	
	private static Logger logger = LogManager.getLogger(ItemstockCtrl.class);
	
	@Autowired
	private ItemstockService itemstockService = null;

	/**
	 * 库存账面量
	 * @param request
	 * @return
	 */
	@RequestMapping("toItemstock")
	public String toItemstock(HttpServletRequest request) {
		Date inventortime = new Date();
		String consignsor = request.getParameter("consignsor");
		if(consignsor==null||consignsor.equals("0000")){
			consignsor="";
		}
		List<ItemstockLineVo> itemStockList = itemstockService.getStock(inventortime,consignsor);
		request.setAttribute("itemStockList", itemStockList);
		return "/wms/v_itemstock";
	}
	
	
	/**
	 * 库存账面量详细列表
	 * @param request
	 * @return
	 */
	@RequestMapping("getItemstockList")
	public String getItemstockList(HttpServletRequest request) {
		String consignsor = request.getParameter("consignsor");
		
		Date inventortime = new Date();
		if(consignsor==null||consignsor.equals("0000")){
			consignsor="";
		}
		List<ItemstockLineVo> itemStockList = itemstockService.selectItemstockLineList(inventortime,consignsor);
		request.setAttribute("itemStockList", itemStockList);
		return "/wms/v_itemstockList";
	}


	/**
	 * 库存账面量详细列表
	 * @param request
	 * @return
	 */
	@RequestMapping("doExportItemstockToExcel")
	@ResponseBody
	public void doExportItemstockToExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Date inventortime = new Date();
		String consignsor = request.getParameter("consignsor");
		if(consignsor==null||consignsor.equals("0000")){
			consignsor="";
		}
		ArrayList<ItemstockLineVo> itemStockList =( ArrayList<ItemstockLineVo>) itemstockService.getStock(inventortime,consignsor);

		List<String> needPrintFields=new ArrayList<String>();
	     needPrintFields.add("cigarettename");
	     needPrintFields.add("cigarettecode");
	     needPrintFields.add("inboxqty");
	     needPrintFields.add("outboxqty");
	     needPrintFields.add("boxqty");
	     needPrintFields.add("initemqty");
	     needPrintFields.add("outitemqty");
	     needPrintFields.add("itemqty");
	     
		 List<String> ColumnTitle=new ArrayList<String>();
		 ColumnTitle.add("卷烟名称");
		 ColumnTitle.add("卷烟编码");
		 ColumnTitle.add("入库量(件)");
		 ColumnTitle.add("出库量(件)");
		 ColumnTitle.add("库存量(件)");
		 ColumnTitle.add("入库量(条)");
		 ColumnTitle.add("出库量(条)");
		 ColumnTitle.add("库存量(条)");
		 
		 String sheetname="库存账面量";
		 String title="库存账面量";
			 
		 FileUtil.ExportToExcel(itemStockList,sheetname,title, needPrintFields, ColumnTitle,  response);
		

	}
}
	
    