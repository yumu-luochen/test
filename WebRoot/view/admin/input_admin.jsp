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
    
    <title>落尘酒店客房管理系统-管理员登记</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/assets/bootstarp/css/bootstrap.min.css'/>">
	<script type="text/javascript" src='<c:url value="/assets/jquery/jquery-3.3.1.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/propper/popper.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/bootstarp/js/bootstrap.min.js"/>'></script> 
  </head>
  
  <body>
    <jsp:include page="/view/commons/header_menu.jsp"></jsp:include>
 		<div class="container" >
		<nav aria-label="breadcrumb" style=" margin-left:-15px; margin-right:-15px;">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="#">首页</a></li>
		    <li class="breadcrumb-item"><a href="#">操作员管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">管理员登记</li>
		  </ol>
		</nav>    
		</div>
     <div class="container-fluid col-md-6">
       <div class="row mx-2">
          <div class="col-12 col-md-8">
            <s:form namespace="/login" action="saveAdmin"  method="post">
			  <div class="form-group">
			    <label>管理员名称</label>
			    <s:textfield cssClass="form-control" name="admin.adminName" placeholder="请输入管理员的名称"/>
			  </div> 
			  <hr>
        	  <div class="form-group">
			    <label>管理员账号(最多6位)</label>
			    <s:textfield cssClass="form-control" name="admin.adminNo" placeholder="请输入管理员账号" maxLength="6"/>
			  </div> 
			  <hr>	  			
			  <div class="form-group">
			    <label>管理员密码(最多6位)</label>
			    <s:password cssClass="form-control" name="admin.adminPwd" placeholder="请输入管理员的密码" maxLength="6"/>
			  </div> 
			  <hr>  			  		
			  <div class="form-group">
			    <s:submit value="添加管理员信息" cssClass="btn btn-primary"></s:submit>
			  </div>	             
            </s:form>
          </div>
       </div>
     </div>
    <jsp:include page="/view/commons/footer.jsp"></jsp:include>
  </body>
</html>