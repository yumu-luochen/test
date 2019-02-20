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
    
    <title>落尘酒店客房管理系统-客户登记</title>
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
		    <li class="breadcrumb-item"><a href='<s:url namespace="/login" action="home"/>'>首页</a></li>
		    <li class="breadcrumb-item"><a href='<s:url namespace="/home" action="toCustomer"/>'>客户管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">客户登记</li>
		  </ol>
		</nav>    
		</div>
     <div class="container-fluid col-md-6">
       <div class="row mx-2">
          <div class="col-12 col-md-8">
            <s:form namespace="/customer" action="saveCustomer"  method="post">
              <s:hidden name="customer.customerBook" value="f"></s:hidden>
			  <div class="form-group">
			    <label>客户姓名</label>
			    <s:textfield cssClass="form-control" name="customer.customerName" placeholder="请输入客户的姓名"/>
			  </div> 
			  <hr>
        	  <div class="form-group">
				<label for="hotelPhoto">客户性别</label><br>
				<s:radio name="customer.customerSex" list='#{"m":"男","f":"女"}'></s:radio>                                           
			  </div>
			  <hr>
              <div class="form-group">
			    <label>客户身份证号</label>
			    <s:textfield cssClass="form-control" name="customer.customerIdentity" placeholder="请输入客户的身份证号"/>
			  </div> 
			  <hr>
			  <div class="form-group">
			    <label>客户联系方式</label>
			    <s:textfield cssClass="form-control" name="customer.customerPhone" placeholder="请输入客户的手机号"/>
			  </div>
			  <hr>
			  <div class="form-group">
			    <label>客户联系方式</label>
			    <s:textfield cssClass="form-control" name="customer.customerEmail" placeholder="请输入客户的邮件地址"/>
			  </div>	
			  <hr>	  			  			  		
			  <div class="form-group">
			    <s:submit value="添加客户信息" cssClass="btn btn-primary"></s:submit>
			  </div>	             
            </s:form>
          </div>
       </div>
     </div>
    <jsp:include page="/view/commons/footer.jsp"></jsp:include>
  </body>
</html>