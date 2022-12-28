<%--
  Created by IntelliJ IDEA.
  User: soaniaina
  Date: 2022-12-27
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        <%@include file="../../assets/css/bootstrap.min.css"%>
    </style>
    <title>Student Form App</title>
</head>
<body>
    <jsp:include page="../includes/_header.jsp" />

    <div class="container">
        <div class="col-6 offset-3">
            <c:if test="${student != null}">
            <h2 class="text-center text-info my-3">Edit Student</h2>
            <form action="${pageContext.request.contextPath}/update" method="post">
                </c:if>
                <c:if test="${student == null}">
                <h2 class="text-center text-primary my-3">Add Student</h2>
                <form action="${pageContext.request.contextPath}/insert" method="post">
                    </c:if>
                    <c:if test="${student != null}">
                        <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                    </c:if>
                    <div class="form-group mb-3">
                        <label for="firstname">Firstname : </label>
                        <input type="text" name="firstname" id="firstname" value="${student.firstname}" class="form-control" placeholder="Enter your firstname please ... " autocomplete="off" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="lastname">Lastname : </label>
                        <input type="text" name="lastname" id="lastname" value="${student.lastname}" class="form-control" placeholder="Enter your lastname ... " autocomplete="off" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="address">Address : </label>
                        <input type="text" id="address" name="address" value="${student.address}" class="form-control" placeholder="Enter your address ... " autocomplete="off" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="telephone">Phone number : </label>
                        <input type="tel" name="telephone" value="${student.telephone}" pattern="[0-9]{1,10}" class="form-control" id="telephone" placeholder="Enter your phone number ... " autocomplete="off"
                               title="Cette champ n'accepte que des valeurs numérique avec une longueur de 10 chiffres..." required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="matriculate">Matriculate : </label>
                        <input type="text" name="matricule" value="${student.matricule}" pattern="[0-9]{1,4}" title="Cette champ n'accepte que des valeurs numérique avec une longueur de 4 chiffres..." class="form-control"id="matriculate" placeholder="Enter your matriculate ... " autocomplete="off" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="email">Email : </label>
                        <input type="email" name="email" value="${student.email}" id="email"  class="form-control" placeholder="Enter your email ... " autocomplete="off" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="niveau">Level : </label>
                        <input type="text" name="niveau" value="${student.niveau}" id="niveau"  class="form-control" placeholder="Enter your level, for example 'first year of university' ... " autocomplete="off" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="mention">Cycle : </label>
                        <input type="text" name="mention" value="${student.mention}" id="mention" class="form-control" placeholder="Enter your cycle, for example DA2I or RPM ... " autocomplete="off" required>
                    </div>
                    <div class="mb-5">
                        <c:choose>
                            <c:when test="${ not empty student }">
                                <input type="submit" class="btn btn-sm btn-outline-primary px-5" value="EDIT">
                            </c:when>
                            <c:otherwise>
                                <input type="submit" class="btn btn-sm btn-outline-info px-5" value="SAVE">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </form>
        </div>
    </div>
</body>
</html>
