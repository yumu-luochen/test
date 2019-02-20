<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/view/commons/taglibs.jsp"%>
<script>
          function loginOut(){
             if(confirm("您好,${loginedUser.userName},确认要退出系统吗?")){
               location.href='<s:url namespace="/login" action="loginOut"/>';
             }
          }
     </script>
<div class="container" style="background-color: rgba(187,255,255,0.7)">
	<div class="col-lg-3">
		<a class="navbar-brand " href="#"> <img
			src="<c:url value='/imgs/icon.jpg'/>" width="30" height="30"
			class="d-inline-block align-top" alt="你说这是什么"> <b>落尘酒店客房管理系统</b>
			<br>
		</a>
	</div>
</div>
<div class="container" style="white-space:nowrap">

	<nav class="navbar navbar-expand-lg nav-justified  navbar-light"
		style=" margin-left:-15px; margin-right:-15px;background-color: rgba(187,255,255,0.7);">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse " id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto ">
				<li class="nav-item"><a class="nav-link"
					href='<s:url namespace="/login" action="home"/>'>首页 </a></li>
				<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 分店管理 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href='<s:url namespace="/hotel" action="toInput"/>'>新开分店</a> <a
							class="dropdown-item"
							href='<s:url namespace="/hotel" action="loadHotels"/>'>分店列表</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 客房管理 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href='<s:url namespace="/room" action="toInput"></s:url>'>客房登记</a>
						<a class="dropdown-item"
							href='<s:url namespace="/room" action="loadRoom"></s:url>'>客房列表</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 预订管理 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<s:url namespace="/reservation" action="toInput"/>">客房预订</a> 
						<a class="dropdown-item" href="<s:url namespace="/reservation" action="loadReservation"/>">预订列表</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 客户管理 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<s:url namespace="/customer" action="toInput"/>">客户登记</a> <a
							class="dropdown-item" href="<s:url namespace="/customer" action="loadCustomer"/>">客户列表</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 食品管理 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<s:url namespace="/food" action="toInputFood"/>">食品添加</a>
						<a class="dropdown-item" href="<s:url namespace="/food" action="loadFood"/>">食品列表</a>
						<a class="dropdown-item" href="<s:url namespace="/food" action="toInputFoodCategory"/>">食品分类添加</a>
						<a class="dropdown-item" href="<s:url namespace="/food" action="loadFoodCategory"/>">食品分类列表</a>
					</div></li>
			<!--  	<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 财务管理 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">数据视图</a>
					</div></li>	
			-->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 系统维护 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<s:url namespace="/login" action="toInput"/>">操作员添加</a>
						<a class="dropdown-item" href="<s:url namespace="/login" action="loadAdmin"/>">操作员列表</a>
					</div></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"> <i
						class="fas fa-user"></i> 质管部：${loginedAdmin.adminName}
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="javascript:loginOut();">退出系统</a></li>
			</ul>
		</div>
	</nav>
</div>
