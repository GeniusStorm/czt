<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %><!doctype html>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<html>

<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/safe/dangerrectify.js"/>"></script>
 <script type="text/javascript">
	var rectifyname="${userVo.username}";
	var rectifyid="${userVo.id}";
</script>
  </head>
  
  <body>
	<!-- datagrid页面列表数据 -->
	<div style="padding:10" id="tabdiv">
		<table id="dataTable"></table>
	</div>

	<!-- 查询-->
	<div id="toolbar" style="padding:5px;height:auto;border-top:1px solid #95B8E7">
	<form id="queryForm" style="margin:10;">
		<div style="margin-bottom:5px">
		<a href="#" id="grantBtn" class="easyui-linkbutton" iconCls="icon-myuser" plain="true" onclick="openhandle()">处理</a>
		<a href="#" id="editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openEdit()">修改</a>
			<a href="#" id="delBtn" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleterow()">删除</a>
		    <a href="#" id="viewBtn" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="openView()">查看</a>
		排除状态：<select name="status" id="status" class="easyui-combobox" style="width:70px;" data-option='selected:true;'>
			<option value="20" selected>全部</option>
			<option value="10" >已排除</option>
			<option value="0">未排除</option> 
			</select>  
			   隐患类别：<input class="easyui-combobox" name="ctype" id="ctype" style="width:150px;" data-options="">
			<input class="easyui-textbox"  name="dangercontent"  data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchDangerrectify();},prompt:'请输入隐患内容...'" style="width:350px;height:24px;">
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search" style="height:24px;">清空</a>
		</div>
		</form>
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
              <tr><td colspan="4"  class="style2"><font color="blue">修改隐患整改信息</font></td></tr>
               </table></td>
                       
    <tr>
    <td >
    
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" >
              <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>记录人：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="createname" id="createname" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
             <td width="5%" height="20" align="left" nowrap>核实人员：</td>
           <td width="14%" height="20" align="left" nowrap>
                   <input name="verifyname" id="verifyname" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
              </tr>
            <tr align="center">
            <td width="5%" height="20" align="left" nowrap>检查人员：</td>
       <td width="14%" height="20" align="left" nowrap>
                   <input name="checkid" id="checkid" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
          
            <td width="5%" height="20" align="left" nowrap>整改记录人：</td>
           <td width="14%" height="20" align="left" nowrap>
                   <input name="rectifyname" id="rectifyname" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
              </tr>
            <tr align="center">
         <td width="5%" height="20" align="left" nowrap>隐患日期：</td>
           <td width="14%" height="20" align="left" nowrap>
                   <input  name="dangerdate" id="dangerdate"  class="easyui-datebox" style="width:150px" data-options="" readonly>
            </td>
             <td width="5%" height="20" align="left" nowrap>核实日期：</td>
           <td width="14%" height="20" align="left" nowrap>
                   <input name="verifydate" id="verifydate" class="easyui-datebox" style="width:150px" data-options="" readonly>
            </td>
             </tr>
                <tr align="center" >
           <td width="5%"  height="20" align="left" nowrap>隐患类别：</td>
           <td width="14%" height="20" align="left" nowrap>
                   <input name="ctype" id="ctype" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td> 
            <td width="5%" height="20" align="left" nowrap>隐患核实：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="dangerstatus" id="dangerstatus" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
              </tr>
            <tr align="center">
               <td width="5%" height="20" align="left" nowrap>整改部门：</td>
               <td width="14%" height="20" align="left" nowrap>
                   <input name="deptname" id="deptname" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
           <td width="5%" height="20" align="left" nowrap>隐患排除：</td>
            <td width="14%" height="20" align="left" nowrap>
            <select name="status" id="status1" class="easyui-combobox" style="width:100px;" data-option="selected:true;">
			<option value="10" selected>已排除</option>
			<option value="0">未排除</option> 
			</select>  
               <!--  <select name="status1" id="status1" class="easyui-combobox " style="width:100px"data-options="selected:true" >
                <option value="10" selected>已排除</option>
						<option value="0" >未排除</option>
						</select>  --> 
						</td>
  </tr>
                <tr align="center" >
                <td width="5%" height="20" align="left" nowrap>隐患内容：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="dangercontent" id="dangercontent" class="easyui-textbox" colspan=10 data-options="multiline:true,validType:'length[1,200]'" maxlength="200"  style="width:200px" readonly>
            </td>  
            <td width="5%"  height="20" align="left" nowrap>整改项目要求及期限：</td>
            	<td width="14%" height="30" align="left" colspan="5" nowrap>
		        <input name="demands" id="demands" class="easyui-textbox" colspan=10 data-options="multiline:true,validType:'length[1,200]'" maxlength="200"   style="width:200px" >
	           		
	</td>

  </tr>
              <tr align="center">
       <td width="5%" height="20" align="left" nowrap="">整改内容：</td>
       	<td width="14%" height="30" align="left" colspan="5" nowrap>
		        <input name="rectifynote" id="rectifynote" class="easyui-textbox" colspan=10 data-options="multiline:true,validType:'length[1,200]'" maxlength="200"   style="width:200px" >
	           		
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
	<!-- 处理对话框 -->
	<div id="handle-dlg" class="easyui-dialog"
		style="width: 680px; height: 500px; padding: 10px 20px; align: center;"
		data-options="modal:true,draggable:false" closed="true"
		buttons="#handle-dlg-buttons">
		<div class="ftitle"></div>
		<form id="handle-fm" method="post" action="" novalidate>
			<div class="fitem">
				<input type=hidden name=id id=id>
				<table width="100%" border="0" cellpadding="0" cellspacing="6">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="">
								<tr>
									<td colspan="4" class="style2"><font color="blue">处理隐患整改信息</font></td>
								</tr>
							</table>
						</td>

					</tr>
				</table>
				<table width="100%" border="0" cellpadding="2" cellspacing="2"
					class="">
					 <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>记录人：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="createname" id="createname" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
             <td width="5%" height="20" align="left" nowrap>核实人员：</td>
           <td width="14%" height="20" align="left" nowrap>
                   <input name="verifyname" id="verifyname" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
              </tr>
            <tr align="center">
            <td width="5%" height="20" align="left" nowrap>检查人员：</td>
       <td width="14%" height="20" align="left" nowrap>
                   <input name="checkid" id="checkid" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
           <td width="5%" height="20" align="left" nowrap>整改部门：</td>
               <td width="14%" height="20" align="left" nowrap>
                   <input name="deptname" id="deptname" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
           
              </tr>
            <tr align="center">
         <td width="5%" height="20" align="left" nowrap>隐患日期：</td>
           <td width="14%" height="20" align="left" nowrap>
                   <input  name="dangerdate" id="dangerdate"  class="easyui-datebox" style="width:150px" data-options="" readonly>
            </td>
             <td width="5%" height="20" align="left" nowrap>核实日期：</td>
           <td width="14%" height="20" align="left" nowrap>
                   <input name="verifydate" id="verifydate" class="easyui-datebox" style="width:150px" data-options="" readonly>
            </td>
             </tr>
                <tr align="center" >
           <td width="5%"  height="20" align="left" nowrap>隐患类别：</td>
           <td width="14%" height="20" align="left" nowrap>
                   <input name="ctype" id="ctype" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td> 
            <td width="5%" height="20" align="left" nowrap>隐患核实：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="dangerstatus" id="dangerstatus" class="easyui-validatebox tb" style="width:150px" data-options="" readonly>
            </td>
              </tr>
            <tr align="center">
            <td width="5%" height="20" align="left" nowrap>隐患内容：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="dangercontent" id="dangercontent" class="easyui-textbox" colspan=10 data-options="multiline:true,validType:'length[1,200]'" maxlength="200"  style="width:200px" readonly>
            </td>  
             <td width="5%" height="20" align="left" nowrap>隐患排除：</td>
            <td width="14%" height="20" align="left" nowrap>
                <select name="status" id="status" class="easyui-combobox " style="width:150px;"data-options="" >
								<option value="10"selected>已排除</option>
								<option value="0">未排除</option>
						</select>
						</td>  
          
  </tr>
                <tr align="center" >
                
            <td width="5%"  height="20" align="left" nowrap>整改项目要求及期限：</td>
            	<td width="14%" height="30" align="left" colspan="5" nowrap>
		        <input name="demands" id="demands" class="easyui-textbox" colspan=10 data-options="multiline:true,validType:'length[1,200]'" maxlength="200"   style="width:480px" >
	           		
	</td>

  </tr>
  <tr align="center" >
 <!--   <td width="5%" height="20" align="left" nowrap>整改记录人：</td>
           <td width="14%" height="20" align="left" nowrap>             
             <input name="rectifyname" id="rectifyname" class="easyui-validatebox tb" value="${userVo.username}" style="width:150px" data-options="" >
            </td>--> 
   
				
       <td width="5%" height="20" align="left" nowrap="">整改内容：</td>
       	<td width="14%" height="30" align="left" colspan="5" nowrap>
		        <input name="rectifynote" id="rectifynote" class="easyui-textbox" colspan=5 data-options="multiline:true,validType:'length[1,200]'" maxlength="200"   style="width:480px" >
	           		
	</td>
             </tr>
				</table>
			</div>
			<br>
		</form>
	</div>
	<div id="handle-dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="handleEdit()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#handle-dlg').dialog('close')">取消</a>
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
              <tr><td colspan="4"  class="style2"><font color="blue">查看隐患记录信息</font></td></tr>
               </table></td>
           </tr>          
     <tr>
    <td >
    
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" >
              <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>记录人：</td>
           <td id="v-createname" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
            </td>
   
           <td width="5%" height="20" align="left" nowrap>隐患日期：</td>
       <td id="v-dangerdate" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
           </td>
           </tr>
                <tr align="center" >
           <td width="5%"  height="20" align="left" nowrap>隐患类别：</td>
             <td id="v-ctype" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
    
           </td>   
        </tr>
                <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>隐患内容：</td>
              <td id="v-dangercontent" class="formtd" font style="color:darkblue;" width="14%" height="20" colspan=5 align="left" >
             
           </td>
           </tr>
              <tr align="center" >
           <td width="5%" height="20" align="left" nowrap>核实人员：</td>
              <td id="v-verifyname" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
                
            </td>
    
            <td width="5%" height="20" align="left" nowrap>隐患核实：</td>
              <td id="v-dangerstatus" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
              
            </td>
            </tr>
            <tr align="center" >
               <td width="5%" height="20" align="left" nowrap>整改部门：</td>
       <td id="v-deptname" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap></td>
           <td width="5%" height="20" align="left" nowrap>检查时间：</td>
              <td id="v-verifydate" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
       </tr>
    
      <tr align="center">
       <td width="5%" height="20" align="left" nowrap>检查人员：</td>
             <td id="v-checkid" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
           </td>
            </tr>
                <tr align="center" >
            <td width="5%"  height="20" align="left" nowrap>整改项目要求及期限：</td>
             <td id="v-demands" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
      
	</td>
  </tr>
          <tr align="center">
           <td width="5%" height="20" align="left" nowrap>整改记录人：</td>
              <td id="v-rectifyname" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
              
            </td>
       <td width="5%" height="20" align="left" nowrap>隐患排除：</td>
             <td id="v-status" class="formtd" font style="color:darkblue;" width="14%" height="20" align="left" nowrap>
           </td>
            </tr>
              <tr align="center">
       <td width="5%" height="20" align="left" nowrap="">整改内容：</td>
             <td id="v-rectifynote" class="formtd" font style="color:darkblue;"   width="14%" height="20" colspan=5 align="left" >
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


  </body>
</html>
