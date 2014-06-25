<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Библиотека &gt; Авторы книги</title>
    <link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
</head>

<body>
<h1>Библиотека</h1>

<a href="/books">&lt; Назад</a>

<h3>Авторы книги "${book.name}"</h3>

<div id="list">
    <c:if test="${!empty book.authors}">
        <table class="list">
            <tr>
                <th>Имя автора</th>
            </tr>
            <c:forEach items="${book.authors}" var="author">
                <tr>
                    <td>${author.fio}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<form:select path="authors" multiple="true">
    <form:options items="${authorList}" itemLabel="fio" itemValue="id"/>
</form:select>

</body>
</html>
