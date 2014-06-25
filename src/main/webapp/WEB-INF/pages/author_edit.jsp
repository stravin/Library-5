<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Библиотека &gt; Авторы</title>
    <link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
</head>

<body>
<h1>Библиотека</h1>

<a href="/authors">&lt; Отмена</a>

<h3>Редактирование автора</h3>

<div id="edit">
    <form:form method="post" action="/authors/update" commandName="author">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>Ф.И.О.</td>
                <td><form:input path="fio"/></td>
            </tr>
            <tr>
                <td>Год рождения</td>
                <td><form:input path="yearOfBirth"/></td>
            </tr>
            <tr>
                <td>Биография</td>
                <td><form:textarea path="biography"/></td>
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
