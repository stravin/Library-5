<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Web Application (version 5.0)</title>
    <link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
    <%--<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>--%>
    <script src="<c:url value="/resources/js/script.js" />"></script>
</head>

<body>
<h1>Библиотека</h1>

<%--<div>--%>
    <%--<button id="buttonTest">Test button</button>--%>
<%--</div>--%>

<h3>Авторы</h3>

<c:if test="${!empty authorList}">
    <table class="data">
        <tr>
            <th>Ф.И.О.</th>
            <th>Год рождения</th>
            <th>Биография</th>
        </tr>
        <c:forEach items="${authorList}" var="author">
            <tr>
                <td>${author.fio}</td>
                <td>${author.yearOfBirth}</td>
                <td>${author.biography}</td>
                    <%--<td><a href="delete/${contact.id}">delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
