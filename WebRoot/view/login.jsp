<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/view/commons/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">  
	  
    <title>落尘酒店客房管理系统登录界面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/assets/bootstarp/css/bootstrap.min.css'/>">
	<script type="text/javascript" src='<c:url value="/assets/jquery/jquery-3.3.1.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/propper/popper.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/bootstarp/js/bootstrap.min.js"/>'></script>   
	

  </head>
  
  <body >
   <div class="container">
       <div class="row col-12 col-md-6 offset-md-2" style="margin-top:100px">
         <h2><b>落尘酒店客房管理系统 v1.0</b></h2>
         <hr>
       </div>
       <div class="row py-5">
       	 <s:form namespace="/login" action="login" method="post" cssClass="col-12 col-md-6 offset-md-3">
 		    <div  class="form-group">
		    <label for="adminno">账户名称</label>
		    <s:textfield name="admin.adminNo" cssClass="form-control" placeholder="请输入6位账号信息" maxlength="6"></s:textfield>
		  </div>  
		  <div class="form-group">
		    <label for="adminPwd">账户密码</label>
		    <s:password cssClass="form-control" name="admin.adminPwd" placeholder="请输入密码信息" maxlength="6"></s:password>
		  </div>
		  <c:if test="${not empty errMsg}">
          <div class="alert alert-danger text-center">
			 ${errMsg}
		  </div>		
		  </c:if>  	  
		  <div>
		  	<s:submit cssClass="btn btn-primary" value="系 统 登 录"></s:submit>
		  </div>
       	  </s:form>
   		
   	    </div>
    </div>
    <jsp:include page="/view/commons/footer.jsp"></jsp:include>
  </body>
</html>
