<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<link href="css/company.css" rel="stylesheet" type="text/css">

	</head>
	<body>
		<%@include file="pageheader.jsp" %>

		<div class="section large transparent dark text-center" style="background-image: url('images/background01.jpg');">
			<div class="inner" >
				<div class="container" >
					<h1>企业信息族谱分析</h1>
					<p class="lead">Analysis of enterprise information genealogy.</p>
					<form action="${pageContext.request.contextPath }/CompanyServlet?method=searchAll" id="searchForm" class="newsletter-form" method="post">
						<input type="text" id="searchInput" name="CorpName" placeholder="What are you looking for ?">
						<input type="hidden" name="rpId" id="rpId" />
						<button type="submit" name="subscribe" class="button">搜    索 ···</button>
					</form>
				</div> <!-- end .container -->
				
				
				<!-- 选项卡切换模块 -->
				<!-- 基本信息 -->
				<div class="page1" style="display: none;margin-top:-150px;">
					<div class="page-header">
						<div class="breadcrumbs" >
							<ul >
								<li><a href="#" onclick="changePage(this)">Home</a></li>
								<li>基本信息</li>
							</ul>
						</div> <!-- end .breadcrumbs -->
					</div> <!-- end .page-header -->
				
					<div id="outStruct">
						<c:if test="${not empty requestScope.companymeg}">
						<div id="tableWrapper">
							<table id="table_1">
								<tr>
									<td rowspan="4" style="width:18%;border: 1px solid #f1f2f6;">认证公司</td>
									<td colspan="2" style="font-size:18px;">公司名称：${requestScope.companymeg.CORP_NAME }</td>
								</tr>
								<tr>
									<td>电话：${requestScope.companymeg.TEL }</td>
									<td></td>
								</tr>
								<tr>
									<td>官网：${requestScope.companymeg.WEB_URL }</td>
									<td>邮箱：${requestScope.companymeg.EMAIL }</td>
								</tr>
								<tr>
									<td>地址:${requestScope.companymeg.ADDR }</td>
									<td>附近公司</td>
								</tr>
							</table>
							
							<table id="table_2">
								<tr>
									<td>注册资本：</td>
									<td>${requestScope.companymeg.REG_CAPI }</td>
									<td>成立日期：</td>
									<td>${requestScope.companymeg.START_DATE }</td>
								</tr>
								<tr>
									<td>经营状态：</td>
									<td>
										<c:if test="${requestScope.companymeg.CORP_STATUS eq '1'}">在业</c:if>
										<c:if test="${requestScope.companymeg.CORP_STATUS eq '2'}">注销</c:if>
										<c:if test="${requestScope.companymeg.CORP_STATUS eq '3'}">吊销</c:if>
										<c:if test="${requestScope.companymeg.CORP_STATUS eq '4'}">迁出</c:if>
									</td>
									<td>统一社会信用代码：</td>
									<td>${requestScope.companymeg.REG_NO }</td>
								</tr>
								<tr>
									<td>纳税人识别号：</td>
									<td>${requestScope.companymeg.TAXPAY_NUM }</td>
									<td>注册号：</td>
									<td>${requestScope.companymeg.UNI_SCID }</td>
								</tr>
								<tr>
									<td>组织机构代码：</td>
									<td>${requestScope.companymeg.ORG_INST_CODE }</td>
									<td>公司类型：</td>
									<td>${requestScope.companymeg.ECON_KIND }</td>
								</tr>
								<tr>
									<td>人员规模：</td>
									<td>${requestScope.companymeg.STAFF_SIZE }</td>
									<td>营业期限：</td>
									<td>${requestScope.companymeg.FARE_TERM_START }至${requestScope.companymeg.FARE_TERM_END }</td>
								</tr>
								<tr>
									<td>登记机关：</td>
									<td>${requestScope.companymeg.BELONG_ORG }</td>
									<td>核准日期：</td>
									<td>${requestScope.companymeg.CHECK_DATE }</td>
								</tr>
								<tr>
									<td>英文名：</td>
									<td>${requestScope.companymeg.ENGLISH_NAME }</td>
									<td>曾用名：</td>
									<td>${requestScope.companymeg.FORMER_NAME }</td>
								</tr>
								<tr>
									<td>所属地区：</td>
									<td>${requestScope.companymeg.BELONG_DIST_ORG }</td>
									<td>所属行业：</td>
									<td>${requestScope.companymeg.BELONG_TRADE }</td>
								</tr>
								<tr>
									<td>企业地址：</td>
									<td colspan="3">${requestScope.companymeg.ADDR}</td>
								</tr>
								<tr style="height:100px;">
									<td>经营范围：</td>
									<td colspan="3">${requestScope.companymeg.FARE_SCOPE }</td>
								</tr>
							</table>
						</div>
						</c:if>
					</div>
				</div>
				
				<!-- 股权结构 -->
				<div class="page2" style="display: none; margin-top:-150px;">
					<div class="page-header">
						<div class="breadcrumbs" >
							<ul >
								<li><a href="#" onclick="changePage(this)">Home</a></li>
								<li>股权结构</li>
							</ul>
						</div> <!-- end .breadcrumbs -->
					</div> <!-- end .page-header -->
					
					<div id="outStruct">
						<div></div>
					</div>					
				
					
				</div>
				
				<!-- 投资族谱 -->
				<div class="page3" style="display: none;margin-top:-150px;">
					<div class="page-header">
						<div class="breadcrumbs" >
							<ul >
								<li><a href="#" onclick="changePage(this)">Home</a></li>
								<li>投资族谱</li>
							</ul>
						</div> <!-- end .breadcrumbs -->
					</div> <!-- end .page-header -->
					
					<div id="outStruct">
						<!-- 选择层级 -->
						<div class="content">
							<div class="content1 pull-right">
								<div class="fangxiang pull-right">
									<span class="glyphicon glyphicon-triangle-top tfx" onclick="shang()"></span>
									<span class="glyphicon glyphicon-triangle-bottom bfx" onclick="xia()"></span>
								</div>
					    		<div class="stockInput">一层</div>
					    	</div>
					   		<span class="desc pull-right">股东层级：</span>
    
    
						    <div class="content1 pull-right">
						    	<div class="fangxiang pull-right">
									<span class="glyphicon glyphicon-triangle-top tfx" onclick="shang1()"></span>
									<span class="glyphicon glyphicon-triangle-bottom bfx" onclick="xia1()"></span>
						    	</div>
						    	<div class="companyInput">一层</div>
						    </div>
						    <span class="desc pull-right">对外投资层级：</span>
						</div>
						<!-- 投资族谱图显示位置 -->
						<div id="showzupu" style="width:1000px;height:600px;"></div>
						
						<div>
							<input type="hidden" value="${requestScope.companymeg.CORP_NAME }" id="CORP_NAME"/>
						</div>
					</div>	
					
				</div>
				
				<!-- 企业族谱 -->
				<div class="page4" style="display: none;margin-top:-150px;">
					<div class="page-header">
						<div class="breadcrumbs" >
							<ul >
								<li><a href="#" onclick="changePage(this)">Home</a></li>
								<li>企业族谱</li>
							</ul>
						</div> <!-- end .breadcrumbs -->
					</div> <!-- end .page-header -->
					
					<div id="outStruct">
						<!-- 企业族谱图显示位置 -->
						<div id="corpzupu" style="width:1000px;height:600px;"></div>
						
						<div>
							<input type="hidden" value="${requestScope.companymeg.ORG }" id="CORP_ORG"/>
							<input type="hidden" value="${requestScope.companymeg.SEQ_ID }" id="CORP_SEQ_ID"/>
						</div>
					</div>	
					
				</div>
				
				<!-- 疑似关系 -->
				<div class="page5" style="display: none;margin-top:-150px;">
					<div class="page-header">
						<div class="breadcrumbs" >
							<ul >
								<li><a href="#" onclick="changePage(this)">Home</a></li>
								<li>疑似关系</li>
							</ul>
						</div> <!-- end .breadcrumbs -->
					</div> <!-- end .page-header -->
					
					<div id="outStruct">
					
					</div>	
					
				</div>
				
				
				
			</div> <!-- end .inner -->
		</div> <!-- end .section -->
		<%@include file="loginandregister.jsp" %>
		
		<!-- jQuery -->
		<script src="js/jquery-3.1.0.min.js"></script>
		 <!--Scripts.js--> 
		<script src="js/scripts.js"></script>
		<!--bootstrap-->
		<script src="js/bootstrap.min.js"></script>
		<!-- 处理搜索栏部分 ，用了jquery ui部件-->
		<script src="js/jquery-3.3.1.js"></script>
		<script src="js/jquery-ui.js"></script>
		<link rel="stylesheet" href="js/jquery-ui.css">
		<!-- 数据可视化画图 -->
		<script src="js/echarts.js"></script>
		<!--自己编写的数据库-->
		<script src="js/company.js"></script>


<c:if test="${not empty requestScope.companymeg}">
	<script>
		window.onload=changestatus('none','block','none','none','none','none');
	</script>
</c:if>
	

	</body>
</html>
