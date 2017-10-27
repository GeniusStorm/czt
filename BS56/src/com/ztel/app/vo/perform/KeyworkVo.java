package com.ztel.app.vo.perform;

import java.math.BigDecimal;
import java.util.Date;

public class KeyworkVo {
    /**
     * id序号
     */
    private Integer id;

    /**
     * 工作内容
     */
    private String content;

    /**
     * 要求及目标
     */
    private String target;

    /**
     * 完成期限
     */
    private String finishdate;

    /**
     * 过程进度
     */
    private String process;

    /**
     * 权重
     */
    private BigDecimal weight;

    /**
     * 完成情况
     */
    private String finishnote;

    /**
     * 状态  0:新增  10:部长审核  20:总经理审核  30:办公室下发(副部长和部长无修改权限)
     */
    private String status;

    /**
     * 评价
     */
    private String appraise;

    /**
     * 部门id
     */
    private Integer deptid;
    
    private String deptname;

    /**
     * 记录人
     */
    private Long createid;

    /**
     * 记录日期
     */
    private Date createdate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 人员id：记录谁的工作界面
     */
    private Long userid;

    /**
     * 重点工作日期
     */
    private Date workdate;

    /**
     * 考核办法
     */
    private String checkway;

    /**
     * 部门提交协调解决的问题
     */
    private String coordinate;

    /**
     * 指导意见
     */
    private String suggestion;

    /**
     * 自评分
     */
    private BigDecimal selfscore;

    /**
     * 他评分
     */
    private BigDecimal otherscore;

    /**
     * 参与人员
     */
    private String partake;

    /**
     * 下发标志（10：未下发  20：下发）
     */
    private String issueflag;

    /**
     * 上级id
     */
    private Integer fid;

    /**
     * 类型(10:重点工作  20:月度计划调整)
     */
    private String ctype;

    /**
     * 计划完成情况
     */
    private String planfinishnote;

    /**
     * 计划实际完成情况
     */
    private String actualnote;
    
    /**
     * 搜索关键字
     */
    private String keyword;

    /**
     * 状态名称  0:新增  10:部长审核  20:总经理审核  30:办公室下发(副部长和部长无修改权限)
     */
    private String statusname;
    /**
     * 创建人姓名
     */
    private String createname;
    
    //为绩效考核新增时取重点工作和日常工作列表返回实体，添加的部分字段
    private String typename;//类别名称：KPI指标，安全隐患、日常工作、临时性工作(在考核新增时用到)
    private BigDecimal scorevalue;//分值(在考核新增时用到)
    private String note;//加扣分说明
    private String finishdone;//完成情况
    
    /**
     * id序号
     * @return ID id序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * id序号
     * @param id id序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 工作内容
     * @return CONTENT 工作内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 工作内容
     * @param content 工作内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 要求及目标
     * @return TARGET 要求及目标
     */
    public String getTarget() {
        return target;
    }

    /**
     * 要求及目标
     * @param target 要求及目标
     */
    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    /**
     * 完成期限
     * @return FINISHDATE 完成期限
     */
    public String getFinishdate() {
        return finishdate;
    }

    /**
     * 完成期限
     * @param finishdate 完成期限
     */
    public void setFinishdate(String finishdate) {
        this.finishdate = finishdate == null ? null : finishdate.trim();
    }

    /**
     * 过程进度
     * @return PROCESS 过程进度
     */
    public String getProcess() {
        return process;
    }

    /**
     * 过程进度
     * @param process 过程进度
     */
    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    /**
     * 权重
     * @return WEIGHT 权重
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * 权重
     * @param weight 权重
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * 完成情况
     * @return FINISHNOTE 完成情况
     */
    public String getFinishnote() {
        return finishnote;
    }

    /**
     * 完成情况
     * @param finishnote 完成情况
     */
    public void setFinishnote(String finishnote) {
        this.finishnote = finishnote == null ? null : finishnote.trim();
    }

    /**
     * 状态  0:新增  10:部长审核  20:总经理审核  30:办公室下发(副部长和部长无修改权限)
     * @return STATUS 状态  0:新增  10:部长审核  20:总经理审核  30:办公室下发(副部长和部长无修改权限)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态  0:新增  10:部长审核  20:总经理审核  30:办公室下发(副部长和部长无修改权限)
     * @param status 状态  0:新增  10:部长审核  20:总经理审核  30:办公室下发(副部长和部长无修改权限)
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 评价
     * @return APPRAISE 评价
     */
    public String getAppraise() {
        return appraise;
    }

    /**
     * 评价
     * @param appraise 评价
     */
    public void setAppraise(String appraise) {
        this.appraise = appraise == null ? null : appraise.trim();
    }

    /**
     * 部门id
     * @return DEPTID 部门id
     */
    public Integer getDeptid() {
        return deptid;
    }

