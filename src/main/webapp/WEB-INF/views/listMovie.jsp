<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movies</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        a {
            text-decoration: none;
            color: #007BFF;
        }

        a:hover {
            text-decoration: underline;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        img {
            border-radius: 5px;
        }

        .actions a {
            margin-right: 10px;
        }
    </style>
</head>
<body>
<h1>Movie List</h1>
<a href="/movies/add">Add New Movie</a>
<table>
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
            <td><img style="width: 100px; height: 100px;" src="${movie.poster}" alt="Poster"></td>
            <td class="actions">
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