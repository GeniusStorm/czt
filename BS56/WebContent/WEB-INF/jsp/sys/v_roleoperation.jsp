<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %><!doctype html>

<%
    String roleid = request.getParameter("roleid"); 
   String sysid = request.getParameter("sysid"); 
    %>
<html>

<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/sys/roleoperation.js"/>"></script>
  <head>
<script type="text/javascript">
  var roleid=<%=roleid%>;
  var sysid=<%=sysid%>;
</script>
  
<style type="text/css">
.box_UL li{list-style-type:none;float:left;margin-right:5px;font-size:13px;}
</style>
  </head>
  
  
  <body >
  <div>
  <ul class="box_UL">
  <li>所属系统：</li>
  <li class="box_LI">
	<div  id="cmbox">
	</div></li>
	<li class="box_LI" style="margin-left:30px;">
	<div>
	<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="saveCheck()">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="checkbox" id="checkall" name="checkall" value="全选" />全选/全不选  &nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	</li>
</ul></div>

  <div id="main" style="width:100%; height:490px; overflow:scroll;">
  <form id="detail-fm" method="post" novalidate  >
  <table class="gridtable" width="100%"  cellspacing="0" align="center">
<tr id="id-header">
 <th align="left" width="15%">父菜单名称</th>
 <th align="left" width="15%">菜单名称</th>
 <th align="left" width="70%">功能点</th>
</tr>
</br>
</table>
</br>
</br>
</form>
  </div>

<div id="loading">
		<div class="inputdiv" >
			<img  src="/BS56/img/loading.gif" style="padding-top: 20px; padding-left:72px;"/><br>
			<h3 style="padding-left: 35px;">&nbsp;&nbsp;&nbsp;&nbsp;数据加载中,请稍候......</h3>
		</div>
	 </div>

  </body>
</html>
