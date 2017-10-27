<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.ztel.app.vo.sys.UserVo"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><c:out value="${titleInfo}"/></title>
    <link href="<spring:url value="/css/main/css/default.css"/>" rel="stylesheet" type="text/css" />
    
    <link rel="stylesheet" type="text/css"  href="<spring:url value="/css/index/top_amazeui.css"/>">
  <link rel="stylesheet" type="text/css"  href="<spring:url value="/css/index/top_style.css"/>">

<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/main/main.js"/>"></script>

	
    <script type="text/javascript">
    var _menus;
    var sysId="${sysid}";//所属系统id
    var roleid = "${userVo.roleid}"; 
    
    $.ajax({ 
	    url: baseURL+'/main/getMainMenu.json?sysid='+sysId+"&roleid=${userVo.roleid}", 
	    type: 'POST', 
	    success: function(data){
			//console.log(data);
			//var result = eval('('+data.rows+')');
	    	var url;
			$(data).each(function(i,val) {
			  _menus=data;
			  InitLeftMenu();
				tabClose();
				tabCloseEven();
				}); 
				
		}
	   });
    
        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }

        

        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })
            
        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
                    if (r) {
                    	//注销session
                        location.href = '${contextPath}/doLoginout';
                    }
                });
            })
        });
		
    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  fit="true"   scroll="no">


<div id="loading-mask" style="position:absolute;top:0px; left:0px; width:100%; height:100%; background:#D2E0F2; z-index:20000">
<div id="pageloading" style="position:absolute; top:50%; left:50%; margin:-120px 0px 0px -120px; text-align:center;  border:2px solid #8DB2E3; width:200px; height:40px;  font-size:14px;padding:10px; font-weight:bold; background:#fff; color:#15428B;"> 
    <img src="<spring:url value="/css/main/images/loading.gif"/>" align="absmiddle" /> 正在加载中,请稍候...</div>
</div>

    <div region="north" style="overflow:hidden;height: 80px;width:100%;background-color:#0AB4E6">
         <div class="am-container-1">
		<div class="left hw-logo">
		    <img class="logo" src="<spring:url value="/img/index/top_CZT.png"/>"></img>
		  <img class="word" src="<spring:url value="/img/index/top_czt-word.png"/>"></img>
    </div>
 			 <div >
		    <div class=" am-topbar-left  am-topbar-center" role="search">
		      <ul class="am-nav am-nav-pills am-topbar-nav hw-menu">
		      <li <c:choose> <c:when test="${sysid== '1'}">  class="hw-menu-active"  </c:when>  <c:otherwise>  class="hw-menu-nonactive"   </c:otherwise> </c:choose>><a href="${contextPath}/main/toMain?sysid=1">服务考评</a></li>
		      <li <c:choose> <c:when test="${sysid== '2'}">  class="hw-menu-active"  </c:when>  <c:otherwise>  class="hw-menu-nonactive"   </c:otherwise> </c:choose>><a href="${contextPath}/main/toMain?sysid=2">成本管理</a></li>
		      <li <c:choose> <c:when test="${sysid== '3'}">  class="hw-menu-active"  </c:when>  <c:otherwise>  class="hw-menu-nonactive"   </c:otherwise> </c:choose>><a href="${contextPath}/main/toMain?sysid=3">生产管理</a></li>
		      <li <c:choose> <c:when test="${sysid== '4'}">  class="hw-menu-active"  </c:when>  <c:otherwise>  class="hw-menu-nonactive"   </c:otherwise> </c:choose>><a href="${contextPath}/main/toMain?sysid=4">绩效管理</a></li>
		      <li <c:choose> <c:when test="${sysid== '5'}">  class="hw-menu-active"  </c:when>  <c:otherwise>  class="hw-menu-nonactive"   </c:otherwise> </c:choose>><a href="${contextPath}/main/toMain?sysid=5">综合管理</a></li>
		      <!--li class="hw-menu-nonactive"><a href="#">绩效管理 </a></li>
		      <li class="hw-menu-nonactive"><a href="#">综合管理</a></li-->
		    </ul>
		    </div>
		  </div>
		  <div class="right am-topbar-left am-form-inline user-div">
		  <ul class="user-ul">
		  <li><img src="<spring:url value="/easyui/themes/icons/my_user.png"/>" style="margin:3px;"></img>欢迎  ${userVo.username}</li>
		  <li><a href="#" id="editpass"><img src="<spring:url value="/easyui/themes/icons/my_user_edit.png"/>" style="margin:3px;"></img>修改密码</a></li>
		  <li> <a href="#" id="loginOut"><img src="<spring:url value="/easyui/themes/icons/my_user_go.png"/>" style="margin:3px;"></img>安全退出</a></li>
		  </ul>
		  </div>
		  </div>
    </div>
    
    <!-- 
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">By 疯狂秀才(QQ:1055818239) jQuery.Easy-UI QQ讨论群： 112044258、32994605、36534121、56271061</div>
    </div>
     -->
    <div region="west" split="true"  title="导航菜单" style="width:180px;" id="west">
			<div id="nav">
		<!--  导航内容 -->
				
			</div>

    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; " >
				<iframe scrolling="auto" frameborder="0"  src="${contextPath}/toHome" style="width:100%;height:440px;"></iframe>
			</div>
		</div>
    </div>
    
    
    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>

	<!--Open Window Begin-->
  	  <div id="openWindow"></div>
    <!--Open Window End-->
    
	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="refresh">刷新</div>
		<div class="menu-sep"></div>
		<div id="close">关闭</div>
		<div id="closeall">全部关闭</div>
		<div id="closeother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="closeright">当前页右侧全部关闭</div>
		<div id="closeleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="exit">退出</div>
	</div>


</body>
</html>