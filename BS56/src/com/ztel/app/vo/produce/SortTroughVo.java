package com.ztel.app.vo.produce;

import java.math.BigDecimal;

public class SortTroughVo {
    /**
     * null
     */
    private BigDecimal id;
    private String param;
    
	/**
     * 分拣线
     */
    private String linenum;

    /**
     * 通道编号
     */
    private String troughnum;

    /**
     * 通道描述
     */
    private String troughdesc;

    /**
     * 通道容量2,1条，为2说明有2个同品牌的道
     */
    private BigDecimal actcount;

    /**
     * 通道物理编号
     */
    private BigDecimal machineseq;

    /**
     * 卷烟编码
     */
    private String cigarettecode;

    /**
     * 卷烟名称
     */
    private String cigarettename;

    /**
     * 0:禁用  10:启用
     */
    private String state;
    
   

    /**
     * 尾数
     */
    private BigDecimal mantissa;

    /**
     *  20:标准 88个道  30:异形 120  40:异形烟混合道 6
     */
    private BigDecimal cigarettetype;
    
    /**
     * 20:标准 88个道  30:异形 120  40:异形烟混合道 6
     */
    private String cigarettetypename;

    /**
     * 补货通道,四台分拣柜1,2,3,4    5为混合
     */
    private BigDecimal replenishline;

    /**
     * 上货通道  1上层皮带，2下层皮带
     */
    private BigDecimal transportationline;

    /**
     * 上次尾数
     */
    private BigDecimal lastmantissa;

    /**
     * 类型(分拣通道 10 重力式货架 20 皮带机 30 分拣出口 40 )
     */
    private BigDecimal troughtype;

    /**
     * 组次
     */
    private BigDecimal groupno;

    /**
     * 阈值
     */
    private BigDecimal threshold;

    /**
     * 立库一次出库数量（件）
     */
    private BigDecimal boxcount;
    
    private String keyword;
    
    private BigDecimal inoutqty;
    
    private BigDecimal fillqty;//填报数
    
    private BigDecimal uncigarettetype;
    
    private BigDecimal jtsize;
    
    private String barcode;//件码

    public BigDecimal getJt_size() {
		return jtsize;
	}

	public void setJt_size(BigDecimal jtsize) {
		this.jtsize = jtsize;
	}

	public BigDecimal getUncigarettetype() {
		return uncigarettetype;
	}

	public void setUncigarettetype(BigDecimal uncigarettetype) {
		this.uncigarettetype = uncigarettetype;
	}

	public BigDecimal getFillqty() {
		return fillqty;
	}

	public void setFillqty(BigDecimal fillqty) {
		this.fillqty = fillqty;
	}
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	public BigDecimal getInoutqty() {
		return inoutqty;
	}

