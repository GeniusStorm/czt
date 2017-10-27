<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %><!doctype html>

<html>

<title><c:out value="${titleInfo}"/></title>
<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/sys/basetypeinfo.js"/>"></script>
  <head>
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
			<a href="#"  id= "newBtn" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openNew()">增加</a>
			<a href="#"  id= "editBtn"  class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openEdit()">修改</a>
			<a href="#"  id= "delBtn" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleterow()">删除</a>
			<input name="typecode" id="typecode" class="easyui-combobox"style="width:auto;"  >
		</div>
		</form>
	</div>
	
	<!-- 新增对话框 -->
	<div id="add-dlg" class="easyui-dialog" style="width:550px;height:300px;padding:10px 20px;align:center;"
			 closed="true" buttons="#dlg-buttons"  data-options="modal:true,draggable:false">
		<div class="ftitle"></div>
		<form  id="add-fm" method="post" action="" novalidate  >
			<div class="fitem">
				<table width="100%" border="0" cellpadding="0" cellspacing="8">
     <tr>
    <td >
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
        <tr align="center" >
            
           <td width="5%" height="20" align="left" nowrap>类型选择：</td>
           <td width="14%" height="20" align="left" nowrap>
                <input name="typecode_new" id="typecode_new" class="easyui-combobox"style="width:auto;"  ><br>
                <input name="typeflag" id="typeflag" class="easyui-validatebox" type="hidden"  />
				<input name="bak1" id="bak1" type="hidden"  class="easyui-validatebox"/>
            </td>
           <td width="5%" height="20" align="left" nowrap>&nbsp;</td>
           <td width="14%" height="20" align="left" nowrap>
                &nbsp;
            </td>
       </tr>
        <tr align="center" >
           <td width="14%" height="20" align="left" colspan=4 nowrap>&nbsp;</td>
       </tr>
       
       <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>类型代码：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="typecode"  id="typecode_txt" class="easyui-validatebox"  style="width:auto"  required="true">
            </td>
           <td width="5%" height="20" align="left" nowrap>类型名称：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="typename"  id="typename_txt" class="easyui-validatebox"  style="width:auto"  required="true">
            </td>
       </tr>
       <tr align="center" >
           <td width="14%" height="20" align="left" colspan=4 nowrap>&nbsp;</td>
       </tr>
       <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>类型值：</td>
            <td width="14%" height="20" align="left"  colspan=3 nowrap>
                   <input name="contentlist"  id="contentlist" class="easyui-validatebox"  style="width:100%;"  required="true">
            </td>
       </tr>
    </table>
	</td>
  </tr>
  </table>
				</div>
			<br>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAdd()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#add-dlg').dialog('close')">取消</a>
	</div>
	
	<!-- 修改对话框 -->
	<div id="edit-dlg" class="easyui-dialog" style="width:550px;height:300px;padding:10px 20px;align:center;"  data-options="modal:true,draggable:false"
			 closed="true" buttons="#edit-dlg-buttons">
		<div class="ftitle"></div>
		<form id="edit-fm" method="post"  validate action="${contextPath}/sys/basetypeInfo/doBasetypeinfoUpdate.json" >
			<input type="hidden" id="id" name="id"/>
			<div class="fitem">
				<table width="100%" border="0" cellpadding="0" cellspacing="8">
     <tr>
    <td >
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
       
       <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>类型代码：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="typecode"  id="typecode" class="easyui-textbox"  disabled="disabled" style="width:auto"  required="true">
            </td>
           <td width="5%" height="20" align="left" nowrap>类型名称：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="typename"  id="typename" class="easyui-textbox"  disabled="disabled" style="width:auto"  required="true">
            </td>
       </tr>
       <tr align="center" >
           <td width="14%" height="20" align="left" colspan=4 nowrap>&nbsp;</td>
       </tr>
       <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>类型值：</td>
            <td width="14%" height="20" align="left"  colspan=3 nowrap>
                   <input name="contentlist"  id="contentlist" class="easyui-validatebox"  style="width:370px;"  required="true">
            </td>
       </tr>
    </table>
	</td>
  </tr>
  </table>
			</div>
			<br>
		</form>
	</div>
	<div id="edit-dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveEdit()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#edit-dlg').dialog('close')">取消</a>
	</div>
	
	<!-- 进度条，建议对于耗时长的操作才启用
	<div id="loading">
		<div class="inputdiv" >
			<img  src="/BS56/img/loading.gif" style="padding-top: 20px; padding-left:72px;"/><br>
			<h3 style="padding-left: 35px;">&nbsp;&nbsp;&nbsp;&nbsp;数据上传中,请稍候......</h3>
		</div>
	 </div>
	  -->
	  <c:import url="/WEB-INF/jsp/pub/sessionPage.jsp?paramPage=BaseTypeInfo"></c:import>	
  </body>
</html>
