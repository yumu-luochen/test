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
    
    <title>落尘酒店客房管理系统-客户列表</title>
    
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
	
		function deleteCustomer(customerName,customerId){
			if(confirm("您真的要删除Id:"+customerId+"号的"+customerName+"客户吗?"))
				location.href='<s:url namespace="/customer" action="deleteCustomer"/>?customer.customerId='+customerId;
		}
		
		function updateCustomer(customerId){
			location.href='<s:url namespace="/customer" action="preUpdate"/>?customer.customerId='+customerId;
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
		    <li class="breadcrumb-item"><a href='<s:url namespace="/home" action="toCustomer"/>'>客户管理</a></li>
		    <li class="breadcrumb-item active" aria-current="page">客户列表</li>
		  </ol>
		</nav>    
		</div>
		
		<div class="container">
			<s:form namespace="/customer" action="loadCustomer" method="post">
				<div class="form-row">
					<div class="form-group col-md-3">
						<s:select cssClass="form-control" name="helper.qryCustomerSex" list='#{"m":"男","f":"女"}' headerKey="" headerValue="--请选择客户性别--"/>
					</div>
					<div class="form-group col-md-3">
						<s:textfield cssClass="form-control" name="helper.qryCustomerName" placeholder="请输入客户姓名"/>
					</div>
					<div class="form-group col-md-3">
						<s:submit cssClass="btn btn-primary" value="查询客户"></s:submit>
					</div>
				</div>
			</s:form>
				<table class="table table-hover">
					<tr>
						<th scope="col">客户Id</th>
						<th scope="col">客户姓名</th>
						<th scope="col">客户性别</th>
						<th scope="col">客户身份证</th>
						<th scope="col">客户联系方式</th>
						<th scope="col">是否预订房间</th>
						<th scope="col">操作</th>
					</tr>
					<tbody>
						<s:iterator value="page.pageContent">
							<tr>
								<th scope="row"><s:property value="customerId"/></th>
								<td><s:property value="customerName"/></td>
								<td>
									<s:if test='customerSex=="m"'>男</s:if>
									<s:elseif test='customerSex=="f"'>女</s:elseif>
								</td>
								<td><s:property value="customerIdentity"/></td>
								<td><s:property value="customerPhone"/></td>
								<td>
									<s:if test='customerBook=="t"'>是</s:if>
									<s:elseif test='customerBook=="f"'>否</s:elseif>
								</td>
								<td>
									<button class="btn btn-primary btn-sm" onclick="updateCustomer(<s:property value="customerId"/>)">修改</button>
									<button class="btn btn-danger btn-sm" onclick="deleteCustomer('<s:property value="customerName"/>',<s:property value="customerId"/>);">删除</button>
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
		        <button type="button" class="btn btn-primary" onclick="deleteCustomer()">确认操作</button>
		      </div>
		    </div>
		  </div>
	  </div>  
	  
      <jsp:include page="/view/commons/dialog.jsp"></jsp:include>
  </body>
</html>