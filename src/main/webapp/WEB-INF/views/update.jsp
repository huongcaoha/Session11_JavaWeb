<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Movie</title>
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

        form {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: auto;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        input[type="file"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="file"] {
            padding: 3px;
        }

        .error {
            color: red;
            font-size: 0.9em;
        }

        button {
            background-color: #007BFF;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            background-color: #0056b3;
        }

        .back-button {
            display: inline-block;
            margin-top: 20px;
            text-align: center;
        }

        .back-button a {
            text-decoration: none;
            color: #007BFF;
        }

        .back-button a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Add New Movie</h1>

<form:form action="/movies/edit" modelAttribute="movieDtoUpdate" method="post" enctype="multipart/form-data">
    <form:input path="id" type="hidden"/>

    <form:label path="title">Title:</form:label>
    <form:input type="text" path="title"/>
    <form:errors path="title" cssStyle="error"/>

    <form:label path="director">Director:</form:label>
    <form:input type="text" path="director"/>
    <form:errors path="director" cssStyle="error"/>

    <form:label path="releaseDate">Release Date:</form:label>
    <form:input type="date" path="releaseDate"/>
    <form:errors path="releaseDate" cssStyle="error"/>

    <form:label path="genre">Genre:</form:label>
    <form:input type="text" path="genre"/>
    <form:errors path="genre" cssStyle="error"/>

    <form:label path="poster">Poster:</form:label>
    <form:input type="file" path="poster"/>
    <form:errors path="poster" cssStyle="error"/>

    <c:if test="${not empty image}">
        <img style="width: 80px; height: 80px;" src="${image}" alt="Movie Poster">
    </c:if>

    <button type="submit">Update</button>
</form:form>

<div class="back-button">
    <button><a href="/movies">Quay lại</a></button>
</div>
</body>
</html>