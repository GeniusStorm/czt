<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %><!doctype html>

<html>
<title><c:out value="${titleInfo}"/></title>
<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/sys/route.js"/>"></script>

  <head>
  </head>
  
  <body>
	
	<!-- datagrid页面列表数据 labelPosition="right"-->
	<div style="padding:10" id="tabdiv">
		<table id="dataTable"></table>
	</div>
	
	<!-- 查询-->
	<div id="toolbar" style="padding:5px;height:auto;border-top:1px solid #95B8E7">
	<form id="queryForm" style="margin:10;">
		<div style="margin-bottom:5px">
			<a href="#" id="newBtn" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newAddRoute()">增加</a>
			<a href="#" id="editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openEdit()">修改</a>
			
			<input id="delstatus" type="radio" name="delstatus"onchange="searchRoutes();"
            class="easyui-validatebox" checked="checked" value="10">启用
            <input id="delstatus" type="radio" name="delstatus" onchange="searchRoutes();"
            class="easyui-validatebox" value="0">停用
            
			<input class="easyui-textbox"  name="routecode"  id="routecode" data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchRoutes();},prompt:'请输入CODE/部门/车牌/司机/收款员/核算员...'" style="width:330px;height:24px;">
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search" style="height:24px;">清空</a>
		</div>
		</form>
	</div>
	
	<!-- 新增对话框 -->
	<div id="add-dlg" class="easyui-dialog" style="width:850px;height:400px;padding:10px 20px;align:center;"
			 closed="true" buttons="#dlg-buttons"  data-options="modal:true,draggable:false">
		<div class="ftitle"></div>
		<form  id="add-fm" method="post" action="" novalidate  enctype="multipart/form-data" >
			<div class="fitem">
    <tr>
  <table width="100%" border="0" cellpadding="0" cellspacing="8">
      <td background="">
            <tr>
              <td> <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="">
               <tr><td colspan="6"  class="style2"><font color="blue">车组信息维护</font></td></tr>
               </table></td>
           </tr>          
     <tr>
    <td >
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
        <tr align="center" >
            
           <td width="5%" height="20" align="left" nowrap>车组CODE：</td>
           <td width="14%" height="20" align="left" nowrap>
                <input name="routecode" id="routecode" class="easyui-validatebox tb" data-options="required:true,validType:'length[2,10]'"><strong><font color="red" >*</font></strong>
           </td>
           <td width="5%"  height="20" align="left" nowrap>车组名称：</td>
           <td width="13%" height="20" align="left" nowrap>
               <input name="routename" id="routename" value="" maxlength="18"  class="easyui-validatebox tb" data-options="validType:'length[1,18]'" style="ime-mode:Disabled"/>
           </td>   
           <td width="5%" height="20" align="left" nowrap>归属部门：</td>
            <td width="14%" height="20" align="left"  nowrap>
                  <input name="deptid" id="deptid" class="easyui-combobox"style="width:auto;"data-option=''>
            </td>
       </tr>
       
       <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>车组类型：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <select name="routetype" id="routetype" class="easyui-combobox">
                   	    <option value="0"  selected>非干线</option>
                   	    <option value="1">干线</option>
					</select>
            </td>
           <td width="5%" height="20" align="left" nowrap>车组网络：</td>
            <td width="14%" height="20" align="left" nowrap>
            
                <select name="areatype" id="areatype" class="easyui-combobox">
				         <option value="1">城网</option>
				         <option value="2">农网</option>
                  </select>
            
            </td>
            <td width="5%" height="20" align="left" nowrap>是否启用：</td>
           <td width="14%" height="20" align="left" nowrap>
	           <input id="delstatus" type="radio" name="delstatus"
	            class="easyui-validatebox" checked="checked" value="10">启用
	            <input id="delstatus" type="radio" name="delstatus" 
	            class="easyui-validatebox" value="0">停用
           </td>

       </tr>
    </table>
    
	
	</td>
  </tr>
  
  <tr>
  <table width="100%" border="0" cellpadding="0" cellspacing="8">
    
     
      <td background="">
            <tr>
              <td> <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="">
               <tr><td colspan="6"  class="style2"><font color="blue">线路挂接信息</font></td></tr>
               </table></td>
           </tr>          
     <tr>
    <td >
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
	  
	      <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>配送车辆：</td>
            <td width="12%" height="20" align="left" nowrap>
            		<input name="vehicleid" id="vehicleid" class="easyui-combobox"style="width:auto;"data-option=''>
           <td width="5%" height="20" align="left" nowrap>司机：</td>
           <td width="14%" height="20" align="left" nowrap>
              		<input name="driverid" id="driverid" class="easyui-combobox"style="width:auto;"data-option=''>
              </td>
	       <td width="5%"  height="20" align="left" nowrap>收款员：</td>
           <td width="13%" height="20" align="left" nowrap>
           			<input name="cashierid" id="cashierid" class="easyui-combobox"style="width:auto;"data-option=''>
           	</td>
       </tr>
	      <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>核算员：</td>
            <td width="12%" height="20" align="left" nowrap>
            		<input name="calcid" id="calcid" class="easyui-combobox"style="width:auto;"data-option=''>
           <td width="5%" height="20" align="left" nowrap>GIS区域：</td>
           <td width="14%" height="20" align="left" nowrap>
              		<input name="gisarea" id="gisarea" class="easyui-combobox"style="width:auto;"data-option=''>
              </td>
	       <td width="5%"  height="20" align="left" nowrap>暂存仓库：</td>
           <td width="13%" height="20" align="left" nowrap>
           			<input name="warehouse" id="warehouse" class="easyui-combobox"style="width:auto;"data-option=''>
           	</td>
       </tr>
       
    </table>
    
	
	</td>
  </tr>
  </table>
  </tr>
  </table>
  </tr>
			</div>
			<br>
		</form>
	</div>
	</table></td></tr></table></tr></div></form></div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAdd()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#add-dlg').dialog('close');$('#add-fm').form('clear');">取消</a>
	</div>
	<!-- 修改对话框 -->
	<div id="edit-dlg" class="easyui-dialog" style="width:850px;height:400px;padding:10px 20px;align:center;" closed="true" buttons="#dlg-buttons"  data-options="modal:true,draggable:false">
		<div class="ftitle"></div>
		<form  id="edit-fm" method="post" action="" novalidate  enctype="multipart/form-data" >
		<div class="fitem">
    <tr>
  <table width="100%" border="0" cellpadding="0" cellspacing="8">
      <td background="">
            <tr>
              <td> <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="">
               <tr><td colspan="6"  class="style2"><font color="blue">车组信息维护</font></td></tr>
               </table></td>
           </tr>          
     <tr>
    <td >
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
        <tr align="center" >
            
           <td width="5%" height="20" align="left" nowrap>车组CODE：</td>
           <td width="14%" height="20" align="left" nowrap>
                <input name="routecode" id="routecode" class="easyui-validatebox tb" data-options="required:true,validType:'length[2,10]'"><strong><font color="red" >*</font></strong>
                <input type=hidden name=routeid id=routeid>
           </td>
           <td width="5%"  height="20" align="left" nowrap>车组名称：</td>
           <td width="13%" height="20" align="left" nowrap>
               <input name="routename" id="routename" value="" maxlength="18"  class="easyui-validatebox tb" data-options="validType:'length[1,18]'" style="ime-mode:Disabled"/>
           </td>   
           <td width="5%" height="20" align="left" nowrap>归属部门：</td>
            <td width="14%" height="20" align="left"  nowrap>
                  <input name="deptid" id="deptid1" class="easyui-combobox"style="width:auto;"data-option=''>
            </td>
       </tr>
       
       <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>车组类型：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <select name="routetype" id="routetype" class="easyui-combobox">
                   	    <option value="0" >非干线</option>
                   	    <option value="1">干线</option>
					</select>
            </td>
           <td width="5%" height="20" align="left" nowrap>车组网络：</td>
            <td width="14%" height="20" align="left" nowrap>
            
                <select name="areatype" id="areatype" class="easyui-combobox">
				         <option value="1">城网</option>
				         <option value="2">农网</option>
                  </select>
            
            </td>
            <td width="5%" height="20" align="left" nowrap>是否启用：</td>
           <td width="14%" height="20" align="left" nowrap>
	           <input id="delstatus" type="radio" name="delstatus"
	            class="easyui-validatebox" value="10">启用
	            <input id="delstatus" type="radio" name="delstatus" 
	            class="easyui-validatebox" value="0">停用
           </td>

       </tr>
    </table>
    
	
	</td>
  </tr>
  
  <tr>
  <table width="100%" border="0" cellpadding="0" cellspacing="8">
    
     
      <td background="">
            <tr>
              <td> <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="">
               <tr><td colspan="6"  class="style2"><font color="blue">线路挂接信息</font></td></tr>
               </table></td>
           </tr>          
     <tr>
    <td >
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
	  
	      <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>配送车辆：</td>
            <td width="12%" height="20" align="left" nowrap>
            		<input name="vehicleid" id="vehicleid1" class="easyui-combobox"style="width:auto;"data-option=''>
           <td width="5%" height="20" align="left" nowrap>司机：</td>
           <td width="14%" height="20" align="left" nowrap>
              		<input name="driverid" id="driverid1" class="easyui-combobox"style="width:auto;"data-option=''>
              </td>
	       <td width="5%"  height="20" align="left" nowrap>收款员：</td>
           <td width="13%" height="20" align="left" nowrap>
           			<input name="cashierid" id="cashierid1" class="easyui-combobox"style="width:auto;"data-option=''>
           	</td>
       </tr>
	      <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>核算员：</td>
            <td width="12%" height="20" align="left" nowrap>
            		<input name="calcid" id="calcid1" class="easyui-combobox"style="width:auto;"data-option=''>
           <td width="5%" height="20" align="left" nowrap>GIS区域：</td>
           <td width="14%" height="20" align="left" nowrap>
              		<input name="gisarea" id="gisarea1" class="easyui-combobox"style="width:auto;"data-option=''>
              </td>
	       <td width="5%"  height="20" align="left" nowrap>暂存仓库：</td>
           <td width="13%" height="20" align="left" nowrap>
           			<input name="warehouse" id="warehouse1" class="easyui-combobox"style="width:auto;"data-option=''>
           	</td>
       </tr>
       
    </table>
    
	
	</td>
  </tr>
  </table>
  </tr>
  </table>
  </tr>
			</div>
			<br>
		</form>
	</div>
	</table></td></tr></table></tr></div></form></div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveEdit()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#edit-dlg').dialog('close');$('#edit-fm').form('clear');">取消</a>
	</div>
	
	<!-- 授权对话框 -->
	<div id="grant-dlg" class="easyui-dialog" style="width:450px;padding:10px 20px;align:center;"  data-options="modal:true,draggable:false"
			 closed="true" buttons="#grant-dlg-buttons">
		<div class="ftitle"></div>
		<form id="grant-fm" method="post"  validate action="" >
			<input type="hidden" id="id" name="id"/>
			<div class="fitem">
    <tr>
  <table width="100%" border="0" cellpadding="0" cellspacing="8">
     <tr>
    <td >
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
        <tr align="center" >
            <input type=hidden name=userid id=userid>
           <td width="5%" height="20" align="left" nowrap>用户工号：</td>
           <td id="grantusercode" width="14%" height="20" align="left" nowrap>
           </td>
           <td width="5%"  height="20" align="left" nowrap>用户姓名：</td>
           <td id="grantusername" width="14%" height="20" align="left" nowrap>
           </td>   
       </tr>
        <tr align="center" >
            
           <td width="5%" height="20" align="left" nowrap>用户部门：</td>
           <td id="deptname" width="14%" height="20" align="left" nowrap>
                
           </td>
           <td width="5%"  height="20" align="left" nowrap>用户岗位：</td>
           <td id="postname" width="14%" height="20" align="left" nowrap>
           </td>   
       </tr>
        <tr align="center" >
            
           <td width="5%" height="20" align="left" nowrap>授权角色：</td>
           <td width="14%" height="20" align="left" colspan=3 nowrap>
                <input name="roleid" id="roleid2" class="easyui-combobox"style="width:auto;"data-option=''>
           </td>
       </tr>
    </table>
			</div><br>
			
		</form>
	</div>
	<div id="grant-dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveGrant()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#grant-dlg').dialog('close')">取消</a>
	</div>
	
	<!-- 进度条，建议对于耗时长的操作才启用
	<div id="loading">
		<div class="inputdiv" >
			<img  src="/BS56/img/loading.gif" style="padding-top: 20px; padding-left:72px;"/><br>
			<h3 style="padding-left: 35px;">&nbsp;&nbsp;&nbsp;&nbsp;数据上传中,请稍候......</h3>
		</div>
	 </div>
	  -->
	  <c:import url="/WEB-INF/jsp/pub/sessionPage.jsp?paramPage=Route"></c:import>	
  </body>
</html>
