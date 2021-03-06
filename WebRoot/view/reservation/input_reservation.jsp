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
    
    <title>落尘酒店客房管理系统-客房预订</title>
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
		    <li class="breadcrumb-item"><a href='<s:url namespace="/home" action="toReservation"/>'>预订管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">客房预订</li>
		  </ol>
		</nav>    
		</div>
     <div class="container-fluid col-md-6">
       <div class="row mx-2">
          <div class="col-12 col-md-8">
            <s:form namespace="/reservation" action="saveReservation"  method="post">
              <div class="form-group">
				<label>客户id</label><br>
				<s:textfield cssClass="form-control" name="reservation.customer.customerId" placeholder="请输入客户Id" ></s:textfield>
			  </div>
			  <hr>
			  <div class="form-group">
				<label>所属分店-房间</label><br>
				<s:doubleselect  cssClass="form-control" doubleCssClass="form-control" doubleName="reservation.room.roomId" list="hotelList" listKey="hotelId" listValue="hotelName" doubleList="roomMap.get(top.hotelId)" doubleListKey="roomId" doubleListValue="roomNo" ></s:doubleselect>
			  </div>
			  <hr> 			  			  		
			  <div class="form-group">
			    <s:submit value="添加预订信息" cssClass="btn btn-primary"></s:submit>
			  </div>	             
            </s:form>
          </div>
       </div>
     </div>
    <jsp:include page="/view/commons/footer.jsp"></jsp:include>
    <jsp:include page="/view/commons/dialog.jsp"></jsp:include>
  </body>
</html>