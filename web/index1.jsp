<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String start;
    String end;
    String mid[];
%>
<%

    request.setCharacterEncoding("utf-8");
    start = URLDecoder.decode(request.getParameter("start"), "utf-8");
    end = URLDecoder.decode(request.getParameter("end"), "utf-8");
    mid = request.getParameterValues("textbox[]");
    System.out.println(mid);
    System.out.println(mid[1]);
%>


<!doctype html>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript"
        src="http://webapi.amap.com/maps?v=1.3&key=59c30848b234603227648f96f88f765e&plugin=AMap.Geocoder"></script>
<script>
    var dic = new Array();
    dic[0] ='<%=start%>';
    var mid = new Array();
    <%   for(int i=0;i <mid.length;i++){   %>
    mid[<%=i%>] = "<%=mid[i]%>";
    <%   }   %>
    if (mid.length != 0) {
        for (var i = 0; i < mid.length; i++) {
            dic[i + 1] = mid[i];
        }
        dic[mid.length+1]='<%=end%>';
    }
    else {
        dic[1]='<%=end%>';
    }

    var geocoder = new AMap.Geocoder({
        city: "010", //城市，默认：“全国”
        radius: 1000 //范围，默认：500
    });
    //地理编码,返回地理编码结果
    var sendmsg="";
    for (var i in dic){

        (function () {

            var temp = i;//调用时局部变量
            geocoder.getLocation(dic[i], function (status, result) {
                if (status === 'complete' && result.info === 'OK') {

                    sendmsg=sendmsg+temp;
                    geocoder_CallBack(result);
                    if (temp==dic.length-1){
                        $.ajax(
                            {
                                type: "post",
                                url: "calc.jsp",
                                dataType: 'json',
                                timeout:3000,
                                complete: function () {
                                    if(status=='timeout'){
                                        alert("超时");
                                    }
                                },
                                data: {
                                    str:sendmsg
                                },
                                error: function (XMLHttpRequest, textStatus, errorThrown) {
                                },
                                success: function (data) {
                                    alert(data[0],data[1]);
                                    var search_str="";
                                    search_str=search_str+'[{"keyword": \"<%=start%>\","city": \"北京\"}';
                                    var startindex;
                                    for (var ni=0;ni<dic.length;ni++){
                                        (function () {
                                            if (data[ni]==0){
                                                startindex=ni;
                                            }
                                        })();
                                    }
                                    for (var ni=(startindex+1)%dic.length;ni<startindex+dic.length;ni++){
                                        search_str=search_str+',{"keyword": \"'+dic[data[ni%dic.length]]+'\", "city": \"北京\"}';
                                    }

                                    search_str=search_str+',{"keyword": \"<%=start%>\","city": \"北京\"}]';
                                    driving.search(
                                        JSON.parse(search_str)
                                    );
                                }
                            }
                        );
                    }
                }
                else {
                    alert(result.info);
                }
            });


        })();

    }


    function geocoder_CallBack(data) {
        var geocode = data.geocodes;
        for (var i = 0; i < geocode.length; i++) {
            alert(geocode[i].location.getLng() + " " + geocode[i].location.getLat() + "\n");
            sendmsg=sendmsg+" "+geocode[i].location.getLng() + " " + geocode[i].location.getLat() + "\n";
        }
    }
</script>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>按起终点名称规划路线</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <style type="text/css">
        #panel {
            position: fixed;
            background-color: white;
            max-height: 90%;
            overflow-y: auto;
            top: 10px;
            right: 10px;
            width: 280px;
        }
    </style>
    <script type="text/javascript"
            src="http://webapi.amap.com/maps?v=1.3&key=59c30848b234603227648f96f88f765e&plugin=AMap.Driving"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<div id="panel"></div>
<script type="text/javascript">
    //基本地图加载

    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        zoom: 13 //地图显示的缩放级别
    });
    //构造路线导航类
    var driving = new AMap.Driving({
        map: map,
        panel: "panel"
    });
    // 根据起终点名称规划驾车导航路线

//    driving.search([
//        {keyword: '北京市地震局(公交站)',city:'北京'},
//        {keyword: '亦庄文化园(地铁站)',city:'北京'}
//    ]);
</script>
</body>
</html>