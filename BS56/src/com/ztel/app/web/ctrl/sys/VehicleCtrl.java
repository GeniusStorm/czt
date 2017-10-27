/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.web.ctrl.sys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import com.fsj.spring.web.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ztel.app.service.sys.OperationlogService;
import com.ztel.app.service.sys.VehicleVoService;
import com.ztel.app.vo.sys.UserVo;
import com.ztel.app.vo.sys.VehicleVo;
import com.ztel.app.vo.wms.CustomerVo;
import com.ztel.framework.vo.Pagination;
import com.ztel.framework.web.ctrl.BaseCtrl;

/**
 * @author SN
 * @since 2017年5月12日
 * 部门参数表
 */
@Controller
@RequestMapping("/sys/vehicle")
public class VehicleCtrl extends BaseCtrl {
	
	private static Logger logger = LogManager.getLogger(VehicleCtrl.class);
	
	//用于初始化数据的时候，进行数据类型转换，String类型转为Date类型
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
	@Autowired
	private VehicleVoService vehicleVoService = null;
	
	@Autowired
	private OperationlogService operationlogService = null;
	
	@RequestMapping("toVehicle")
	public String index(HttpServletRequest request) {
		
		return "/sys/v_vehicle";
	}

	
	/**
	  * 获取车辆信息列表
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="getVehicleVoList")
	 @ResponseBody
	 public  List<VehicleVo> VehicleVo(HttpServletRequest request,VehicleVo vehicleVo)
	 {
		 String vehicles=request.getParameter("vehicles");
		 String vehicleno=request.getParameter("vehicleno");
		// System.out.println("vehicleno=="+vehicleno+"----------vehicles="+vehicles);
		 vehicleVo.setVehicles(vehicles);
		 vehicleVo.setVehicleno(vehicleno);
		 List<VehicleVo> vehicleList=vehicleVoService.getVehicleVoList(vehicleVo);
		 return vehicleList;
				 
	 }
	/**
	  * 获取车辆信息列表-页面
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="getVehicleVoPageList")
	 @ResponseBody
	 public  Map<String, Object> getVehicleVoPageList(VehicleVo vehicleVo,HttpServletRequest request) throws Exception {
		 Pagination<?> page = this.getPagination(request);

		 Map<String, Object> result=new HashMap<String, Object>();  
		
		 if (vehicleVo!=null) {
			 System.out.println("vehicleVo="+vehicleVo.getId()); 
			 page.setParam(vehicleVo);
		}
		 List<VehicleVo> paras = vehicleVoService.getVehicleVoPageList(page);
		 System.out.println(paras.size());
		 int totals=0;
		 //System.out.println(paras.get(0).getParanameE());
		 result.put("rows",paras);  
		 result.put("total",page.getTotalCount());  

		 return result;
	 }
	 
//	 @RequestMapping(value="getVehicleTreeList")
//	 @ResponseBody
//	 public List<HashMap<String, String>> getAllVehicleTree(){
//		 List<HashMap<String, String>> boxList=new ArrayList<>();
//		 boxList=vehicleVoService.getVehicleCombobox();
//		 return boxList;
//	 }
 	
	 /**
	  * 报废车辆
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="dodelVehicleVo",method=RequestMethod.POST)
	 @ResponseBody
	 public   Map<String, Object> deleteVehicle(@RequestParam("id") List<Integer> ids,HttpServletRequest request) throws Exception {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 int total=0;
		 if (ids!=null&&ids.size()>0) {
			 total = ids.size();
		}
		 try {
			 vehicleVoService.delVehicleVo(ids);
			 UserVo userVo = (UserVo)request.getSession().getAttribute("userVo");
			 operationlogService.insertLog(userVo, "/sys/vehicle/dodelVehicleVo", "车辆信息", "报废", "");
			 map.put("msg", "成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  
			map.put("msg", "失败");
		}
		 map.put("total", total);
		 
		 return map;
	 }
    
	 /**
	  * 新增车辆
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="doinsertVehicleVo",method=RequestMethod.POST)
	// @ResponseBody
	 public   void VehicleNew(VehicleVo vehicleVo,HttpServletResponse response,HttpServletRequest request) throws Exception {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 int total=0;
		 
		 //String bdate=request.getParameter("bdate");
		 //System.out.println("buydate===--======"+bdate);
		 try {
			 //SimpleDateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
			 //if(bdate!=null&&!"".equals(bdate)){
			//	 Date date = fmt.parse(bdate);
			//	 vehicleVo.setBuydate(date);
			////	 System.out.println("buydate========="+vehicleVo.getBuydate().toString());
			 //}
			 UserVo userVo = (UserVo)request.getSession().getAttribute("userVo");
			 vehicleVo.setCreateid(userVo.getId());//取session中用户ID
			 vehicleVoService.insertVehicleVo(vehicleVo);
			 operationlogService.insertLog(userVo, "/sys/vehicle/doinsertVehicleVo", "车辆信息", "新增", "");
			 map.put("msg", "成功");
			 total=1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  
			map.put("msg", "失败");
		}
		 map.put("total", total);
		 
		 //直接使用注解@ResponseBody，框架自动返回json串，但是form形式提交的返回json在IE在会出现下载json的提示，所以修改成设置response的形式
		 String result = JSON.toJSONString(map);
		 response.setContentType("text/html;charset=UTF-8");
		 response.getWriter().write(result);  
	 }
	 
	 /**
	  * 修改车辆信息
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="doupdateVehicleVo",method=RequestMethod.POST)
	 //@ResponseBody
	 public   void updateVehicleVo(VehicleVo vehicleVo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 int total=0;
        
		 try {
			 UserVo userVo = (UserVo)request.getSession().getAttribute("userVo");
			 vehicleVo.setCreateid(userVo.getId());//取session中用户ID
			 vehicleVoService.updateVehicleVo(vehicleVo);
			 operationlogService.insertLog(userVo, "/sys/vehicle/doupdateVehicleVo", "车辆信息", "修改", "");
			 map.put("msg", "成功");
			 total=1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  
			map.put("msg", "失败");
		}
		 map.put("total", total);
		 String result = JSON.toJSONString(map);
		 response.setContentType("text/html;charset=UTF-8");
		 response.getWriter().write(result);
		 //return map;
	 }
	 
	 /**
	  * 查看车辆信息
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="doviewVehicleVo",method=RequestMethod.POST)
	 //@ResponseBody
	 public   void doviewVehicleVo(VehicleVo vehicleVo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 int total=0;
        
		 try {
			 vehicleVoService.viewVehicleVo(vehicleVo);
			 map.put("msg", "成功");
			 total=1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  
			map.put("msg", "失败");
		}
		 map.put("total", total);
		 String result = JSON.toJSONString(map);
		 response.setContentType("text/html;charset=UTF-8");
		 response.getWriter().write(result);
		 //return map;
	 }
}
	