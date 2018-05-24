<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 头部导航栏 -->  
<header class="header fixed clearfix">
	<div class="left">
		<div class="logo"><a href="index.jsp"><img src="images/logo.png" class="img-responsive"></a></div> 
		<!-- end .logo -->
		<form class="header-search" action="${pageContext.request.contextPath }/CompanyServlet?method=searchAll" id="searchForm" method="post">
			<input type="text" placeholder="搜索"  id="searchInputTop" name="CorpName">
			<button type="submit" class="btn btn-default"  style="outline: none;">
				<span class="glyphicon glyphicon-search"></span>
			</button>
		</form>
	</div> 
	<!-- end .left -->
			
	<div class="navigation clearfix">
		<nav class="main-nav">
			<ul class="list-unstyled">
				<li class="menu-item-has-children">
					<a href="#" id="card1" onclick="changePage(this)">基本信息</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#" id="card2" onclick="changePage(this)">股权结构</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#" id="card3" onclick="changePage(this)">投资族谱</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#" id="card4" onclick="changePage(this)">企业族谱</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#" id="card5" onclick="changePage(this)">疑似关系</a>
				</li>
			</ul>
		</nav> <!-- end .main-nav -->
	</div> <!-- end .navigation -->
		
	<div class="right">
		<a href="" class="button login-open">登录</a>
	</div> <!-- end .left -->
		
</header> <!-- end .header -->
		

				