<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 登陆模块 -->
<div class="login-wrapper">
	<div class="login">
		<form>
			<div class="form-group">
				<input type="text" placeholder="账号 *">
			</div>
			<!-- end .form-group -->
			<div class="form-group">
				<input type="text" placeholder="密码 *">
			</div>
			<!-- end .form-group -->
			<div class="clearfix">
				<div class="checkbox">
					<label> <input type="checkbox"> 记住我
					</label>
				</div>
				<a href="" class="lost-password">忘记密码 ?</a>
			</div>
			<!-- end .clearfix -->
			<div class="button-wrapper">
				<button type="submit" class="button">登录</button>
			</div>
			<div class="text-center">
				<p>
					注册新账户 ? <a href="" class="signup-open">注册</a>
				</p>
				<div class="social">
					<p>Connect with Social Networks</p>
					<a href=""><img src="images/facebook.png" alt="facebook"></a>
					<a href=""><img src="images/twitter.png" alt="twitter"></a> <a
						href=""><img src="images/google-plus.png" alt="google plus"></a>
				</div>
				<!-- end .social -->
			</div>
		</form>
	</div>
	<!-- end .login -->
</div>
<!-- end .login-wrapper -->

<!-- 注册模块 -->
<div class="signup-wrapper">
	<div class="signup">
		<form>
			<div class="form-group">
				<input type="text" placeholder="账户">
			</div>
			<!-- end .form-group -->
			<div class="form-group">
				<input type="email" placeholder="邮箱">
			</div>
			<!-- end .form-group -->
			<div class="text-center">
				<p>A password will be e-mailed to you.</p>
			</div>
			<!-- end .text-center -->
			<div class="button-wrapper">
				<button type="submit" class="button">注册</button>
			</div>
			<div class="text-center">
				<p>
					Already have an account? <a href="" class="login-open">登录</a>
				</p>
				<div class="social">
					<p>Connect with Social Networks</p>
					<a href=""><img src="images/facebook.png" alt="facebook"></a>
					<a href=""><img src="images/twitter.png" alt="twitter"></a> <a
						href=""><img src="images/google-plus.png" alt="google plus"></a>
				</div>
				<!-- end .social -->
			</div>
		</form>
	</div>
	<!-- end .signup -->
</div>
<!-- end .signup-wrapper -->