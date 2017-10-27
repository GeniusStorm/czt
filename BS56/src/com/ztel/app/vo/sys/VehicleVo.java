package com.ztel.app.vo.sys;

import java.math.BigDecimal;
import java.util.Date;

public class VehicleVo {
    /**
     * 车组id
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String username;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	/**
     * 记录人
     */
    private Long createid;

    /**
     * 记录时间
     */
    private Date createdate;

    /**
     * 备注信息
     */
    private String remarks;
    
    /**
     * 车辆用途
     */
    private String vehicles;
    

    public String getVehicles() {
		return vehicles;
	}

	public void setVehicles(String vehicles) {
		this.vehicles = vehicles;
	}
	private String fueltypecn;
    private String vehiclescn;
	public String getFueltypecn() {
		return fueltypecn;
	}

	public void setFueltypecn(String fueltypecn) {
		this.fueltypecn = fueltypecn;
	}

	public String getVehiclescn() {
		return vehiclescn;
	}

	public void setVehiclescn(String vehiclescn) {
		this.vehiclescn = vehiclescn;
	}
	/**
     * 车牌号码
     */
    private String vehicleno;

    /**
     * 车型
     */
    private String vehicletype;

    /**
     * 存放燃油类型,0为柴油,1为93#汽油,2为97#汽油
     */
    private String fueltype;

    /**
     * 备用字段2 (0:城网   1:农网)
     */
    private String regiontype;

    /**
     * 备用字段2
     */
    private String bak;

    /**
     * 购车日期
     */
    private Date buydate;

    /**
     * 发动机号
     */
    private String enginenum;

    /**
     * 分部负责人
     */
    private Long deptmanager;

    /**
     * 登记注册
     */
    private String register;

    /**
     * 状态('0 报废  10 在用 ) 
     */
    private Short delstatus;

    /**
     * gps编号
     */
    private String gpscode;

    /**
     * 最大装货量
     */
    private BigDecimal maxloadnum;

    /**
     * 最大订单量
     */
    private BigDecimal maxordernum;

    /**
     * 车驾号码
     */
    private String vinno;

    /**
     * 注册载重
     */
    private BigDecimal regload;

    /**
     * 保养里程数，一般为5000
     */
    private BigDecimal maintainmileage;

    /**
     * 车辆图片
     */
    private String vehicleimg;

    /**
     * 轮胎数量
     */
    private BigDecimal tyrenum;
    
    private String delstatuscontent;

    public String getDelstatuscontent() {
		return delstatuscontent;
	}

	public void setDelstatuscontent(String delstatuscontent) {
		this.delstatuscontent = delstatuscontent;
	}

	/**
     * 车组id
     * @return ID 车组id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 车组id
     * @param id 车组id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 记录人
     * @return CREATEID 记录人
     */
    public Long getCreateid() {
        return createid;
    }

    /**
     * 记录人
     * @param createid 记录人
     */
    public void setCreateid(Long createid) {
        this.createid = createid;
    }

    /**
     * 记录时间
     * @return CREATEDATE 记录时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 记录时间
     * @param createdate 记录时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 备注信息
     * @return REMARKS 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注信息
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 车牌号码
     * @return VEHICLENO 车牌号码
     */
    public String getVehicleno() {
        return vehicleno;
    }

