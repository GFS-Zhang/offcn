<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="static\echarts.min.js"></script>
    <script type="text/javascript" src="static\jquery.min.js"></script>
  </head>
  
  <body>
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '图书价格柱状图'
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '价格',
                type: 'bar',
                data: []
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
       myChart.showLoading();
        var names=[];
        var price=[];
        $.ajax({
        type:'get',
        async:'true',
        url:'getbook1',
        data:{},
        dataType:'json',
        success:function(result){
        	if(result){
        		for(var i=0;i<result.length;i++){
        			names.push(result[i].bookName);
        			price.push(result[i].price);
        		}
        		myChart.hideLoading();
        		myChart.setOption({
        			xAxis: {
               			 data:names
           			},
           			series: [{
              			data: price
           			}]
        		})
        	}
        },
        })
    </script>
  </body>
</html>
