$(function () {

	
	$('#dept').panel({
		//id : 'pox',
		title : '部门',
		width : 288,
		height : 410,
		iconCls : 'icon-search',
		//left : 100,
		//top : 100,	
		cls : 'a',
		headerCls : 'b',
		bodyCls : 'c',
		style : {
			'min-height' : '200px',
		},
		tools : [{
			iconCls : 'icon-help',
			handler : function () {
				alert('help');
			},
		},{
		}],
	});
	
	
	$('#dept').tree({
		url: '/BS56/sys/user/getDeptTree.json',
		lines : true,
		onClick:function(node){
				if(hasGetDept!=node.id)//防止多次点同一个部门重复去服务器取值
					{
						$.ajax({
						     url: '/BS56/sys/user/getUserListByDeptID.json?depId='+node.id,
						     method:"GET",
						     success: function (result) {
						    	 console.log(result);
						    	 $("#userUL").children("li").remove();//清空控件中存在的用户然后在添加获取的用户
						    	 var has = false;
						         for(var i in result)
						         {  
						        	 hasGetDept = node.id;
									 $("#userUL").append ("<li id='user_list'>"+result[i].username+"["+result[i].usercode+"]"+"</li>");
						         }
						         initUserList();
						     }
						 })
				   }
		},
		onLoadSuccess:function(data){
			//console.log("optype--"+optype);
		//如果为角色授权，获取已经授权的用户信息
			if(optype=="rolegrant"){//系统角色
				$.ajax({
					url:'/BS56/sys/role/getRoleGrantUserList.json?roleid='+roleid,
					method:"GET",
				    success:function(result){
				    	 $.each( result, function(index, content)
				    			  { 
				    		 $("#userULSelected").append("<li>"+content.username+"["+content.usercode+"]"+"<span class='shanchu'><i class='icon-close'></i></span></li>");
				    			  });
				    }
				})
			}
			else if(optype=="businessrolegrant"){//业务角色授权
				$.ajax({
					url:'/BS56/sys/businessrole/getRoleGrantUserList.json?roleid='+roleid,
					method:"GET",
				    success:function(result){
				    	 $.each( result, function(index, content)
				    			  { 
				    		 $("#userULSelected").append("<li>"+content.username+"["+content.usercode+"]"+"<span class='shanchu'><i class='icon-close'></i></span></li>");
				    			  });
				    }
				})
			}
			else if(optype=="performuserlevel"){//绩效管理模块的考核授权
				$.ajax({
					url:'/BS56/perform/userlevel/getUserlevelList.json?id='+roleid,//此处的roleid即为用户id
					method:"GET",
				    success:function(result){
				    	//console.log("result--"+result);
				    	 $.each( result, function(index, content)
				    			  { 
				    		 $("#userULSelected").append("<li>"+content.username+"["+content.usercode+"]"+"<span class='shanchu'><i class='icon-close'></i></span></li>");
				    			  });
				    }
				})
			}
		}
	});
	
	$('#button_ok').click(function(){
		var text ="";
		 $(".selected_user li").each(function(){
					  text+= $(this).text()+";";
			  });
		 
		 //optype为rolegrant角色授权
		 if(optype=="rolegrant")//系统角色
			 {
				 if(text==""){
					 $.messager.alert('提示',"请选择你要授权的用户",'info');
					 return;
				 }
				 else{
					 $.ajax({
						 url:'/BS56/sys/role/doRoleGrant.json?roleid='+roleid+"&userstr="+text,
						 method:"GET",
						// data:{roleid:roleid,userstr:text},//角色和用户串
						 success: function (result) {
							 $.messager.show({
								 title : '提示',
								 msg :  '操作成功！',
							 });
						 }
					 })
				 }
			 }
		 if(optype=="businessrolegrant")//业务角色
		 {
			 if(text==""){
				 $.messager.alert('提示',"请选择你要授权的用户",'info');
				 return;
			 }
			 else{
				 $.ajax({
					 url:'/BS56/sys/businessrole/doRoleGrant.json?roleid='+roleid+"&userstr="+text,
					 method:"GET",
					// data:{roleid:roleid,userstr:text},//角色和用户串
					 success: function (result) {
						 $.messager.show({
							 title : '提示',
							 msg :  '操作成功！',
						 });
						 //刷新左边所有tab
						 window.parent.refreshTab("业务角色");
						 window.parent.tabCloseForChild("角色授权");
					 }
				 })
			 }
			 //关闭当前选项卡
			
		 }
		 if(optype=="performuserlevel")//绩效管理模块的考核授权
		 {
			 if(text==""){
				 $.messager.alert('提示',"请选择你要授权的用户",'info');
				 return;
			 }
			 else{
				 $.ajax({
					 url:'/BS56/perform/userlevel/doAddUserlevel.json?userid='+roleid+"&userstr="+text+"&userlevel="+userlevel,
					 method:"GET",
					// data:{roleid:roleid,userstr:text},//角色和用户串
					 success: function (result) {
						 $.messager.show({
							 title : '提示',
							 msg :  '操作成功！',
						 });
						 //刷新左边所有tab
						 window.parent.refreshTab("考核授权");
						 window.parent.tabCloseForChild("用户授权");
					 }
				 })
			 }
			 //关闭当前选项卡
			
		 }
		//alert(text);
	});
	if(optype=="groupuser")//业务角色
	 {
		 alert("t");
		 if(text==""){
			 $.messager.alert('提示',"请选择你要授权的用户",'info');
			 return;
		 }
		 else{ alert("ssss");}
	 }

});
