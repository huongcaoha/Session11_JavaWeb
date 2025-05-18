<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/13/2025
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movies</title>
</head>
<body>
<h1>Movie List</h1>
<a href="/movies/add">Add New Movie</a>
<table border="1">
    <thead>
    <tr>
        <th>Title</th>
        <th>Director</th>
        <th>Release Date</th>
        <th>Genre</th>
        <th>Poster</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.releaseDate}</td>
            <td>${movie.genre}</td>
            <td><img style="width: 100px ; height: 100px;" src="${movie.poster}" alt="Poster" width="100"></td>
            <td>
                <a href="/movies/edit/${movie.id}">Edit</a>
                <a href="/movies/delete/${movie.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${not empty message}">
    <script>
        alert("${message}")
    </script>
</c:if>
</body>
</html>
