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
    
    <title>落尘酒店客房管理系统-分店列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/assets/bootstarp/css/bootstrap.min.css'/>">
	<script type="text/javascript" src='<c:url value="/assets/jquery/jquery-3.3.1.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/propper/popper.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/bootstarp/js/bootstrap.min.js"/>'></script> 

	<script type="text/javascript">
	
	    var willDeleteHotelId;
	  
	    function updateHotel(hotelId){
	      location.href='<s:url namespace="/hotel" action="preUpdate"/>?hotel.hotelId='+hotelId;
	    }
	    
	    function promptRemoveHotel(hotelId,hotelName){
	        willDeleteHotelId = hotelId;
	        $("#msg").text('您真的要删除分店[ "'+hotelName+'"] 信息吗？');
	      	$('#AlertDlgModal').modal();
	    }
	    
	    function deleteHotel(){
	         location.href='<s:url namespace="/hotel" action="deleteHotel"/>?hotel.hotelId='+willDeleteHotelId;
	    }
	 
	</script>
  </head>
  
  <body>
     <jsp:include page="/view/commons/header_menu.jsp"></jsp:include>
     <div class="container" >
		<nav aria-label="breadcrumb" style=" margin-left:-15px; margin-right:-15px;">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="#">首页</a></li>
		    <li class="breadcrumb-item"><a href="#">分店管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">分店列表</li>
		  </ol>
		</nav>    
		</div>
	 <div class="m-3">
			 <table class="table">
			  <thead>
			    <tr>
			      <th scope="col">编号</th>
			      <th scope="col">分店名称</th>
			      <th scope="col">分店地址</th>
			      <th scope="col">联络电话</th>
			      <th scope="col">房间总数</th>
			      <th scope="col">操作</th>
			    </tr>
			  </thead>
			  <tbody>
			    <s:iterator value="hotelList">
                    <tr>
			      <th scope="row"><s:property value="hotelId"/></th>
			      <td>
			       <img width="200" height="150" src="<s:url namespace="/hotel" action="getPic"/>?hotel.hotelId=<s:property value="hotelId"/>"><br>
			       <s:property value="hotelName"/>
			      </td>
			      <td><s:property value="hotelAddr"/></td>
			      <td><s:property value="hotelPhone"/></td>
			      <td><s:property value="hotelRoomCount"/></td>
			      <td>
			        <button class="btn btn-primary btn-sm" onclick="updateHotel(<s:property value="hotelId"/>);"> 修 改 </button>
			        <button class="btn btn-danger btn-sm" onclick="promptRemoveHotel(<s:property value="hotelId"/>,'<s:property value="hotelName"/>');"> 删 除 </button>
			      </td>
			    </tr>			       
			    </s:iterator>
			  </tbody>
			</table>	       
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