<%--
  Created by IntelliJ IDEA.
  User: soaniaina
  Date: 2022-12-27
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="text-center my-5">
    <h1 class="text-warning">Student Management</h1>
    <h4>
        <a href="${pageContext.request.contextPath}/new">Add New Student</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/list">List All Students</a>
    </h4>
</div>
