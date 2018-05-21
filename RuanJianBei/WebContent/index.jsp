<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>

		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Home</title>

		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- Style.css -->
		<link href="css/style.css" rel="stylesheet">
		<!--添加的css-->
		<link href="css/company.css">

	</head>
	<body>
		<%@include file="pageheader.jsp" %>
		

		<div class="section large transparent dark text-center" style="background-image: url('images/background01.jpg');">
			<div class="inner" >
				<div class="container" >
					<h1>企业信息族谱分析</h1>
					<p class="lead">Analysis of enterprise information genealogy.</p>
					<form>
						<div class="row">
							<div class="col-sm-4">
								<div class="form-group">
									<input type="text" placeholder="What are you looking for ?">
								</div> <!-- end .form-group -->
							</div> <!-- end .col-sm-4 -->
							
						</div> <!-- end .row -->
					</form>
				</div> <!-- end .container -->
			</div> <!-- end .inner -->
		</div> <!-- end .section -->
		


		
		
		
		<!-- jQuery -->
		<script src="js/jquery-3.1.0.min.js"></script>
		 <!--Scripts.js--> 
		<script src="js/scripts.js"></script>
		<!--bootstrap-->
		<script src="js/bootstrap.min.js"></script>
		<!--自己编写的数据库-->
		<script src="js/company.js"></script>
	</body>
</html>
