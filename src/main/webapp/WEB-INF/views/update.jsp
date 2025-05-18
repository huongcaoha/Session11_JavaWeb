<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Movie</title>
</head>
<body>
<h1>Add New Movie</h1>

<form:form action="/movies/edit" modelAttribute="movieDtoUpdate" method="post" enctype="multipart/form-data">
    <form:input path="id" type="hidden"/>
    <form:label path="title">Title:</form:label>
    <form:input type="text"  path="title"/>
    <form:errors path="title" cssStyle="color: red"/>
    <br><br>
    <form:label path="director">Director:</form:label>
    <form:input type="text"  path="director"/>
    <form:errors path="director" cssStyle="color: red"/>
    <br><br>
    <form:label path="releaseDate">ReleaseDate:</form:label>
    <form:input type="date"  path="releaseDate"/>
    <form:errors path="releaseDate" cssStyle="color: red"/>
    <br><br>
    <form:label path="genre">Genre:</form:label>
    <form:input type="text"  path="genre"/>
    <form:errors path="genre" cssStyle="color: red"/>
    <br><br>

    <form:label path="poster">Poster:</form:label>
    <form:input type="file"  path="poster"/>
    <form:errors path="poster" cssStyle="color: red"/>
    <c:if test="${not empty image}">
        <img style="width: 80px; height: 80px;" src="${image}" alt="Movie Poster">
    </c:if>
    <br><br>

    <button type="submit">Update</button>
</form:form>
<br><br><button><a href="/movies">Quay lại</a></button>
</body>
</html>
