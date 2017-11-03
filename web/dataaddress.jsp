<%@ page import="java.net.URLDecoder" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="Util.HibernateUtils" %>
<%@ page import="entity.ListEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String start;
    String end;//mid中的一个
    List<String> mid=new ArrayList<>();
%>
<%
    //从数据库中读取地址
    mid.clear();
    start="昌平区东小口中滩村";
    Session sessions=null;
    try {

        sessions = HibernateUtils.getSession();
        sessions.beginTransaction();

        List<ListEntity> listEntities = (List<ListEntity>)sessions.createQuery("from ListEntity").list();
        for (ListEntity listEntity:listEntities){
            mid.add(listEntity.getAddress());
        }
        System.out.println(mid.size());
        System.out.println(mid.get(0));
        System.out.println(mid.get(mid.size()-1));
        sessions.getTransaction().commit();
    }catch(Exception e) {
        e.printStackTrace();
        sessions.getTransaction().rollback();
    }finally {
        HibernateUtils.closeSession(sessions);
    }


%>


<!doctype html>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript"
        src="http://webapi.amap.com/maps?v=1.3&key=59c30848b234603227648f96f88f765e&plugin=AMap.Geocoder"></script>
<script>
    //将地址拼接成字符串
    var dic = new Array();
    dic[0] ='<%=start%>';
    var mid = new Array();
    <%   for(int i=0;i <mid.size();i++){   %>
    mid[<%=i%>] = "<%=mid.get(i)%>";
    <%   }   %>
    if (mid.length != 0) {
        for (var i = 0; i < mid.length; i++) {
            dic[i + 1] = mid[i];
        }
    }

    //构建地图
    var geocoder = new AMap.Geocoder({
        city: "010", //城市，默认：“全国”
        radius: 1000 //范围，默认：500
    });
    //地理编码,返回地理编码结果（经纬度）
    var sendmsg=[];
    var numb=0;
    for (var i=0;i<dic.length;i++){
        (function (arg) {
            geocoder.getLocation(dic[i], function (status, result) {
                if (status === 'complete' && result.info === 'OK') {
                    geocoder_CallBack(result,arg);
                }
                else {
                    alert(result.info);
                }
            });
        })(i);


    }
    //
    function compare(property){
        return function(a,b){
            var value1 = a[property];
            var value2 = b[property];
            return value1 - value2;
        }
    }

    function geocoder_CallBack(data,arg) {
        var geocode = data.geocodes;
        for (var i = 0; i < geocode.length; i++) {
            sendmsg.push({index:arg,x:geocode[i].location.getLng(),y:geocode[i].location.getLat()});
        }
        numb++;
        if (numb==dic.length){
            var ssmes="";
            sendmsg.sort(compare('index'));
            for (var i=0;i<sendmsg.length;i++ ){
                ssmes=ssmes+sendmsg[i].index+" "+sendmsg[i].x+" "+sendmsg[i].y+"\n";
            }
            alert(ssmes)
            //发后台请求计算
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
                            str:ssmes
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                        },
                        success: function (data) {
                            //拼接字符串
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
                            for (var ni=(startindex+1);ni<startindex+dic.length;ni++){
                                search_str=search_str+',{"keyword": \"'+dic[data[ni%dic.length]]+'\", "city": \"北京\"}';
                            }

                            search_str=search_str+',{"keyword": \"<%=start%>\","city": \"北京\"}]';
                            //将后台算法算完后的路径顺序输入到api中计算
                            driving.search(
                                JSON.parse(search_str)
                            );
                        }
                    }
                );
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