    /**
     * 部门id
     * @param deptid 部门id
     */
    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
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
     * 记录日期
     * @return CREATEDATE 记录日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 记录日期
     * @param createdate 记录日期
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
     * 人员id：记录谁的工作界面
     * @return USERID 人员id：记录谁的工作界面
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 人员id：记录谁的工作界面
     * @param userid 人员id：记录谁的工作界面
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 重点工作日期
     * @return WORKDATE 重点工作日期
     */
    public Date getWorkdate() {
        return workdate;
    }

    /**
     * 重点工作日期
     * @param workdate 重点工作日期
     */
    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    /**
     * 考核办法
     * @return CHECKWAY 考核办法
     */
    public String getCheckway() {
        return checkway;
    }

    /**
     * 考核办法
     * @param checkway 考核办法
     */
    public void setCheckway(String checkway) {
        this.checkway = checkway == null ? null : checkway.trim();
    }

    /**
     * 部门提交协调解决的问题
     * @return COORDINATE 部门提交协调解决的问题
     */
    public String getCoordinate() {
        return coordinate;
    }

    /**
     * 部门提交协调解决的问题
     * @param coordinate 部门提交协调解决的问题
     */
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }

    /**
     * 指导意见
     * @return SUGGESTION 指导意见
     */
    public String getSuggestion() {
        return suggestion;
    }

    /**
     * 指导意见
     * @param suggestion 指导意见
     */
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

    /**
     * 自评分
     * @return SELFSCORE 自评分
     */
    public BigDecimal getSelfscore() {
        return selfscore;
    }

    /**
     * 自评分
     * @param selfscore 自评分
     */
    public void setSelfscore(BigDecimal selfscore) {
        this.selfscore = selfscore;
    }

    /**
     * 他评分
     * @return OTHERSCORE 他评分
     */
    public BigDecimal getOtherscore() {
        return otherscore;
    }

    /**
     * 他评分
     * @param otherscore 他评分
     */
    public void setOtherscore(BigDecimal otherscore) {
        this.otherscore = otherscore;
    }

    /**
     * 参与人员
     * @return PARTAKE 参与人员
     */
    public String getPartake() {
        return partake;
    }

    /**
     * 参与人员
     * @param partake 参与人员
     */
    public void setPartake(String partake) {
        this.partake = partake == null ? null : partake.trim();
    }

    /**
     * 下发标志（10：未下发  20：下发）
     * @return ISSUEFLAG 下发标志（10：未下发  20：下发）
     */
    public String getIssueflag() {
        return issueflag;
    }

    /**
     * 下发标志（10：未下发  20：下发）
     * @param issueflag 下发标志（10：未下发  20：下发）
     */
    public void setIssueflag(String issueflag) {
        this.issueflag = issueflag == null ? null : issueflag.trim();
    }

    /**
     * 上级id
     * @return FID 上级id
     */
    public Integer getFid() {
        return fid;
    }

    /**
     * 上级id
     * @param fid 上级id
     */
    public void setFid(Integer fid) {
        this.fid = fid;
    }

    /**
     * 类型(10:重点工作  20:月度计划调整)
     * @return CTYPE 类型(10:重点工作  20:月度计划调整)
     */
    public String getCtype() {
        return ctype;
    }

    /**
     * 类型(10:重点工作  20:月度计划调整)
     * @param ctype 类型(10:重点工作  20:月度计划调整)
     */
    public void setCtype(String ctype) {
        this.ctype = ctype == null ? null : ctype.trim();
    }

    /**
     * 计划完成情况
     * @return PLANFINISHNOTE 计划完成情况
     */
    public String getPlanfinishnote() {
        return planfinishnote;
    }

    /**
     * 计划完成情况
     * @param planfinishnote 计划完成情况
     */
    public void setPlanfinishnote(String planfinishnote) {
        this.planfinishnote = planfinishnote == null ? null : planfinishnote.trim();
    }

    /**
     * 计划实际完成情况
     * @return ACTUALNOTE 计划实际完成情况
     */
    public String getActualnote() {
        return actualnote;
    }

    /**
     * 计划实际完成情况
     * @param actualnote 计划实际完成情况
     */
    public void setActualnote(String actualnote) {
        this.actualnote = actualnote == null ? null : actualnote.trim();
    }

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public String getCreatename() {
		return createname;
	}

	public void setCreatename(String createname) {
		this.createname = createname;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public BigDecimal getScorevalue() {
		return scorevalue;
	}

	public void setScorevalue(BigDecimal scorevalue) {
		this.scorevalue = scorevalue;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getFinishdone() {
		return finishdone;
	}

	public void setFinishdone(String finishdone) {
		this.finishdone = finishdone;
	}
	
	
}