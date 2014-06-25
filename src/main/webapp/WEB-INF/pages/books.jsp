<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Библиотека &gt; Все книги</title>
    <link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
</head>

<body>
<h1>Библиотека</h1>

<h3>
    <a href="/authors">Авторы</a> |
    <span class="naviCurrentPage">Книги</span> |
    <a href="/genres">Жанры</a>
</h3>

<div id="list">
    <c:if test="${!empty bookList}">
        <table class="list">
            <tr>
                <th>Название</th>
                <th>Год</th>
                <th>Жанр</th>
                <th>Авторы</th>
                <th>Редактировать книгу</th>
            </tr>
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.year}</td>
                    <td>${book.genre.name}</td>
                    <td>
                        <c:forEach items="${book.authors}" var="author" varStatus="loopStatus">
                            <span>${author.fio}</span><c:if test="${!loopStatus.last}">, </c:if>
                        </c:forEach>
                    </td>
                    <td><a href="/books/edit/${book.id}">Редактировать</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<div id="edit">
    <form:form method="post" action="/books/add" commandName="book">
        <table>
            <td colspan="2">
                <strong>Добавить</strong>
            </td>
            <tr>
                <td>Название</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Год</td>
                <td><form:input path="year"/></td>
            </tr>
            <tr>
                <td>Жанр</td>
                <td>
                    <form:select path="genre.id">
                        <form:option value="0" label="--- Выберите ---"/>
                        <form:options items="${genreList}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </td>
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
