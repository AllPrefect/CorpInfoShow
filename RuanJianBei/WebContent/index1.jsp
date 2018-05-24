<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet" href="js/jquery-ui.css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-ui.js"></script>
<!-- 处理搜索栏部分 ，用了jquery ui部件-->
<script>
	$(function(){
		$(".rph").focus(function(){
			$(".rph").autocomplete({  
		    	minLength: 0,  
		        source: function( request, response ) {  
		        $.ajax({
		           type : "POST",
		           dataType : "JSON",
		           url : '${pageContext.request.contextPath }/Companyservlet',
		           data : {
		           		"name" : $(".rph").val(),
		           		"method":"search"
		           	},
		           success : function(data) {
		           		console.log(data);  
	                    response( $.map( data, function( item ) {  
							return {  
								label: item.corp_NAME,  
	                            value: item.corp_NAME  
	                        }  
	                     }));  
					}  
	            });
	          	},  
	            focus: function( event, ui ) {  
	            	$(".rph").val( ui.item.label );  
	                $("#rpId").val( ui.item.value );  
	                return false;  
	            },  
	            select: function( event, ui ) {  
	                $(".rph").val( ui.item.label );  
	                $("#rpId").val( ui.item.value );  
	                return false; 
	            }    
	         }); 
		});
	});
</script>
		
		<!-- <script type="text/javascript">
			$(function(){
				$("#searchmeg").click(function(){
					 $.ajax({
		           			type : "POST",
		           			dataType : "JSON",
		           			url : '${pageContext.request.contextPath }/Companyservlet',
		           			data : {
		           				"sc" : $(".rph").val(),
		           				"method":"searchmeg"
		           			},
		           			success : function(data) {
		        				//遍历返回的JsonArray
		        				$.each(data, function(index, data) {
		        					/* $("#brxmSelect").append($("<option></option>").append(data.corp_NAME).attr("value",data.corp_NAME)); */
		        					$("table").append($("<tr><td>公司名</td><td></tr>"))
		        				});
				})
			});
		</script> -->

<!-- 给搜索按钮添加点击事件 -->
<script type="text/javascript">
	function searchmeg(url){
		var name=$(".rph").val();
			var u=url+"&name="+name
			location.href=u;
	} 
</script>
		
</head>
<body>
	<div class="ui-widget">
		<label for="tags">公司名: </label> 
		<input type="text" name="phName" value="" id="phName" class="rph"> 
		<input type="hidden" name="rpId" id="rpId" />
		<a href="javascript:searchmeg('${pageContext.request.contextPath }/Companyservlet?method=searchmeg')"><input  id="searchmeg" type="button" value="搜索" ></a>
	</div>
	<table border="1" >
		<tr>
			<td >公司名</td>
			<td style="width:200px; ">${requestScope.companymeg.CORP_NAME }</td>
			<td >地址</td>
			<td style="width:200px; ">${requestScope.companymeg.ADDR }</td>
		</tr>
		
	</table>
	<a href="javascript:showzupu('${requestScope.companymeg.CORP_NAME }')">查看公司族谱</a>
	<div id="showzupu"></div>
</body>
<!--显示公司对外投资族谱  -->
	<script type="text/javascript">
		var myChart = echarts.init(document.getElementById('showzupu'));
		function showzupu(name) {
			$.ajax({
				type : "POST",
				dataType : "JSON",
				url : '${pageContext.request.contextPath }/Companyservlet',
				data : {
					"name" : name,
					"method" : "touzizupu"
				},
				success : function(result) {
					console.log(result);
					myChart.setOption({
						tooltip : {
							trigger : 'item',
							triggerOn : 'mousemove'
						},
						series : [ {
							type : 'tree',
							data : [ result ],
							top : '5%',
							layout : 'radial',
							symbol : 'circle',
							symbolSize : 10,
							itemStyle : {//树图中每个节点的样式
								normal : {
									color : '#ffffff',
									borderColor : '#b03a5b',
									borderWidth : 2
								},
								emphasis : {
									color : '#000',
									borderColor : '#b03a5b',
									borderWidth : 5
								}
							},
							label: {
								show:true,
								formatter: function(params) {
						              var result = "";
						              	if(params.name!=undefined){
						              		result+=params.name+"\n";
						              }
						              	if(params.value!=undefined){
						              		result+=params.value+"\n";
						              }
						              return result;
						           },
							},
							initialTreeDepth : 3,
							animationDurationUpdate : 750
						} ]

					});
				}
			})

		}
	</script>
</html>
