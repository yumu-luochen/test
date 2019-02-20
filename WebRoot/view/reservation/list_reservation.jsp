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
    
    <title>落尘酒店客房管理系统-预订列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/assets/bootstarp/css/bootstrap.min.css'/>">
	<script type="text/javascript" src='<c:url value="/assets/jquery/jquery-3.3.1.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/propper/popper.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/bootstarp/js/bootstrap.min.js"/>'></script> 
	<style type="text/css">
		th,td{
			text-align: left;
		}
	</style>
	<script type="text/javascript">
	
		function deleteReservation(reservationId,hotelName,roomNo,customerId,customerName){
			if(confirm("您真的要删除[客户Id:"+customerId+"-"+customerName+",预订的"+hotelName+"的"+roomNo+"号]房间吗?"))
				location.href='<s:url namespace="/reservation" action="deleteReservation"/>?reservation.reservationId='+reservationId;
		}
		
		function updateReservation(reservationId){
			location.href='<s:url namespace="/reservation" action="preUpdate"/>?reservation.reservationId='+reservationId;
		}
		function doQuery(pageNo){
			if(pageNo<1 || pageNo>${page.totalPageNum}){
				alert("页号超出范围,有效范围:[1-<s:property value="page.totalPageNum"/>]!");
				${'pageNo'}.select();
				return;
			}
			var f = document.forms[0];
			f.action = f.action+"?page.pageNo="+pageNo;
			f.submit();
		}
	</script>
  </head>
  
  <body>
     <jsp:include page="/view/commons/header_menu.jsp"></jsp:include>
     <div class="container" >
		<nav aria-label="breadcrumb" style=" margin-left:-15px; margin-right:-15px;">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href='<s:url namespace="/login" action="home"/>'>首页</a></li>
		    <li class="breadcrumb-item"><a href='<s:url namespace="/home" action="toReservation"/>'>预订管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">预订列表</li>
		  </ol>
		</nav>    
		</div>
		
		<div class="container">
			<!--
			 <s:form namespace="/reservation" action="loadReservation" method="post">
					<div class="form-row">
					<div class="form-group col-md-3">
						<s:select cssClass="form-control" name="helper.qryHotelId" list="hotelList" listKey="hotelId" listValue="hotelName" headerKey="" headerValue="--请选择分店--"/>
					</div>
					<div class="form-group col-md-3">
						<s:select cssClass="form-control" name="helper.qryRoomType" list='#{"a":"单人间","b":"双人间","c":"三人间","d":"贵宾套房","e":"豪华商务房"}' headerKey="" headerValue="--请选择客房类型--"/>
					</div>
					<div class="form-group col-md-3">
						<s:textfield cssClass="form-control" name="helper.qryCustomerName" placeholder="请输入客户姓名"/>
					</div>
					<div class="form-group col-md-3">
						<s:submit cssClass="btn btn-primary" value="查询预订信息"></s:submit>
					</div>
				</div>
			</s:form>
			 --> 
			 <s:form namespace="/reservation" action="loadReservation" method="post">
				<div class="form-row">
				    <div class="form-group col-md-3">
					<s:textfield cssClass="form-control" name="helper.qryCustomerId" placeholder="请输入客户id"/>
					</div>
					<div class="form-group col-md-3">
						<s:submit cssClass="btn btn-primary" value="查询预订信息"></s:submit>
					</div>
				</div>
			</s:form>
			 
				<table class="table table-hover">
					<tr>
						<th scope="col">预订编号(Id)</th>
						<th scope="col">客户Id</th>
						<th scope="col">客户姓名</th>
						<th scope="col">所属分店</th>
						<th scope="col">房间号</th>
						<th scope="col">房间类型</th>
						<th scope="col">操作</th>
					</tr>
					<tbody>
						<s:iterator value="page.pageContent">
							<tr>
								<th scope="row"><s:property value="reservationId"/></th>
								<td><s:property value="customer.customerId"/></td>
								<td><s:property value="customer.customerName"/></td>
								<td><s:property value="room.hotel.hotelName"/></td>
								<td><s:property value="room.roomNo"/></td>
								<td>
									<s:if test='room.roomType=="a"'>单人间</s:if>
									<s:elseif test='room.roomType=="b"'>双人间</s:elseif>
									<s:elseif test='room.roomType=="c"'>三人间</s:elseif>
									<s:elseif test='room.roomType=="d"'>贵宾套房</s:elseif>
									<s:elseif test='room.roomType=="e"'>豪华商务房</s:elseif>
								</td>
								<td>
									<button class="btn btn-primary btn-sm" onclick="updateReservation('<s:property value="reservationId"/>')">修改</button>
									<button class="btn btn-danger btn-sm" onclick="deleteReservation('<s:property value="reservationId"/>','<s:property value="room.hotel.hotelName"/>','<s:property value="room.roomNo"/>','<s:property value="customer.customerId"/>','<s:property value="customer.customerName"/>');">删除</button>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<div id="pageinfo">
					共<s:property value="page.totalRecNum"/>条,当前显示<s:property value="page.startIndex+1"/>-<s:property value="page.endIndex"/>条,第<s:property value="page.pageNo"/>/<s:property value="page.totalPageNum"/>页
					<s:if test="page.pageNo>1">
						<button class="btn btn-sm btn-outline-info" onclick="doQuery(1)">首页</button>&nbsp;
					</s:if>
					<s:if test="page.prePage">
						<button class="btn btn-sm btn-outline-info" onclick="doQuery(<s:property value="page.pageNo-1"/>)">上一页</button>&nbsp;
					</s:if>
					<s:if test="page.nextPage">
						<button class="btn btn-sm btn-outline-info" onclick="doQuery(<s:property value="page.pageNo+1"/>)">下一页</button>&nbsp;
					</s:if>
					<s:if test="page.pageNo!=page.totalPageNum">
						<button class="btn btn-sm btn-outline-info" onclick="doQuery(<s:property value="page.totalPageNum"/>)">末页</button>&nbsp;
					</s:if>
					|到<input type="text" class="text-center" id="pageNo" size=4 style="text-align:right;" onkeypress="onlynumber();">页
						<button class="btn btn-sm btn-primary" onclick="doQuery(parseInt($('#pageNo').val()));">跳转</button>
				</div>
		</div>

     <jsp:include page="/view/commons/footer.jsp"></jsp:include>
     
     <!-- 删除提示窗口  -->
	 <div class="modal fade" id="AlertDlgModal" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">系统提示</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <p id="msg"></p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" onclick="deleteReservation()">确认操作</button>
		      </div>
		    </div>
		  </div>
	  </div>  
	  
      <jsp:include page="/view/commons/dialog.jsp"></jsp:include>
  </body>
</html>