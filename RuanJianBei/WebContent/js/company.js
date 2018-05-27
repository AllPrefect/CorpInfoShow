$(document).ready(function(){
	$(".header-search button").css("background", "none");
	
	//页面输入搜索
	$("#searchInput").bind("keypress", function(event){
		if(event.keyCode==13){
			$("#searchForm").submit();
		}
	});
	
	//导航栏输入搜索
	$(".header-search").bind("keypress", function(event){
		if(event.keyCode==13){
			$(".header-search").submit();
		}
	});
	
//=============================================================================
	
	//页面中间搜索框功能模块
	$("#searchInput").focus(function(){
		$("#searchInput").autocomplete({  
	    	minLength: 0,
	        source: function( request, response ) {  
	        $.ajax({
	           type : "POST",
	           dataType : "JSON",
	           url : 'CompanyServlet',
	           data : {
	           		"CorpName" : $("#searchInput").val(),
	           		"method":"searchName"
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
            	$("#searchInput").val( ui.item.label );  
                $("#rpId").val( ui.item.value );  
                return false;  
            },  
            select: function( event, ui ) {  
                $("#searchInput").val( ui.item.label );  
                $("#rpId").val( ui.item.value );  
                return false; 
            }    
         }); 
	});
//=================================================================================
	//导航栏部分模糊匹配公司名
	$("#searchInputTop").focus(function(){
		$("#searchInputTop").autocomplete({  
	    	minLength: 0,
	        source: function( request, response ) {  
	        $.ajax({
	           type : "POST",
	           dataType : "JSON",
	           url : 'CompanyServlet',
	           data : {
	           		"CorpName" : $("#searchInputTop").val(),
	           		"method":"searchName"
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
            	$("#searchInputTop").val( ui.item.label );  
                $("#rpId").val( ui.item.value );  
                return false;  
            },  
            select: function( event, ui ) {  
                $("#searchInputTop").val( ui.item.label );  
                $("#rpId").val( ui.item.value );  
                return false; 
            }    
         }); 
	});
//=================================================================================

});
//=================================================================================
//显示公司对外投资族谱  
var myChart = echarts.init(document.getElementById('showzupu'));
function showzupu() {
	myChart.showLoading();//数据加载完之前先显示一段简单的loading动画
	$.ajax({
		type : "POST",
		dataType : "JSON",
		url : 'CompanyServlet',
		data : {
			"CORP_NAME" :  $("#CORP_NAME").val(),
			"method" : "touzizupu"
		},
		success : function(result) {
			console.log(result);
			var r=getJsonTree(result,"");
			myChart.hideLoading(); 
			drawTree(r);
		}
	})

} 
//显示树
function drawTree(treeData) {
	myChart.setOption({
		tooltip : {
			trigger : 'item',
			triggerOn : 'mousemove'
		},
		series : [ {
			type : 'tree',
			data : treeData,
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
//=================================================================================
//处理ajax返回的字符串为符合echarts规范的树状串
var getJsonTree=function(data,parentId){
  var itemArr=[];
  for(var i=0;i<data.length;i++){ 
      var node=data[i];
      //data.splice(i, 1)
       if(node.parentId==parentId ){ 
          var newNode={name:node.id,value:node.value,children:getJsonTree(data,node.id)};
          itemArr.push(newNode);              
       }
  }
  return itemArr;
}

//=================================================================================
//投资族谱中的层级切换
var step= ['一层','二层','三层','四层','五层','六层'];
var shuru = $(".shuru");
var shuru1 = $(".shuru1");
var i = 0;
var j = 0;
function shang(){
  i++;
  shuru.text(step[i]);
  if(i>=5) i=5;
}
function xia(){
  i--;
  shuru.text(step[i]);
  if(i<=0) i=0;
}
function shang1(){
  j++;
  shuru1.text(step[j]);
  if(j>=5) j=5;
}
function xia1(){
  j--;
  shuru1.text(step[j]);
  if(j<=0) j=0;
}

//=================================================================================

//页面选项卡切换
function changestatus(a,b,c,d,e,f){
	$(".container").css('display', a)
	$(".page1").css('display', b);
	$(".page2").css('display', c);
	$(".page3").css('display', d);
	$(".page4").css('display', e);
	$(".page5").css('display', f);
}
function changePage(obj){
	if(obj.innerHTML=="基本信息"){
		changestatus("none","block","none","none","none","none");
	}if(obj.innerHTML=="股权结构"){
		changestatus("none","none","block","none","none","none");
	}if(obj.innerHTML=="投资族谱"){
		showzupu();
		changestatus("none","none","none","block","none","none");
	}if(obj.innerHTML=="企业族谱"){
		changestatus("none","none","none","none","block","none");
	}if(obj.innerHTML=="疑似关系"){
		changestatus("none","none","none","none","none","block");
	}if(obj.innerHTML=="Home"){
		changestatus("block","none","none","none","none","none");
	}
	
}

