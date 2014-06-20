<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Web Application (version 5.0)</title>
    <link rel="stylesheet" type="text/css" href="common.css">
    <script src="script.js"></script>
</head>

<body>
<h2>Library Web Application</h2>
<div>
    <button id="buttonTest">Test button</button>
</div>
    <table>
        <tr>
            <td>Authors:</td>
            <td>${authors}</td>
        </tr>
    </table>

<table class="data">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Telephone</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach items="${authorList}" var="author">
        <tr>
            <td>${contact.lastname}, ${contact.firstname} </td>
            <td>${contact.email}</td>
            <td>${contact.telephone}</td>
            <td><a href="delete/${contact.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
