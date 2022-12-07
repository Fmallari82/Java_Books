<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
<div class = "container m3">
<h1 class = "text-center"> Books </h1>
<table class="table table-dark">
    <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Language</th>
            <th scope="col">Number of Pages</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${allBooks}" var ="book">
        <tr>
            <td><a href="/books/${book.id}">${book.id}</a></td>
            <td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
            <td><a href="/books/${book.id}"><c:out value="${book.description}"/></a></td>
            <td><a href="/books/${book.id}"><c:out value="${book.language}"/></a></td>
            <td><a href="/books/${book.id}">${book.numberOfPages}</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</div>
</body>
</html>