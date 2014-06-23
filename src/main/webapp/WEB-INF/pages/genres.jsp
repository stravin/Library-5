<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Библиотека &gt; Жанры</title>
    <link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
</head>

<body>
<h1>Библиотека</h1>

<a href="/authors">&lt; Назад</a>

<h3>Жанры</h3>

<div id="list">
    <c:if test="${!empty genreList}">
        <table class="list">
            <tr>
                <th>Название</th>
            </tr>
            <c:forEach items="${genreList}" var="genre">
                <tr>
                    <td>${genre.name}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<div id="edit">
    <form:form method="post" action="addgenre" commandName="genre">
        <table>
            <td colspan="2">
                <strong>Добавить</strong>
            </td>
            <tr>
                <td>Название</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Сохранить"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
