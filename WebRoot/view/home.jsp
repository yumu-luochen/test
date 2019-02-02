<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/view/commons/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>落尘酒店客房管理系统-首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/assets/bootstarp/css/bootstrap.min.css'/>">
	<script type="text/javascript" src='<c:url value="/assets/jquery/jquery-3.3.1.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/propper/popper.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/bootstarp/js/bootstrap.min.js"/>'></script> 
  </head>
  
  <body>
    <jsp:include page="/view/commons/header_menu.jsp"></jsp:include>
    <div class="container text-center"  >
       <div class="row py-5 row-center" style="display: inline-block;">
		<div class="jumbotron col-center">
		  <h1 class="display-4">欢迎来到落尘酒店客房管理系统</h1>
		  <p class="lead">你可以进行一些操作.</p>
		  <hr class="my-4">
		  <button type="button" class="btn btn-primary btn-lg btn-block">分店管理</button>
		  <button type="button" class="btn btn-success btn-lg btn-block">客房管理</button>
		  <button type="button" class="btn btn-info btn-lg btn-block">住宿管理</button>
		  <button type="button" class="btn btn-warning btn-lg btn-block">财务管理</button>
		  <button type="button" class="btn btn-dark btn-lg btn-block">系统维护</button>
		</div>       
       </div>
    </div>
    <jsp:include page="/view/commons/footer.jsp"></jsp:include>
  </body>
</html>