	public void setInoutqty(BigDecimal inoutqty) {
		this.inoutqty = inoutqty;
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

    /**
     * 分拣线
     * @return LINENUM 分拣线
     */
    public String getLinenum() {
        return linenum;
    }

    /**
     * 分拣线
     * @param linenum 分拣线
     */
    public void setLinenum(String linenum) {
        this.linenum = linenum == null ? null : linenum.trim();
    }

    /**
     * 通道编号
     * @return TROUGHNUM 通道编号
     */
    public String getTroughnum() {
        return troughnum;
    }

    /**
     * 通道编号
     * @param troughnum 通道编号
     */
    public void setTroughnum(String troughnum) {
        this.troughnum = troughnum == null ? null : troughnum.trim();
    }

    /**
     * 通道描述
     * @return TROUGHDESC 通道描述
     */
    public String getTroughdesc() {
        return troughdesc;
    }

    /**
     * 通道描述
     * @param troughdesc 通道描述
     */
    public void setTroughdesc(String troughdesc) {
        this.troughdesc = troughdesc == null ? null : troughdesc.trim();
    }

    /**
     * 通道容量2,1条，为2说明有2个同品牌的道
     * @return ACTCOUNT 通道容量2,1条，为2说明有2个同品牌的道
     */
    public BigDecimal getActcount() {
        return actcount;
    }

    /**
     * 通道容量2,1条，为2说明有2个同品牌的道
     * @param actcount 通道容量2,1条，为2说明有2个同品牌的道
     */
    public void setActcount(BigDecimal actcount) {
        this.actcount = actcount;
    }

    /**
     * 通道物理编号
     * @return MACHINESEQ 通道物理编号
     */
    public BigDecimal getMachineseq() {
        return machineseq;
    }

    /**
     * 通道物理编号
     * @param machineseq 通道物理编号
     */
    public void setMachineseq(BigDecimal machineseq) {
        this.machineseq = machineseq;
    }

    /**
     * 卷烟编码
     * @return CIGARETTECODE 卷烟编码
     */
    public String getCigarettecode() {
        return cigarettecode;
    }

    /**
     * 卷烟编码
     * @param cigarettecode 卷烟编码
     */
    public void setCigarettecode(String cigarettecode) {
        this.cigarettecode = cigarettecode == null ? null : cigarettecode.trim();
    }

    /**
     * 卷烟名称
     * @return CIGARETTENAME 卷烟名称
     */
    public String getCigarettename() {
        return cigarettename;
    }

    /**
     * 卷烟名称
     * @param cigarettename 卷烟名称
     */
    public void setCigarettename(String cigarettename) {
        this.cigarettename = cigarettename == null ? null : cigarettename.trim();
    }

    /**
     * 0:禁用  10:启用
     * @return STATE 0:禁用  10:启用
     */
    public String getState() {
        return state;
    }

    /**
     * 0:禁用  10:启用
     * @param state 0:禁用  10:启用
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 尾数
     * @return MANTISSA 尾数
     */
    public BigDecimal getMantissa() {
        return mantissa;
    }

    /**
     * 尾数
     * @param mantissa 尾数
     */
    public void setMantissa(BigDecimal mantissa) {
        this.mantissa = mantissa;
    }

    /**
     *  20:标准 88个道  30:异形 120  40:异形烟混合道 6
     * @return CIGARETTETYPE  20:标准 88个道  30:异形 120  40:异形烟混合道 6
     */
    public BigDecimal getCigarettetype() {
        return cigarettetype;
    }

    /**
     *  20:标准 88个道  30:异形 120  40:异形烟混合道 6
     * @param cigarettetype  20:标准 88个道  30:异形 120  40:异形烟混合道 6
     */
    public void setCigarettetype(BigDecimal cigarettetype) {
        this.cigarettetype = cigarettetype;
    }

    /**
     * 补货通道,四台分拣柜1,2,3,4    5为混合
     * @return REPLENISHLINE 补货通道,四台分拣柜1,2,3,4    5为混合
     */
    public BigDecimal getReplenishline() {
        return replenishline;
    }

    /**
     * 补货通道,四台分拣柜1,2,3,4    5为混合
     * @param replenishline 补货通道,四台分拣柜1,2,3,4    5为混合
     */
    public void setReplenishline(BigDecimal replenishline) {
        this.replenishline = replenishline;
    }

    /**
     * 上货通道  1上层皮带，2下层皮带
     * @return TRANSPORTATIONLINE 上货通道  1上层皮带，2下层皮带
     */
    public BigDecimal getTransportationline() {
        return transportationline;
    }

    /**
     * 上货通道  1上层皮带，2下层皮带
     * @param transportationline 上货通道  1上层皮带，2下层皮带
     */
    public void setTransportationline(BigDecimal transportationline) {
        this.transportationline = transportationline;
    }

    /**
     * 上次尾数
     * @return LASTMANTISSA 上次尾数
     */
    public BigDecimal getLastmantissa() {
        return lastmantissa;
    }

    /**
     * 上次尾数
     * @param lastmantissa 上次尾数
     */
    public void setLastmantissa(BigDecimal lastmantissa) {
        this.lastmantissa = lastmantissa;
    }

    /**
     * 类型(分拣通道 10 重力式货架 20 皮带机 30 分拣出口 40 )
     * @return TROUGHTYPE 类型(分拣通道 10 重力式货架 20 皮带机 30 分拣出口 40 )
     */
    public BigDecimal getTroughtype() {
        return troughtype;
    }

    /**
     * 类型(分拣通道 10 重力式货架 20 皮带机 30 分拣出口 40 )
     * @param troughtype 类型(分拣通道 10 重力式货架 20 皮带机 30 分拣出口 40 )
     */
    public void setTroughtype(BigDecimal troughtype) {
        this.troughtype = troughtype;
    }

    /**
     * 组次
     * @return GROUPNO 组次
     */
    public BigDecimal getGroupno() {
        return groupno;
    }

    /**
     * 组次
     * @param groupno 组次
     */
    public void setGroupno(BigDecimal groupno) {
        this.groupno = groupno;
    }

    /**
     * 阈值
     * @return THRESHOLD 阈值
     */
    public BigDecimal getThreshold() {
        return threshold;
    }

    /**
     * 阈值
     * @param threshold 阈值
     */
    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }

    /**
     * 立库一次出库数量（件）
     * @return BOXCOUNT 立库一次出库数量（件）
     */
    public BigDecimal getBoxcount() {
        return boxcount;
    }

    /**
     * 立库一次出库数量（件）
     * @param boxcount 立库一次出库数量（件）
     */
    public void setBoxcount(BigDecimal boxcount) {
        this.boxcount = boxcount;
    }

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * 20:标准 88个道  30:异形 120  40:异形烟混合道 6
	 * @return 20:标准 88个道  30:异形 120  40:异形烟混合道 6
	 */
	public String getCigarettetypename() {
		return cigarettetypename;
	}

	/**
	 * 20:标准 88个道  30:异形 120  40:异形烟混合道 6
	 * @param cigarettetypename 20:标准 88个道  30:异形 120  40:异形烟混合道 6
	 */
	public void setCigarettetypename(String cigarettetypename) {
		this.cigarettetypename = cigarettetypename;
	}

	/**
	 * 件码
	 * @return
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * 件码
	 * @param barcode
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
    
    
}