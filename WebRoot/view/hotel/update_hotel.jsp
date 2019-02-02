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
    
    <title>落尘酒店客房管理系统-新开分店</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/assets/bootstarp/css/bootstrap.min.css'/>">
	<script type="text/javascript" src='<c:url value="/assets/jquery/jquery-3.3.1.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/propper/popper.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/assets/bootstarp/js/bootstrap.min.js"/>'></script> 
    <script type="text/javascript">
    
       function previewImage(file){
       
            var img = document.getElementById('picImg');
						
			if (file.files && file.files[0]) 			
			{		
			   
			   //准备一个文件读取器对象，并告诉它文件读取完毕之后要做什么。
			   var reader = new FileReader();			  
			   //成功读取了图片信息后，把读取结果赋予 	
			   
			  //FileReader.readAsDataURL()
              //开始读取指定的Blob中的内容。一旦完成，result属性中将包含一个data: URL格式的字符串以表示所读取文件的内容。			   		
			   reader.onload = function(evt){
			    img.src= evt.target.result;
			    console.log("读取完毕,图片已经成功加载!"+evt.target.result);
			   }
			
			   console.log("开始读取!")
			   reader.readAsDataURL(file.files[0]);
			
			}
		    else{
		       img.src='<c:url value="/imgs/no-pic.jpg"/>';
		       alert("没有上传图片文件!");
		    }
			
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
		    <li class="breadcrumb-item active" aria-current="page">新开分店</li>
		  </ol>
		</nav>    
		</div>
    	<div class="container-fluid col-md-6">
	         <div class="row mx-8">
	          <div class="col-12 col-md-8">
	            <!-- 表单提交为了安全起见，一般是post提交，如果有提交文件，那么一律似乎是多段提交 -->
	            <!-- enctype: encode type 编码模式 -->
	            <s:form namespace="/hotel" action="updateHotel" method="post" enctype="multipart/form-data">
	            	<s:hidden name="hotel.hotelId"></s:hidden>
	            	<div class="form-group">
	            		<label>分店名称:</label>
	            		<s:textfield name="hotel.hotelName" cssClass="form-control" placeholder="请输入分店名称信息"></s:textfield>
	            		<hr>
	            	</div>
	            	<div class="form-group">
	            		<label>分店照片:</label>
	            		<img id="picImg" alt="加载不出来" src='<s:url namespace="/hotel" action="getPic"/>?hotel.hotelId=<s:property value="hotel.hotelId"/>' width="200" height="130" class="py-1"><br>
	            		<s:file cssClass="form-control-file" name="hotelPic" onchange="previewImage(this)"></s:file>
	            	</div>
	            	<hr>
	            	<div class="form-group">
	            		<label>分店地址:</label>
	            		<s:textfield cssClass="form-control" name="hotel.hotelAddr" placeholder="请输入分店地址信息"></s:textfield>
	            	</div>
	            	<hr>
	            	<div class="form-group">
	            		<label>分店电话:</label>
	            		<s:textfield cssClass="form-control" name="hotel.hotelPhone" placeholder="请输入分店电话信息"></s:textfield>
	            	</div>
	            	<hr>
	            	<s:submit cssClass="btn btn-primary" value="修改分店信息"></s:submit>
	            </s:form>
	          </div>
	       </div>
     </div>
    <jsp:include page="/view/commons/footer.jsp"></jsp:include>
  </body>
</html>