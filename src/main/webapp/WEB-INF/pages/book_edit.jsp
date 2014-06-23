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

<a href="/books">&lt; Отмена</a>

<h3>Редактирование книги</h3>

<div id="edit">
    <form:form method="post" action="/books/update" commandName="book">
        <form:hidden path="id"/>
        <table>
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
