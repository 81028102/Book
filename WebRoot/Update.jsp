<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Update.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/index.css"
	type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
  $.ajax({
    url:"<%=request.getContextPath()%>/Type",
    type:"post",
    dataType:"json",
    success:function(obj){
    	for(var i in obj){
    	$("[name='type']").append("<option value='"+obj[i]+"'>"+obj[i]+"</option");
    	}
      }
	});
	//接收列表页传递的id值
  		var id=${param.id};
  		$.ajax({
  			url:"<%=request.getContextPath()%>/ToUpdate",
  			type:"post",
  			data:{id:id},
  			dataType:"json",
  			success:function(obj){
  				$("#name").val(obj.name);
  				$("#author").val(obj.author);
  				$("[value='"+obj.type+"']").attr("selected",true);
  				$("#intro").val(obj.intro);
  				$("#price").val(obj.price);
  				$("#publishdate").val(obj.publishdate);
  			}
  		});
	$("#myform").validate({
	 rules:{
	     name:{
	    	 required:true
	     },
	     author:{
	         required:true
	     },
	     type:{
	         required:true
	     },
	     intro:{
	         required:true
	     },
	     price:{
	    	 required:true
	     },
	     publishdate:{
	         required:true
	     }
	 },
	 messages:{
	      name:{
	    	 required:"图书名称不能为空"
	     },
	     author:{
	         required:"图书作者不能为空"
	     },
	     type:{
	         required:"图书类型不能为空"
	     },
	     intro:{
	         required:"图书简介不能为空"
	     },
	     price:{
	    	 required:"图书价格不能为空"
	     },
	     publishdate:{
	         required:"出版时间不能为空"
	     }
		 },
		 submitHandler:function(){
		    $.ajax({
		       url:"<%=request.getContextPath()%>/Update",
		       type:"post",
		       data:{
		      	 id:id,
		         name:$("#name").val(),
		         author:$("#author").val(),
		         type:$("[name='type'] option:selected").val(),
		         intro:$("#intro").val(),
		         price:$("#price").val(),
		         publishdate:$("#publishdate").val()
		       },
		       dataType:"text",
		       success:function(obj){
		       	if(obj=="修改成功"){
		     	  	location.href="<%=request.getContextPath()%>/List";
		       }else{
		       		alert("修改失败");
		       }
		       }
		    });
		 }
	});
});
</script>
</head>

<body>
	<form method="post" id="myform">
		<table>
			<tr>
				<th colspan="10">修改页面</th>
			</tr>
			<tr>
				<td>图书名称:<input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>图书作者:<input type="text" name="author" id="author">
				</td>
			</tr>
			<tr>
				<td>图书类型:<select name="type">
						<option value="">--请选择--</option>
				</select></td>
			</tr>
			<tr>
				<td>图书简介:<textarea name="intro" id="intro"></textarea></td>
			</tr>
			<tr>
				<td>图书价格:<input type="text" name="price" id="price"></td>
			</tr>
			<tr>
				<td>出版时间:<input type="text" name="publishdate" id="publishdate"
					onclick="WdatePicker()" class="Wdate"></td>
			</tr>
			<tr>
				<td colspan="10"><input type="submit" value="修改"> <input
					type="reset" value="返回">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
