<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Библиотека &gt; Книги автора</title>
    <link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
</head>

<body>
<h1>Библиотека</h1>

<a href="/authors">&lt; Назад</a>

<h3>Книги автора ${author.fio}</h3>

<div id="list">
    <c:if test="${!empty author.books}">
        <table class="list">
            <tr>
                <th>Название</th>
                <th>Год</th>
                <th>Жанр</th>
            </tr>
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

<a href="/books">Добавить</a>

</body>
</html>
