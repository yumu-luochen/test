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
    
    <title>落尘酒店客房管理系统-客房信息修改</title>
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
		    <li class="breadcrumb-item"><a href='<s:url namespace="/home" action="toRoom"/>'>客房管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">客房信息修改</li>
		  </ol>
		</nav>    
		</div>
     <div class="container-fluid col-md-6">
       <div class="row mx-2">
          <div class="col-12 col-md-8">
            <s:form namespace="/room" action="updateRoom"  method="post">
              <s:hidden name="room.roomId"></s:hidden>
			  <div class="form-group">
			    <label>房间编号</label>
			    <s:textfield cssClass="form-control" name="room.roomNo" placeholder="请输入房间的编号"/>
			  </div> 
			  <hr>
              <div class="form-group">
				<label for="hotelPhoto">所属分店</label><br>
				<s:select name="room.hotel.hotelId" list="hotelList" cssClass="form-control" listKey="hotelId" listValue="hotelName"></s:select>
			  </div>
			  <hr>
              <div class="form-group">
				<label for="hotelPhoto">房间类型</label><br>
				<s:radio name="room.roomType" list='#{"a":"单人间","b":"双人间","c":"三人间","d":"贵宾套房","e":"豪华商务房"}'></s:radio>                                           
			  </div>
			  <hr>
			  <div class="form-group">
				<label for="hotelPhoto">屋内设施</label><br>
				<s:checkboxlist name="room.roomEquip" list='#{"a":"大屏液晶","b":"中央空调","c":"高级卫浴","d":"互联网接入","e":"冲浪浴缸","f":"卫星电视","g":"冰箱"}'></s:checkboxlist>
			  </div>
			  <hr>
			  <div class="form-group">
				<label for="hotelPhoto">房间状态</label><br>
				<s:select name="room.roomStatus"  headerKey="" headerValue="-请选择-" cssClass="form-control" list='#{"a":"空置房间","b":"已预订","c":"退房保洁中","d":"整理维修","e":"已入住","f":"未保洁"}'></s:select>
			  </div>	
			  <hr>	
			  <div class="form-group">
			    <label>备注说明</label>
			    <s:textarea name="room.roomMemo" cssClass="form-control" rows="3" cols="50"  placeholder="说明房间额外信息"></s:textarea>
			  </div>
			  <hr>				  	
			  <div class="form-group">
			    <s:submit value="修改房间信息" cssClass="btn btn-primary"></s:submit>
			  </div>	             
            </s:form>
          </div>
       </div>
     </div>
    <jsp:include page="/view/commons/footer.jsp"></jsp:include>
    <jsp:include page="/view/commons/dialog.jsp"></jsp:include>
  </body>
</html>