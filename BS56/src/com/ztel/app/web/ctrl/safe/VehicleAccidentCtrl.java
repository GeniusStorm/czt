/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.web.ctrl.safe;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ztel.app.service.safe.VehicleAccidentService;
import com.ztel.app.vo.safe.VehicleAccidentVo;
import com.ztel.app.vo.sys.UserVo;
import com.ztel.framework.vo.Pagination;
import com.ztel.framework.web.ctrl.BaseCtrl;

/**
 * @author sn
 * @since 2017年10月19日
 * 事故管理
 */
@Controller
@RequestMapping("/safe/accident")
public class VehicleAccidentCtrl extends BaseCtrl {
	
	private static Logger logger = LogManager.getLogger(VehicleAccidentCtrl.class);
	
	@Autowired
	private VehicleAccidentService vehicleaccidentService = null;
	
	@RequestMapping("toVehicleaccident")
	public String index(HttpServletRequest request) {
		return "/safe/v_vehicleaccident";
	}
	
	
	/**
	  * 获取事故信息列表
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("getVehicleaccident")
	 @ResponseBody
	 public  Map<String, Object> getAccidentPageList(VehicleAccidentVo vehicleaccidentVo,HttpServletRequest request) throws Exception {
		 Pagination<?> page = this.getPagination(request);

		 Map<String, Object> result=new HashMap<String, Object>();  
		
		 if (vehicleaccidentVo!=null) {
			// System.out.println("vehicleaccidentVo="+vehicleaccidentVo.getId()); 
			 page.setParam(vehicleaccidentVo);
		}
		 
		 List<VehicleAccidentVo> paras = vehicleaccidentService.getAccidentPageList(page);
		 //System.out.println(paras.size());
		 //System.out.println(paras.get(0).getParanameE());
		 result.put("rows",paras);  
		 result.put("total",page.getTotalCount());  

		 return result;
	 }
	
	 /**
	  * 查看零售户信息
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="doviewAccident",method=RequestMethod.POST)
	 //@ResponseBody
	 public   void doviewVehicleAccident(VehicleAccidentVo vehicleaccidentvo,HttpServletResponse response) throws Exception {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 int total=0;
       
		 try {
			 vehicleaccidentService.viewAccident(vehicleaccidentvo);
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
	
    
