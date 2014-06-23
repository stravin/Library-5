<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Библиотека &gt; Книги</title>
    <link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
</head>

<body>
<h1>Библиотека</h1>

<a href="/authors">&lt; Назад</a>

<h3>Книги автора ${author.fio}</h3>

<div id="list">
    <c:if test="${!empty bookList}">
        <table class="list">
            <tr>
                <th>Название</th>
                <th>Год</th>
                <th>Жанр</th>
            </tr>
                <%--<c:forEach items="${bookList}" var="book">--%>
            <c:forEach items="${author.books}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.year}</td>
                    <td>${book.genre.name}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<div id="edit">
    <form:form method="post" action="addbook" commandName="book">
        <table>
            <tr>
                <td>Название</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Год</td>
                <td><form:input path="year"/></td>
            </tr>
                <%--<tr>--%>
                <%--<td>Жанр</td>--%>
                <%--<td><form:input path="genre"/></td>--%>
                <%--</tr>--%>
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
