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
	<style type="text/css">
		th,td{
			text-align: left;
		}
	</style>
	<script type="text/javascript">
	
		function deleteFoodCategory(foodCategoryId,foodCategoryName){
			if(confirm("您真的要删除[ID:"+foodCategoryId+"的"+foodCategoryName+"]吗?"))
				location.href='<s:url namespace="/food" action="deleteFoodCategory"/>?foodCategory.foodCategoryId='+foodCategoryId;
		}
		
		function updateFoodCategory(foodCategoryId){
			location.href='<s:url namespace="/food" action="preUpdateFoodCategory"/>?foodCategory.foodCategoryId='+foodCategoryId;
		}
	</script>
  </head>
  
  <body>
     <jsp:include page="/view/commons/header_menu.jsp"></jsp:include>
     <div class="container" >
		<nav aria-label="breadcrumb" style=" margin-left:-15px; margin-right:-15px;">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="#">首页</a></li>
		    <li class="breadcrumb-item"><a href="#">食品管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">食品分类列表</li>
		  </ol>
		</nav>    
		</div>
		
		<div class="container">
				<table class="table table-hover">
					<tr>
						<th scope="col">食品分类编号(Id)</th>
						<th scope="col">名称</th>
						<th scope="col">操作</th>
					</tr>
					<tbody>
						<s:iterator value="foodCategoryList">
							<tr>
								<th scope="row"><s:property value="foodCategoryId"/></th>
								<td><s:property value="foodCategoryName"/></td>
								<td>
									<button class="btn btn-primary btn-sm" onclick="updateFoodCategory(<s:property value="foodCategoryId"/>)">修改</button>
									<button class="btn btn-danger btn-sm" onclick="deleteFoodCategory(<s:property value="foodCategoryId"/>,'<s:property value="foodCategoryName"/>');">删除</button>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
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
		        <button type="button" class="btn btn-primary" onclick="deleteFoodCategory()">确认操作</button>
		      </div>
		    </div>
		  </div>
	  </div>  
	  
      <jsp:include page="/view/commons/dialog.jsp"></jsp:include>
  </body>
</html>