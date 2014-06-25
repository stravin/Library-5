<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Библиотека &gt; Книги</title>
    <link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/script_book_edit.js" />"></script>
</head>

<body>
<h1>Библиотека</h1>

<a href="/books">&lt; Отмена</a>

<h3>Редактирование книги</h3>

<div id="edit">
    <table>
        <tr>
            <td>
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
                            <td>Авторы</td>
                            <td>
                                <form:select path="authorids" multiple="true" class="multipleSelect bookauthors">
                                    <form:options items="${book.authors}" itemLabel="fio" itemValue="id"/>
                                </form:select>
                                <input type="button" id="buttonDeleteAuthors" value=" X " title="Удалить выбранных"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Сохранить"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </td>
            <td>
                <div><strong>Все авторы</strong></div>
                <form:select path="allauthors" id="allauthors" multiple="true" class="multipleSelect allauthors">
                    <form:options items="${allauthors}" itemLabel="fio" itemValue="id"/>
                </form:select>
                <div><input type="button" id="buttonAddAuthors" value=" << " title="Добавить авторов"/></div>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
