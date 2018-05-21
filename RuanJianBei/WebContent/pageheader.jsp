<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 头部导航栏 -->  
<header class="header fixed clearfix">
	<div class="left">
		<div class="logo"><a href="index.html"><img src="images/logo.png" class="img-responsive"></a></div> 
		<!-- end .logo -->
		<form class="header-search">
			<input type="text" placeholder="搜索" >
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
					<a href="#">基本信息</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#">股权结构</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#">投资族谱</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#">企业族谱</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#">疑似关系</a>
				</li>
			</ul>
		</nav> <!-- end .main-nav -->
	</div> <!-- end .navigation -->
		
	<div class="right">
		<a href="" class="button login-open">登录</a>
	</div> <!-- end .left -->
</header> <!-- end .header -->
		
<!-- 登陆注册模块 -->
<div class="login-wrapper">
	<div class="login">
		<form>
			<div class="form-group">
				<input type="text" placeholder="账号 *">
			</div> <!-- end .form-group -->
			<div class="form-group">
				<input type="text" placeholder="密码 *">
			</div> <!-- end .form-group -->
			<div class="clearfix">
				<div class="checkbox">
					<label>
						<input type="checkbox"> 记住我
					</label>
				</div>
				<a href="" class="lost-password">忘记密码 ?</a>
			</div> <!-- end .clearfix -->
			<div class="button-wrapper"><button type="submit" class="button">登录</button></div>
			<div class="text-center">
				<p>注册新账户 ? <a href="" class="signup-open">注册</a></p>
				<div class="social">
					<p>Connect with Social Networks</p>
					<a href=""><img src="images/facebook.png" alt="facebook"></a>
					<a href=""><img src="images/twitter.png" alt="twitter"></a>
					<a href=""><img src="images/google-plus.png" alt="google plus"></a>
				</div> <!-- end .social -->
			</div>
		</form>
	</div> <!-- end .login -->
</div> 
<!-- end .login-wrapper -->
		
		