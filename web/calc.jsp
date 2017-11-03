<%@ page import="java.net.URLDecoder" %>
<%@page language="java" import="com.Tabu" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.sf.json.JSONArray" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String str;
%>
<%
    request.setCharacterEncoding("utf-8");
    str=request.getParameter("str");
    System.out.println(str);
    System.out.println("Start....");
    String[] len = str.split("\n");
    System.out.println(len.length+"changdu");
    Tabu tabu = new Tabu(len.length, 10000, 200, 20);

    tabu.init(str);
    long t1 = System.currentTimeMillis();
    tabu.solve();
    System.out.println();
    System.out.println("计算用时：" + (System.currentTimeMillis() - t1));

    int[] best=tabu.getBestGh();
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < best.length; i++) {
        list.add(best[i]);
    }
//将list装换为Json数组（JSONArray）
    JSONArray arry = JSONArray.fromObject(list);
    System.out.println("-------\n"+arry.toString()+"-------\n");
    response.getWriter().write(arry.toString());

%>