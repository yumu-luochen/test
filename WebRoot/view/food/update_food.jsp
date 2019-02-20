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
    
    <title>落尘酒店客房管理系统-食品信息修改</title>
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
		    <li class="breadcrumb-item"><a href='<s:url namespace="/home" action="toFood"/>'>食品管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">食品信息修改</li>
		  </ol>
		</nav>    
		</div>
     <div class="container-fluid col-md-6">
       <div class="row mx-2">
          <div class="col-12 col-md-8">
            <s:form namespace="/food" action="saveFood"  method="post">
              <s:hidden name="food.foodId"></s:hidden>
			  <div class="form-group">
			    <label>食品名称</label>
			    <s:textfield cssClass="form-control" name="food.foodName" placeholder="请输入食品的名称"/>
			  </div>
			  <hr>
			  <div class="form-group">
			    <label>食品分类</label>
			    <s:select cssClass="form-control" name="food.foodCategory.foodCategoryName" list="foodCategoryList" listKey="foodCategoryId" listValue="foodCategoryName" headerKey="" headerValue="-请选择食品分类-"/>
			  </div>
			  <hr>
			  <div class="form-group">
			    <label>食品购入价格</label>
			    <s:textfield cssClass="form-control" name="food.foodPurchasedPrice" placeholder="请输入食品的购入价格"/>
			  </div>
			  <hr>
			  <div class="form-group">
			    <label>食品出售价格</label>
			    <s:textfield cssClass="form-control" name="food.foodSellPrice" placeholder="请输入食品的出售价格"/>
			  </div>
			  <hr>
			  <div class="form-group">
			    <label>食品数量</label>
			    <s:textfield cssClass="form-control" name="food.foodNumber" placeholder="请输入食品的数量"/>
			  </div>
			  <hr>	
			  <div class="form-group">
			    <s:submit value="修改食品信息" cssClass="btn btn-primary"></s:submit>
			  </div>	             
            </s:form>
          </div>
       </div>
     </div>
    <jsp:include page="/view/commons/footer.jsp"></jsp:include>
  </body>
</html>