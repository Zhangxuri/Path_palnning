<%@ page import="java.net.URLDecoder" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="Util.HibernateUtils" %>
<%@ page import="entity.ListEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.sf.json.JSONArray" %>
<%@ page import="entity.ProductEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
%>
<%
    Session sessions = null;

    try {

        sessions = HibernateUtils.getSession();
        sessions.beginTransaction();

        List<ProductEntity> productEntities = (List<ProductEntity>) sessions.createQuery("from ProductEntity ").list();
        JSONArray jsonArray = JSONArray.fromObject(productEntities);
        System.out.println(jsonArray.toString());
        sessions.getTransaction().commit();
        response.getWriter().write(jsonArray.toString());
    } catch (Exception e) {
        e.printStackTrace();
        sessions.getTransaction().rollback();
    } finally {
        HibernateUtils.closeSession(sessions);
    }
%>
