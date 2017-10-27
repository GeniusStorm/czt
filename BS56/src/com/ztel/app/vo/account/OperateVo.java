package com.ztel.app.vo.account;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OperateVo {
    /**
     * null
     */
    private BigDecimal id;

    /**
     * 类型 0：新增 10：车组退货  20：暂存  30：组间转货  40暂存送货
     */
    private String ctype;

    /**
     * 创建人id
     */
    private Long createid;

    /**
     * 创建人名称
     */
    private String createname;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 条数
     */
    private BigDecimal quantity;

    /**
     * 订单日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date orderdate;

    /**
     * 核算日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date calcdate;

    /**
     * 订单id(对应t_wms_shiporder的id)
     */
    private String orderno;

    /**
     * 原因id(对应t_account_reasoninfo的id)
     */
    private BigDecimal reasonid;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态：10：新增   20：审核  30：小仓入库 40：出库  50:暂存出库
     */
    private String status;
    
    /**
     * 状态名称：10：新增   20：审核  30：小仓入库 40：出库  50:暂存出库
     */
    private String statusname;

    /**
     * 图片名称
     */
    private String picturename;

    /**
     * 图片地址
     */
    private String pictureaddr;

    /**
     * 审核人id
     */
    private Long auditid;

    /**
     * 审核人名称
     */
    private String auditname;

    /**
     * 审核日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date auditdate;

    /**
     * 审核备注
     */
    private String auditremarks;

    /**
     * 线路code
     */
    private String routecode;

    /**
     * 接收线路code
     */
    private String targetroutecode;

    /**
     * 创建日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdate;

    /**
     * 10:预付或代扣订单   20:刷卡或现金订单
     */
    private String prestatus;
    
    private String begdate;
    private String enddate;
    private String keywd;
    private String reasoncontent;
    
    private String cuscode;
    private String cusname;
    private String prestatuscontent;
    
    private String statuscontent;

    public String getStatuscontent() {
		return statuscontent;
	}

	public void setStatuscontent(String statuscontent) {
		this.statuscontent = statuscontent;
	}

	public String getCuscode() {
		return cuscode;
	}

	public void setCuscode(String cuscode) {
		this.cuscode = cuscode;
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public String getPrestatuscontent() {
		return prestatuscontent;
	}

	public void setPrestatuscontent(String prestatuscontent) {
		this.prestatuscontent = prestatuscontent;
	}

	public String getReasoncontent() {
		return reasoncontent;
	}

	public void setReasoncontent(String reasoncontent) {
		this.reasoncontent = reasoncontent;
	}

	public String getBegdate() {
		return begdate;
	}

	public void setBegdate(String begdate) {
		this.begdate = begdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getKeywd() {
		return keywd;
	}

	public void setKeywd(String keywd) {
		this.keywd = keywd;
	}

	/**
     * null
     * @return ID null
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * null
     * @param id null
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }


    public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public Long getCreateid() {
		return createid;
	}

	public void setCreateid(Long createid) {
		this.createid = createid;
	}

	public String getCreatename() {
		return createname;
	}

	public void setCreatename(String createname) {
		this.createname = createname;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
     * 条数
     * @return QUANTITY 条数
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * 条数
     * @param quantity 条数
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * 订单日期
     * @return ORDERDATE 订单日期
     */
    public Date getOrderdate() {
        return orderdate;
    }

    /**
     * 订单日期
     * @param orderdate 订单日期
     */
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    /**
     * 核算日期
     * @return AUDITDATE 核算日期
     */
    public Date getAuditdate() {
        return auditdate;
    }

    /**
     * 核算日期
     * @param auditdate 核算日期
     */
    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }

    /**
     * 原因id(对应t_account_reasoninfo的id)
     * @return REASONID 原因id(对应t_account_reasoninfo的id)
     */
    public BigDecimal getReasonid() {
        return reasonid;
    }

    /**
     * 原因id(对应t_account_reasoninfo的id)
     * @param reasonid 原因id(对应t_account_reasoninfo的id)
     */
    public void setReasonid(BigDecimal reasonid) {
        this.reasonid = reasonid;
    }

    /**
     * 备注
     * @return REMARKS 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 状态：0：新增   1：审核  2：小仓入库   3：出库  4:暂存出库
     * @return STATUS 状态：0：新增   1：审核  2：小仓入库   3：出库  4:暂存出库
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态：0：新增   1：审核  2：小仓入库   3：出库  4:暂存出库
     * @param status 状态：0：新增   1：审核  2：小仓入库   3：出库  4:暂存出库
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 图片名称
     * @return PICTURENAME 图片名称
     */
    public String getPicturename() {
        return picturename;
    }

    /**
     * 图片名称
     * @param picturename 图片名称
     */
    public void setPicturename(String picturename) {
        this.picturename = picturename == null ? null : picturename.trim();
    }

    /**
     * 图片地址
     * @return PICTUREADDRESS 图片地址
     */
    public String getPictureaddr() {
        return pictureaddr;
    }

    /**
     * 图片地址
     * @param pictureaddress 图片地址
     */
    public void setPictureaddr(String pictureaddr) {
        this.pictureaddr = pictureaddr == null ? null : pictureaddr.trim();
    }

    public Date getCalcdate() {
		return calcdate;
	}

	public void setCalcdate(Date calcdate) {
		this.calcdate = calcdate;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Long getAuditid() {
		return auditid;
	}

	public void setAuditid(Long auditid) {
		this.auditid = auditid;
	}

	public String getAuditname() {
		return auditname;
	}

	public void setAuditname(String auditname) {
		this.auditname = auditname;
	}

	public String getAuditremarks() {
		return auditremarks;
	}

	public void setAuditremarks(String auditremarks) {
		this.auditremarks = auditremarks;
	}

	/**
     * 线路code
     * @return ROUTECODE 线路code
     */
    public String getRoutecode() {
        return routecode;
    }

    /**
     * 线路code
     * @param routecode 线路code
     */
    public void setRoutecode(String routecode) {
        this.routecode = routecode == null ? null : routecode.trim();
    }

    /**
     * 接收线路code
     * @return TARGETROUTECODE 接收线路code
     */
    public String getTargetroutecode() {
        return targetroutecode;
    }

    /**
     * 接收线路code
     * @param targetroutecode 接收线路code
     */
    public void setTargetroutecode(String targetroutecode) {
        this.targetroutecode = targetroutecode == null ? null : targetroutecode.trim();
    }

    public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	/**
     * 10:预付或代扣订单   20:刷卡或现金订单
     * @return PRESTATUS 10:预付或代扣订单   20:刷卡或现金订单
     */
    public String getPrestatus() {
        return prestatus;
    }

    /**
     * 10:预付或代扣订单   20:刷卡或现金订单
     * @param prestatus 10:预付或代扣订单   20:刷卡或现金订单
     */
    public void setPrestatus(String prestatus) {
        this.prestatus = prestatus == null ? null : prestatus.trim();
    }

    /**
     * 状态名称：10：新增   20：审核  30：小仓入库 40：出库  50:暂存出库
     * @return
     */
	public String getStatusname() {
		return statusname;
	}

	/**
	 * 
	 * @param statusname 状态名称：10：新增   20：审核  30：小仓入库 40：出库  50:暂存出库
	 */
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
    
}