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
    
    <title>落尘酒店客房管理系统-客房列表</title>
    
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
	
		function deleteRoom(hotelName,roomNo,roomId){
			if(confirm("您真的要删除["+hotelName+"-"+roomNo+"号] 房间吗?"))
				location.href='<s:url namespace="/room" action="deleteRoom"/>?room.roomId='+roomId;
		}
		
		function updateRoom(roomId){
			location.href='<s:url namespace="/room" action="preUpdate"/>?room.roomId='+roomId;
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
		    <li class="breadcrumb-item"><a href='<s:url namespace="/home" action="toRoom"/>'>客房管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">客房列表</li>
		  </ol>
		</nav>    
		</div>
		
		<div class="container">
			<s:form namespace="/room" action="loadRoom" method="post">
				<div class="form-row">
					<div class="form-group col-md-3">
						<s:select cssClass="form-control" name="helper.qryHotelId" list="hotelList" listKey="hotelId" listValue="hotelName" headerKey="" headerValue="--请选择分店--"/>
					</div>
					<div class="form-group col-md-3">
						<s:select cssClass="form-control" name="helper.qryRoomType" list='#{"a":"单人间","b":"双人间","c":"三人间","d":"贵宾套房","e":"豪华商务房"}' headerKey="" headerValue="--请选择客房类型--"/>
					</div>
					<div class="form-group col-md-3">
						<s:select cssClass="form-control" name="helper.qryRoomStatus" list='#{"a":"空置房间","b":"已预订","c":"退房保洁中","d":"整理维修","e":"已入住","f":"未保洁"}' headerKey="" headerValue="--请选择房间状态--"/>
					</div>
					<div class="form-group col-md-3">
						<s:submit cssClass="btn btn-primary" value="查询客房"></s:submit>
					</div>
				</div>
			</s:form>
				<table class="table table-hover">
					<tr>
						<th scope="col">编号(Id)</th>
						<th scope="col">房号(No)</th>
						<th scope="col">所属分店</th>
						<th scope="col">房间类型</th>
						<th scope="col">屋内设置</th>
						<th scope="col">房间状态</th>
						<th scope="col">操作</th>
					</tr>
					<tbody>
						<s:iterator value="page.pageContent">
							<tr>
								<th scope="row"><s:property value="roomId"/></th>
								<td><s:property value="roomNo"/></td>
								<td><s:property value="hotel.hotelName"/></td>
								<td>
									<s:if test='roomType=="a"'>单人间</s:if>
									<s:elseif test='roomType=="b"'>双人间</s:elseif>
									<s:elseif test='roomType=="c"'>三人间</s:elseif>
									<s:elseif test='roomType=="d"'>贵宾套房</s:elseif>
									<s:elseif test='roomType=="e"'>豪华商务房</s:elseif>
								</td>
								<td>
									<s:iterator var="equip" value="roomEquip">
										<s:if test='#equip=="a"'>大屏液晶&nbsp</s:if>
										<s:elseif test='#equip=="b"'>中央空调&nbsp</s:elseif>
										<s:elseif test='#equip=="c"'>高级卫浴&nbsp</s:elseif>
										<s:elseif test='#equip=="d"'>互联网接入&nbsp</s:elseif>
										<s:elseif test='#equip=="e"'>冲浪浴缸&nbsp</s:elseif>
										<s:elseif test='#equip=="f"'>卫星电视&nbsp</s:elseif>
										<s:elseif test='#equip=="g"'>冰箱</s:elseif>
									</s:iterator>
								</td>
								<td>
									<s:if test='roomStatus=="a"'>空置房间</s:if>
									<s:elseif test='roomStatus=="b"'>已预订</s:elseif>
									<s:elseif test='roomStatus=="c"'>退房保洁中</s:elseif>
									<s:elseif test='roomStatus=="d"'>整理维修</s:elseif>
									<s:elseif test='roomStatus=="e"'>已入住</s:elseif>
									<s:elseif test='roomStatus=="f"'>未保洁</s:elseif>
								</td>
								<td>
									<button class="btn btn-primary btn-sm" onclick="updateRoom(<s:property value="roomId"/>)">修改</button>
									<button class="btn btn-danger btn-sm" onclick="deleteRoom('<s:property value="hotel.hotelName"/>',<s:property value="roomNo"/>,<s:property value="roomId"/>);">删除</button>
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
		        <button type="button" class="btn btn-primary" onclick="deleteHotel()">确认操作</button>
		      </div>
		    </div>
		  </div>
	  </div>  
	  
      <jsp:include page="/view/commons/dialog.jsp"></jsp:include>
  </body>
</html>