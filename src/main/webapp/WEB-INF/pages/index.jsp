<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<%-- AUTHORS --%>

<h3>Авторы</h3>

<div id="table-authors">
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
                    <%--<td><a href="books/${author.id}">Книги</a></td>--%>
                    <%--<td><a href="delete/${contact.id}">delete</a></td>--%>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>

<div id="form-addnew-author">

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

<%-- BOOKS --%>

<h3>Книги</h3>

<div id="table-books">
    <c:if test="${!empty bookList}">
        <table class="data">
            <tr>
                <th>Название</th>
                <th>Год</th>
                <th>Жанр</th>
            </tr>
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.year}</td>
                    <%--<td>${book.genre}</td>--%>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>

<div id="form-addnew-book">

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
