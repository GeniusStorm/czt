<%@ page language="java" contentType ="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %><!doctype html>

<html>

<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/sys/blockcustomer.js"/>"></script>

<script type="text/javascript">
	var handlername="${userVo.username}";
	var handlerid="${userVo.id}";
</script>

  <head>
  </head>
  
  <body>
  <!-- 查询
  <div id="searchDiv">
    <form id="queryForm" style="margin:10;text-align: center;">
		<table width="100%">
			<tr>
			<td>角色名称：<input class="easyui-textbox"  name="rolename"  data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchUser();},prompt:'请输入角色名称...'" style="width:450px;height:26px;">
            &nbsp;&nbsp;
            <a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td>
			<td align="center"><a href="#" onclick="searchUser();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			</tr>
		</table>
	</form>
	</div>
   -->
	
	
	<!-- datagrid页面列表数据 -->
	<div style="padding:10" id="tabdiv">
		<table id="dataTable"></table>
	</div>
	
	<!-- 查询-->
	<div id="toolbar" style="padding:5px;height:auto;border-top:1px solid #95B8E7">
	<form id="queryForm" style="margin:10;">
		<div style="margin-bottom:5px">
			<a href="#" id="newBtn" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newadd()">增加</a>
			<a href="#" id="editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openEdit()">修改</a>
			<a href="#" id="delBtn" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleterow()">删除</a>
			<a href="#" id="grantBtn" class="easyui-linkbutton" iconCls="icon-myuser" plain="true" onclick="openhandle()">处理</a>
				<a href="#" id="viewBtn" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="openView()">查看</a>
			<input class="easyui-textbox"  name=custcode id=custcode  data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchBlockcustomer();},prompt:'请输入专卖证号、零售户名称或车组名称...'," style="width:350px;height:24px;">
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search" style="height:24px;">清空</a>
		</div>
		</form>
	</div>
	
	<!-- 新增对话框 -->
	<div id="add-dlg" class="easyui-dialog" style="width:825px;height:450px;padding:5px 10px;align:center;"
			 closed="true" buttons="#dlg-buttons"  data-options="modal:true,draggable:false">
		<form  id="add-fm" method="post" action="" novalidate  >
			<div class="fitem">
			<tr>
              <td> <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="">
               <tr><td colspan="6"  class="style2"><font color="blue">新增零售户异动信息</font></td></tr>
               </table></td>
           </tr>  
           
           <tr>
           <td height="120px">
           <div style="WIDTH: 100%; HEIGHT: 120px; BACKGROUND-COLOR: transparent; OVERFLOW: scroll; scrollbar-face-color:#c1d9f5; scrollbar-arrow-color:#ffffff; scrollbar-highlight-color:#ffffff; scrollbar-3dlight-color:#70807d; scrollbar-shadow-color:#ffffff; scrollbar-darkshadow-color:#70807d; scrollbar-track-color:#ffffff">
          <table width="100%" class="gridtable">
          <tr>
			  <td colspan="5">
                     <input class="easyui-textbox"  name="condname" id="condname" data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchBlockcustomer1();},prompt:'请输入专卖证号或零售户名称...'" style="width:450px;height:24px;">
                     </td>
					                      
            </tr>
          </table>
           </div>
           </td>
           </tr>
              
      <tr>
    <td >
	  <table width="90%" border="0" cellpadding="2" cellspacing="2" class="">
              <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>专卖证号：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="custid" id="custid" class="easyui-validatebox tb" style="width:150px" data-options="required:true,validType:'length[1,30]'"><strong><font color="red" >*</font></strong>
            </td>
            <td width="5%" height="20" align="left" nowrap>送货车组：</td>
            <td width="14%" height="20" align="left" nowrap>
                <input name="routecode" id="routecode"  class="easyui-combobox "style="width:100px" >
            </td>
           <td width="5%" height="20" align="left" nowrap>零售户名称：</td>
           <td  width="14%"height="20" align="left" nowrap>
            <input name="custname" id="custname"   class="easyui-validatebox tb" style="width:300px"data-options="" >
           </td>
           </tr>
                <tr align="center" >
           <td width="5%"  height="20" align="left" nowrap>联系人：</td>
           <td width="14%"  height="20" align="left" nowrap>
               <input name="contacter" id="contacter"   class="easyui-validatebox tb"style="width:150px" data-options="" >
           </td>  
           <td width="5%" height="20" align="left" nowrap>联系电话：</td>
            <td width="14%" height="20" align="left" nowrap>
                <input name="telnum" id="telnum" class="easyui-validatebox tb" style="width:100px" data-options="" >
            </td> 
            <td width="5%" height="20" align="left" nowrap>零售户地址：</td>
            <td width="14%" height="20" align="left" nowrap>
                <input name="deliveryaddr" id="deliveryaddr" class="easyui-validatebox tb" style="width:300px" data-options="" >
           </td>
           </tr>
              <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>处理标志：</td>
            <td width="14%" height="20" align="left" nowrap>
               <select name="handleflag" id="handleflag" class="easyui-combobox " style="width:150px;"data-options="" >
                <option value="0" selected>未处理</option>
				<option value="10" >处理</option>
				</select>
				</td> 
				 <td width="5%" height="20" align="left" nowrap>预计时间：</td>
            <td width="14%" height="20" align="left" nowrap>
                  <input name="blocktimerange" id="blocktimerange" class="easyui-datebox"style="width:100px;"data-option="">
           </td>
          <td width="5%" height="20" align="left" nowrap>原因：</td>
           <td width="14%" height="20" align="left" nowrap>
           <select name="reasonid" id="reasonid" class="easyui-combobox" style="width:300px"></select>
            </td>
            </tr>
       <tr align="center">
       <tr>
		  		 	<td width="10%" height="20" align="left" nowrap>备注信息：</td>
		           	<td width="20%" height="20" align="left" colspan="5" nowrap>
		           	<input name="remarks" id="remarks" class="easyui-textbox" data-options="multiline:true,validType:'length[1,200]'"maxlength="200"  style="width:392px" >	
		           	</td>
	           </tr>
      
  	 </table>
		     </td>
	  	   </tr>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveNew()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#add-dlg').dialog('close')">取消</a>
	</div>
	
	
		
	
		<!-- 修改对话框 -->
	<div id="edit-dlg" class="easyui-dialog" style="width:800px;height:400px;padding:10px 20px;align:center;"  data-options="modal:true,draggable:false"
			 closed="true" buttons="#edit-dlg-buttons">
		<div class="ftitle"></div>
		<form id="edit-fm" method="post" action="" novalidate  >
			<div class="fitem"><input type=hidden name=id id=id>
				<table width="100%" border="0" cellpadding="0" cellspacing="6">
            <tr>
              <td> <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="">
              <tr><td colspan="4"  class="style2"><font color="blue">修改零售户异动信息</font></td></tr>
               </table></td>
                       
     <tr>
    <td >
	 <table width="90%" border="0" cellpadding="2" cellspacing="2" class="">
              <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>专卖证号：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="custid" id="custid" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
   
           <td width="5%" height="20" align="left" nowrap>零售户名称：</td>
         <td  width="14%"height="20" align="left" nowrap>
            <input name="custname" id="custname"   class="easyui-validatebox tb" style="width:300px"data-options="" readonly >
           </td>
           </tr>
                <tr align="center" >
           <td width="5%"  height="20" align="left" nowrap>联系人：</td>
         <td width="14%"  height="20" align="left" nowrap>
               <input name="contacter" id="contacter"   class="easyui-validatebox tb"style="width:150px" data-options="" readonly >
           </td>   
       
            <td width="5%" height="20" align="left" nowrap>零售户地址：</td>
          <td width="14%" height="20" align="left" nowrap>
                <input name="deliveryaddr" id="deliveryaddr" class="easyui-validatebox tb" style="width:300px" data-options="" readonly >
           </td>
           </tr>
              <tr align="center" >
           <td width="5%" height="20" align="left" nowrap>联系电话：</td>
          <td width="14%" height="20" align="left" nowrap>
                <input name="telnum" id="telnum" class="easyui-validatebox tb" style="width:100px" data-options="" readonly >
            </td>
    
            <td width="5%" height="20" align="left" nowrap>预计时间：</td>
            <td width="14%" height="20" align="left" nowrap>
                  <input name="blocktimerange" id="blocktimerange" class="easyui-datebox"style="width:auto;"data-option="">
            </td>
            </tr>
            <tr align="center" >
              <td width="5%" height="20" align="left" nowrap>送货车组：</td>
            <td width="14%" height="20" align="left" nowrap>
                <input name="routecode" id="routecode1" class="easyui-combobox " data-options="" >
            </td>
           
           <td width="5%" height="20" align="left" nowrap>处理标志：</td>
            <td width="14%" height="20" align="left" nowrap>
                <select name="handleflag" id=""handleflag"" class="easyui-combobox " style="width:70px;"data-options="" >
                <option value="0" selected>未处理</option>
						<option value="10" >处理</option>
						</select>
       </tr>
       <tr align="center">
       <td width="5%" height="20" align="left" nowrap>原因：</td>
           <td width="14%" height="20" align="left" nowrap>
           <input name="reasonid" id="reasonid1" class="easyui-combobox " style="ime-mode:Disabled"/>
           </td>  
           </tr> 
           <tr align="center">   
           <td width="5%" height="20" align="left" nowrap>备注信息：</td>
		           	<td width="14%" height="20" align="left" colspan="5" nowrap>
		        <input name="remarks" id="remarks" class="easyui-textbox" data-options="multiline:true,validType:'length[1,200]'" maxlength="200"   style="width:392px" >
	           		
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
	
	
	
	<!-- 查看对话框 -->
	<div id="view-dlg" class="easyui-dialog" style="width:600px;height:400px;padding:10px 20px;align:center;"  data-options="modal:true,draggable:false"
			 closed="true" buttons="#view-dlg-buttons">
		<div class="ftitle"></div>
		<form id="view-fm" method="post" action="" novalidate  >
			<div class="fitem">
				<table width="100%" border="0" cellpadding="0" cellspacing="6">
            <tr>
              <td> <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="">
              <tr><td colspan="4"  class="style2"><font color="blue">查看零售户异动信息</font></td></tr>
               </table></td>
           </tr>          
     <tr>
    <td >
    
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" >
              <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>专卖证号：</td>
           <td id="v-custid" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
            </td>
   
           <td width="5%" height="20" align="left" nowrap>零售户名称：</td>
       <td id="v-custname" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
           </td>
           </tr>
                <tr align="center" >
           <td width="5%"  height="20" align="left" nowrap>联系人：</td>
             <td id="v-contacter" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
    
           </td>   
       
            <td width="5%" height="20" align="left" nowrap>零售户地址：</td>
              <td id="v-deliveryaddr" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" >
             
           </td>
           </tr>
              <tr align="center" >
           <td width="5%" height="20" align="left" nowrap>联系电话：</td>
              <td id="v-telnum" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
                
            </td>
    
            <td width="5%" height="20" align="left" nowrap>预计时间：</td>
              <td id="v-blocktimerange" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
              
            </td>
            </tr>
            <tr align="center" >
               <td width="5%" height="20" align="left" nowrap>送货车组：</td>
       <td id="v-routecode" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
           <td width="5%" height="20" align="left" nowrap>处理标志：</td>
              <td id="v-handleflag" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
       </tr>
    
      <tr align="center">
       <td width="5%" height="20" align="left" nowrap>申报人：</td>
             <td id="v-createname" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
           </td>
            <td width="5%"  height="20" align="left" nowrap>处理人员：</td>
             <td id="v-handlename" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
      
	</td>
  </tr>
          <tr align="center">
           <td width="5%" height="20" align="left" nowrap>处理时间：</td>
              <td id="v-handledate" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
              
            </td>
       <td width="5%" height="20" align="left" nowrap>原因：</td>
             <td id="v-reasonname" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
           </td>
            </tr>
              <tr align="center">
       <td width="5%" height="20" align="left" nowrap="">处理情况：</td>
             <td id="v-handlesitu" class="formtd" font style="color:darkblue;"   width="14%" height="20" colspan=5 align="left" >
           </td>
             </tr>
           <tr align="center">
            <td width="5%"  height="20" align="left" nowrap>实际情况：</td>
             <td id="v-actualsitu" class="formtd" font style="color:darkblue;" width="14%" height="20"colspan=5 align="left" >
      
	</td>
  </tr>
           <tr align="center">
            <td width="5%"  height="20" align="left" nowrap>备注信息：</td>
             <td id="v-remarks" class="formtd" align="left" font style="color:darkblue;"  colspan=5 >
      
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
	<div id="view-dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#view-dlg').dialog('close')">关闭</a>
	</div>
	
		<!-- 处理对话框 -->
	<div id="handle-dlg" class="easyui-dialog" style="width:550px;height:480px;padding:10px 20px;align:center;"  data-options="modal:true,draggable:false"
			 closed="true" buttons="#handle-dlg-buttons">
		<div class="ftitle"></div>
		<form id="handle-fm" method="post" action="" novalidate  >
			<div class="fitem"><input type=hidden name=id id=id>
				<table width="100%" border="0" cellpadding="0" cellspacing="6">
            <tr>
              <td> <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="">
              <tr><td colspan="4"  class="style2"><font color="blue">处理零售户异动信息</font></td></tr>
               </table></td>
                       
     <tr>
    <td >
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
              <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>专卖证号：</td>
            <td width="14%" height="20" align="left" nowrap>
                     <input name="custid" id="custid" class="easyui-validatebox tb" data-options=""readonly="readonly">
            </td>
   
           <td width="5%" height="20" align="left" nowrap>零售户名称：</td>
           <td width="14%" height="20" align="left" nowrap>
            <input name="custname" id="custname"   class="easyui-validatebox tb" data-options="" readonly>
           </td>
           </tr>
                <tr align="center" >
           <td width="5%"  height="20" align="left" nowrap>联系人：</td>
           <td width="13%" height="20" align="left" nowrap>
               <input name="contacter" id="contacter"   class="easyui-validatebox tb" data-options="" readonly >
           </td>   
       
            <td width="5%" height="20" align="left" nowrap>零售户地址：</td>
            <td width="14%" height="20" align="left" nowrap>
                <input name="deliveryaddr" id="deliveryaddr" class="easyui-validatebox tb" data-options="" readonly >
           </td>
           </tr>
              <tr align="center" >
           <td width="5%" height="20" align="left" nowrap>联系电话：</td>
            <td width="14%" height="20" align="left" nowrap>
                <input name="telnum" id="telnum1" class="easyui-validatebox tb" data-options="" readonly>
            </td>
     <td width="5%" height="20" align="left" nowrap>原因：</td>
           <td width="14%" height="20" align="left" nowrap>
           <input name="reasonid" id="reasonid2" class="easyui-combobox " style="ime-mode:Disabled"/>
           </td>
           
            </tr>
            <tr align="center" >
              <td width="5%" height="20" align="left" nowrap>申报人：</td>
            <td width="14%" height="20" align="left" nowrap>
                <input name="createname" id="createname" class="easyui-validatebox tb" value="${userVo.username}" data-options="" readonly>
            </td>
           
           <td width="5%" height="20" align="left" nowrap>处理人员：</td>
            <td width="14%" height="20" align="left" nowrap>
              <input name="handlename" id="handlename" class="easyui-textbox tb"value="${userVo.username}" data-options="" readonly>
       </tr>
       <tr align="center">
            <td width="5%" height="20" align="left" nowrap>备注信息：</td>
		           	<td width="14%" height="20" align="left" colspan="5" nowrap>
		        <input name="remarks" id="remarks" class="easyui-textbox" data-options="multiline:true,validType:'length[1,200]'" maxlength="200"    style="width:392px" >
	           		
	</td>
  </tr>
      <tr align="center">
       <td width="5%" height="20" align="left" nowrap>实际情况：</td>
		           	<td width="14%" height="20" align="left" colspan="5" nowrap>
		        <input name="actualsitu" id="actualsitu" class="easyui-textbox" data-options="multiline:true,validType:'length[1,200]'" maxlength="200"    style="width:392px" >
	           		
	</td>
         
  </tr>
      <tr align="center">
       <td width="5%" height="20" align="left" nowrap>处理情况：</td>
		           	<td width="14%" height="20" align="left" colspan="5" nowrap>
		        <input name="handlesitu" id="handlesitu" class="easyui-textbox" data-options="multiline:true,validType:'length[1,200]'" maxlength="200"    style="width:392px" >
	           		
	</td>
  </tr>
  </table>
			</div>
			<br>
		</form>
	</div>
	<div id="handle-dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="handleEdit()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#handle-dlg').dialog('close')">取消</a>
	</div>

	<!-- 进度条，建议对于耗时长的操作才启用
	<div id="loading">
		<div class="inputdiv" >
			<img  src="/BS56/img/loading.gif" style="padding-top: 20px; padding-left:72px;"/><br>
			<h3 style="padding-left: 35px;">&nbsp;&nbsp;&nbsp;&nbsp;数据上传中,请稍候......</h3>
		</div>
	 </div>
	  -->
    <c:import url="/WEB-INF/jsp/pub/sessionPage.jsp?paramPage=Blockcustomer"></c:import>	  
  </body>
</html>
