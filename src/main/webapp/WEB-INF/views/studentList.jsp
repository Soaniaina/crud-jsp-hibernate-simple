<%--
  Created by IntelliJ IDEA.
  User: soaniaina
  Date: 2022-12-27
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student List App</title>
    <style>
        <%@include file="../../assets/css/bootstrap.min.css"%>
    </style>
</head>
<body>
    <jsp:include page="../includes/_header.jsp" />

    <div class="container">
        <h2 class="text-center text-danger my-4">List of Students</h2>
        <table class="table table-hover table-striped text-center">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Fullname</th>
                    <th>E-mail</th>
                    <th>Niveau</th>
                    <th>Mention</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty studentList}">
                        <c:forEach var="student" items="${studentList}">
                            <tr>
                                <td><c:out value="${student.id}" /></td>
                                <td><c:out value="${student.firstname}" /> <c:out value="${student.lastname}" /></td>
                                <td><c:out value="${student.email}" /></td>
                                <td><c:out value="${student.niveau}" /></td>
                                <td><c:out value="${student.mention}" /></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/edit?id=<c:out value='${student.id}' />" class="btn btn-sm btn-outline-primary">Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${student.id}' />" class="btn btn-sm btn-outline-danger">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="6"><h3 style="color: red;text-align: center">Pas de résultat à afficher !!!</h3></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>
</body>
</html>