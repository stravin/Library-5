<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Библиотека &gt; Авторы</title>
    <link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
</head>

<body>
<h1>Библиотека</h1>

<h3>Авторы</h3>

<div id="list">
    <c:if test="${!empty authorList}">
        <table class="list">
            <tr>
                <th>Ф.И.О.</th>
                <th>Год рождения</th>
                <th>Биография</th>
                <th>Книги автора</th>
            </tr>
            <c:forEach items="${authorList}" var="author">
                <tr>
                    <td>${author.fio}</td>
                    <td>${author.yearOfBirth}</td>
                    <td>${author.biography}</td>
                    <td><a href="books/${author.id}">Книги</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<div id="edit">
    <form:form method="post" action="addauthor" commandName="author">
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
                <td><form:input path="biography"/></td>
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
