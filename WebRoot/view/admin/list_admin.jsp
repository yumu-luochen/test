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
    
    <title>落尘酒店客房管理系统-操作员列表</title>
    
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
	
		function deleteAdmin(adminName,adminNo){
			if(confirm("您真的要删除No:"+adminNo+"号的 "+adminName+" 管理员吗?"))
				location.href='<s:url namespace="/login" action="deleteAdmin"/>?admin.adminNo='+adminNo;
		}
		
		function updateAdmin(adminNo){
			location.href='<s:url namespace="/login" action="preUpdate"/>?admin.adminNo='+adminNo;
		}
	</script>
  </head>
  
  <body>
     <jsp:include page="/view/commons/header_menu.jsp"></jsp:include>
     <div class="container" >
		<nav aria-label="breadcrumb" style=" margin-left:-15px; margin-right:-15px;">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="#">首页</a></li>
		    <li class="breadcrumb-item"><a href="#">操作员管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">管理员列表</li>
		  </ol>
		</nav>    
				<table class="table table-hover">
					<tr>
						<th scope="col">管理员账号(No)</th>
						<th scope="col">管理员名称</th>
						<th scope="col">操作</th>
					</tr>
					<tbody>
						<s:iterator value="adminList">
							<tr>
								<th scope="row"><s:property value="adminNo"/></th>
								<td><s:property value="adminName"/></td>
								<td>
									<button class="btn btn-primary btn-sm" onclick="updateAdmin(<s:property value="adminNo"/>)">修改</button>
									<button class="btn btn-danger btn-sm" onclick="deleteAdmin('<s:property value="adminName"/>',<s:property value="adminNo"/>);">删除</button>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
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
		        <button type="button" class="btn btn-primary" onclick="deleteAdmin()">确认操作</button>
		      </div>
		    </div>
		  </div>
	  </div>  
	  
      <jsp:include page="/view/commons/dialog.jsp"></jsp:include>
  </body>
</html>