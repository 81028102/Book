<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/index.css" type="text/css"></link>
</head>
<script type="text/javascript">
	$(function(){
	//反选
	$("#fx").click(function(){
	  $(".cks").each(function(){
	    if($(this).attr("checked")){
		  $(this).attr("checked",false);
	    }else{
	      $(this).attr("checked",true);
	    }
	    });
	  });
	  //全选/全不选
	  $("#x").toggle(function(){
	    $(".cks").attr("checked",true);
	  },
	  function(){
	   $(".cks").attr("checked",false);
	  });
	  
	   $("#ck").click(function(){
  			if($("#ck").attr("checked")){
  				$(".cks").attr("checked",true);
  			}else{
  				$(".cks").attr("checked",false);
  			}
  		});
  		//删除功能
  		$(".delete").click(function(){
  		if(confirm("确定是否删除?")){
  			var id=$(this).next().val();  //获取紧邻同辈下一个元素的value值
  			$.post(
  				"<%=request.getContextPath()%>/Delete",
  				{id:id},
  				function(obj){
  					if(obj=="删除成功"){
  						location.reload();
  					}
  				},
  				"text"
  				)
  			}
  		});
  		//批量删除
  		$("#delete").click(function(){
  			var id="";
  			$(".cks:checked").each(function(){
  				id+=","+$(this).parent().next().text();   //循环获取被选中的checkbox对应的name值
  			});
  			id=id.substring(1);   //将字符串多余的','截取掉
  			$.ajax({
  				url:"<%=request.getContextPath()%>/Delete",
  				type:"post",
  				data:{id:id},
  				dataType:"text",
  				success:function(obj){
  					if(obj=="删除成功"){
  						location.reload();
  						$(".cks").removeAttr("checked");
  					}
  				}
  			});
  		});
  		$("#Add").click(function(){
  		   location.href="<%=request.getContextPath()%>/Add.jsp";
		});
		$(".update").click(function(){
			if(confirm("是否确认修改?")){
			var id=$(this).prev().val();
 	            location.href="<%=request.getContextPath()%>/Update.jsp?id="+id;
  		  	 }
		});
	});
</script>
<body>
	<table>
		<tr>
			<th colspan="10">列表页面 &nbsp;&nbsp;&nbsp;&nbsp; <input
				type="button" value="反选" id="fx"> <input type="button"
				value="全选/全不选" id="x"> <input type="button" value="批量删除"
				id="delete"></th>
		</tr>
		<tr>
			<td><input type="checkbox" id="ck">
			</td>
			<td>图书编号</td>
			<td>图书名称</td>
			<td>图书作者</td>
			<td>图书类型</td>
			<td>图书简介</td>
			<td>图书价格</td>
			<td>出版时间</td>
			<td><input type="button" id="Add" value="添加">
			</td>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr>
				<td><input type="checkbox" class="cks">
				</td>
				<td>${list.id}</td>
				<td>${list.name}</td>
				<td>${list.author}</td>
				<td>${list.type}</td>
				<td>${list.intro}</td>
				<td>${list.price}</td>
				<td>${list.publishdate}</td>
				<td><input type="button" value="删除" class="delete" /> <input
					type="hidden" value="${list.id}" /> <input type="button"
					value="修改" class="update" />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
