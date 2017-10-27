<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<!-- 来烟排队，包括入园、入单、排队、出园 -->
<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/gis/truckseq.js"/>"></script>
  <head>
  <script type="text/javascript">
  var requesttype = "${requesttype}";//请求类型
  var tsid;//id主键
  var groupcode;//装卸组code
</script>
  </head>
  
  <body>
	
	<!-- datagrid页面列表数据 -->
	<div style="padding:10" id="tabdiv">
		<table id="dataTabel"></table>
	</div>
	
	<!-- 查询-->
	<div id="toolbar" style="padding:5px;height:auto;border-top:1px solid #95B8E7">
	<form id="queryForm" style="margin:10;">
		<div style="margin-bottom:5px">
		<a href="#" id="viewBtn" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="viewD()">查看</a>
		<c:if test="${requesttype == 'enterZone'}">  
		<a href="#" id="enterBtn" class="easyui-linkbutton" iconCls="icon-myhouse_go" plain="true" onclick="enterZone()">入园</a>
		</c:if> 
		<c:if test="${requesttype == 'enterBill'}">  
		<a href="#" id="billBtn" class="easyui-linkbutton" iconCls="icon-mybook_edit" plain="true" onclick="openBill()">入单</a>
		</c:if> 
		<c:if test="${requesttype == 'enterQueue'}">  
		<a href="#" id="lineBtn" class="easyui-linkbutton" iconCls="icon-mylorry" plain="true" onclick="editseq()">排队调整</a>
		<a href="#" id="linesaveBtn" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="saveseq()">排队保存</a>
		<a href="#" id="linesaveBtn" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="cancelseq()">取消调整</a>
		</c:if> 
		<c:if test="${requesttype == 'outZone'}">  
		<a href="#" id="outauditBtn" class="easyui-linkbutton" iconCls="icon-mysetting" plain="true" onclick="openAudit()">出园审核</a>
		<a href="#" id="outBtn" class="easyui-linkbutton" iconCls="icon-mycar" plain="true" onclick="outZone()">出园</a>
		</c:if> 
		
		状态：<input name="status" id="status" class="easyui-textbox" style="width:120px" >
			<input class="easyui-textbox"  name="keyword" id="keyword" data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchData();},prompt:'请输入车牌、工业公司名称...'" style="width:320px;height:24px;">
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search" style="height:24px;">清空</a>
		</div>
		</form>
	</div>
	
    <!-- 1、明细查看--------------------------------------------------------------------------------------->
	<div id="add-dlg" class="easyui-dialog" style="width:800px;height:420px;padding:5px 10px;align:center;"
			 closed="true" buttons="#dlg-buttons"  data-options="modal:true,draggable:false">
		<form  id="add-fm" method="post" action="" novalidate  >
			<div id="viewdiv">
			<tr>
			<td>
			<table>
			<tr>
					<td width="5%" height="20" align="left" nowrap>工业公司名称：</td>
		           	<td width="5%" height="20" align="left" nowrap >
		                <input name="companyname" id="companyname" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>车牌：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="vehicleno" id="vehicleno" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
	           		<td width="5%" height="20" align="left" nowrap>司机电话号码：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="telnum" id="telnum" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>	
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>件数：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="qty" id="qty" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>入园时间：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="arrivetime" id="arrivetime" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		  		 	<td width="5%" height="20" align="left" nowrap>开锁时间：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="unlocktime" id="unlocktime" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>	
	           </tr>
				<tr>
		           	<td width="5%"  height="20" align="left" nowrap>交单时间：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="billtime" id="billtime" class="easyui-textbox" style="width:120px" readonly/>
		           </td>  
		           <td width="5%" height="20" align="left" nowrap>开始扫码时间：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="begscantime" id="begscantime" class="easyui-textbox" style="width:180px"  readonly>
		           	</td>
		            <td width="5%" height="20" align="left" nowrap>结束扫码时间：</td>
		           	<td width="5%" height="20" align="left" nowrap >
		                <input name="endscantime" id="endscantime" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>出园时间：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="backtime" id="backtime" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>排队顺序：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="seq" id="seq" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%"  height="20" align="left" nowrap>状态：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="statusname" id="statusname" class="easyui-textbox" style="width:120px" readonly/>
		           </td>  
	           </tr>
	           <tr>
		  		 	
		           	<td width="5%"  height="20" align="left" nowrap>装卸组：</td>
		           	<td width="23%" height="20" align="left" nowrap >
		               <input name="groupcode" id="groupcode" class="easyui-textbox" style="width:120px" readonly/>
		           </td>  
		           <td width="5%" height="20" align="left" nowrap>批次号：</td>
		           	<td width="14%" height="20" align="left" nowrap colspan="3">
		                <input name="batchId" id="batchId" class="easyui-textbox" style="width:180px"  readonly>
		           	</td>
	           </tr>

			</table>
			</td>
			</tr>
			</div>
			<div id="billdiv">
			<tr>
		  		 	<td>
		  		 	<table>
		  		 	<tr>
		  		 	<td width="5%"  height="20" align="left" nowrap>装卸组：</td>
		           	<td width="46%" height="20" align="left" nowrap >
		               <input name="groupcode1" id="groupcode1" class="easyui-textbox" style="width:280px" />
		           </td>  
		  		 	</tr>
		  		 	</table>
		  		 	</td>
		           	
	           </tr>
			</div>
		</form>
	 <div id="dlg-buttons">
	 <a href="#" class="easyui-linkbutton" id="btn-bill" iconCls="icon-ok" onclick="doBill()">入单</a>
	 <a href="#" class="easyui-linkbutton" id="btn-zone" iconCls="icon-ok" onclick="doAudit()">同意出园</a>
		<a href="#" class="easyui-linkbutton" id="btn-done" iconCls="icon-ok" onclick="javascript:$('#add-dlg').dialog('close')">关闭</a>
	</div>
	</div>
	

  </body>
</html>
