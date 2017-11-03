<%@ page import="java.net.URLDecoder" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="Util.HibernateUtils" %>
<%@ page import="entity.ListEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.sf.json.JSONArray" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="javax.management.Query" %>
<%@ page import="entity.ProductEntity" %>
<%@ page import="entity.CarEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
%>
<%
    Session sessions=null;

    try {

        sessions = HibernateUtils.getSession();
        sessions.beginTransaction();

        double sum=0;
        List<Integer> p=(List<Integer>) sessions.createQuery("select product from ListEntity ").list();
        Iterator iterator=p.iterator();
        while (iterator.hasNext()){
            List<ProductEntity> productEntities=(List<ProductEntity>) sessions.createQuery("from ProductEntity where id = ?").setParameter(0,iterator.next()).list();
            for (ProductEntity productEntity:productEntities){
                sum=sum+productEntity.getWeight();
            }
        }
        List<CarEntity> carEntities=(List<CarEntity>) sessions.createQuery("from CarEntity where volum >?").setParameter(0,sum).list();
        JSONArray jsonArray=JSONArray.fromObject(carEntities);
        System.out.println(jsonArray.toString());
        sessions.getTransaction().commit();
        response.getWriter().write(jsonArray.toString());
    }catch(Exception e) {
        e.printStackTrace();
        sessions.getTransaction().rollback();
    }finally {
        HibernateUtils.closeSession(sessions);
    }
%>