    /**
     * 车牌号码
     * @param vehicleno 车牌号码
     */
    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno == null ? null : vehicleno.trim();
    }

    /**
     * 车型
     * @return VEHICLETYPE 车型
     */
    public String getVehicletype() {
        return vehicletype;
    }

    /**
     * 车型
     * @param vehicletype 车型
     */
    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype == null ? null : vehicletype.trim();
    }

    /**
     * 存放燃油类型,0为柴油,1为93#汽油,2为97#汽油
     * @return FUELTYPE 存放燃油类型,0为柴油,1为93#汽油,2为97#汽油
     */
    public String getFueltype() {
        return fueltype;
    }

    /**
     * 存放燃油类型,0为柴油,1为93#汽油,2为97#汽油
     * @param fueltype 存放燃油类型,0为柴油,1为93#汽油,2为97#汽油
     */
    public void setFueltype(String fueltype) {
        this.fueltype = fueltype == null ? null : fueltype.trim();
    }

    /**
     * 备用字段2 (0:城网   1:农网)
     * @return REGIONTYPE 备用字段2 (0:城网   1:农网)
     */
    public String getRegiontype() {
        return regiontype;
    }

    /**
     * 备用字段2 (0:城网   1:农网)
     * @param regiontype 备用字段2 (0:城网   1:农网)
     */
    public void setRegiontype(String regiontype) {
        this.regiontype = regiontype == null ? null : regiontype.trim();
    }

    /**
     * 备用字段2
     * @return BAK 备用字段2
     */
    public String getBak() {
        return bak;
    }

    /**
     * 备用字段2
     * @param bak 备用字段2
     */
    public void setBak(String bak) {
        this.bak = bak == null ? null : bak.trim();
    }

    /**
     * 购车日期
     * @return BUYDATE 购车日期
     */
    public Date getBuydate() {
        return buydate;
    }

    /**
     * 购车日期
     * @param buydate 购车日期
     */
    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }

    /**
     * 发动机号
     * @return ENGINENUM 发动机号
     */
    public String getEnginenum() {
        return enginenum;
    }

    /**
     * 发动机号
     * @param enginenum 发动机号
     */
    public void setEnginenum(String enginenum) {
        this.enginenum = enginenum == null ? null : enginenum.trim();
    }

    /**
     * 分部负责人
     * @return DEPTMANAGER 分部负责人
     */
    public Long getDeptmanager() {
        return deptmanager;
    }

    /**
     * 分部负责人
     * @param deptmanager 分部负责人
     */
    public void setDeptmanager(Long deptmanager) {
        this.deptmanager = deptmanager;
    }

    /**
     * 登记注册
     * @return REGISTER 登记注册
     */
    public String getRegister() {
        return register;
    }

    /**
     * 登记注册
     * @param register 登记注册
     */
    public void setRegister(String register) {
        this.register = register == null ? null : register.trim();
    }

    /**
     * 状态('0 报废  10 在用 ) 
     * @return DELSTATUS 状态('0 报废  10 在用 ) 
     */
    public Short getDelstatus() {
        return delstatus;
    }

    /**
     * 状态('0 报废  10 在用 ) 
     * @param delstatus 状态('0 报废  10 在用 ) 
     */
    public void setDelstatus(Short delstatus) {
        this.delstatus = delstatus;
    }

    /**
     * gps编号
     * @return GPSCODE gps编号
     */
    public String getGpscode() {
        return gpscode;
    }

    /**
     * gps编号
     * @param gpscode gps编号
     */
    public void setGpscode(String gpscode) {
        this.gpscode = gpscode == null ? null : gpscode.trim();
    }

    /**
     * 最大装货量
     * @return MAXLOADNUM 最大装货量
     */
    public BigDecimal getMaxloadnum() {
        return maxloadnum;
    }

    /**
     * 最大装货量
     * @param maxloadnum 最大装货量
     */
    public void setMaxloadnum(BigDecimal maxloadnum) {
        this.maxloadnum = maxloadnum;
    }

    /**
     * 最大订单量
     * @return MAXORDERNUM 最大订单量
     */
    public BigDecimal getMaxordernum() {
        return maxordernum;
    }

    /**
     * 最大订单量
     * @param maxordernum 最大订单量
     */
    public void setMaxordernum(BigDecimal maxordernum) {
        this.maxordernum = maxordernum;
    }

    /**
     * 车驾号码
     * @return VINNO 车驾号码
     */
    public String getVinno() {
        return vinno;
    }

    /**
     * 车驾号码
     * @param vinno 车驾号码
     */
    public void setVinno(String vinno) {
        this.vinno = vinno == null ? null : vinno.trim();
    }

    /**
     * 注册载重
     * @return REGLOAD 注册载重
     */
    public BigDecimal getRegload() {
        return regload;
    }

    /**
     * 注册载重
     * @param regload 注册载重
     */
    public void setRegload(BigDecimal regload) {
        this.regload = regload;
    }

    /**
     * 保养里程数，一般为5000
     * @return MAINTAINMILEAGE 保养里程数，一般为5000
     */
    public BigDecimal getMaintainmileage() {
        return maintainmileage;
    }

    /**
     * 保养里程数，一般为5000
     * @param maintainmileage 保养里程数，一般为5000
     */
    public void setMaintainmileage(BigDecimal maintainmileage) {
        this.maintainmileage = maintainmileage;
    }

    /**
     * 车辆图片
     * @return VEHICLEIMG 车辆图片
     */
    public String getVehicleimg() {
        return vehicleimg;
    }

    /**
     * 车辆图片
     * @param vehicleimg 车辆图片
     */
    public void setVehicleimg(String vehicleimg) {
        this.vehicleimg = vehicleimg == null ? null : vehicleimg.trim();
    }

    /**
     * 轮胎数量
     * @return TYRENUM 轮胎数量
     */
    public BigDecimal getTyrenum() {
        return tyrenum;
    }

    /**
     * 轮胎数量
     * @param tyrenum 轮胎数量
     */
    public void setTyrenum(BigDecimal tyrenum) {
        this.tyrenum = tyrenum;
    }
   
     
}