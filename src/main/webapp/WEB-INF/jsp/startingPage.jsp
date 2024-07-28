<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.07.2024
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<style>
    .header1 {
        text-align: center;
        color: purple;
        font-weight: bold;
    }
</style>
<body>
<p class = "header1">PLEASE, CHOOSE THE ACTION</p>

    <form action="${pageContext.request.contextPath}/user/get">
        <button type="submit" class="btn btn-info">GET INFO ABOUT EMPLOYEE</button>
    </form>

    <form action="${pageContext.request.contextPath}/user/create">
        <button type="submit" class="btn btn-success">CREATE NEW EMPLOYEE</button>
    </form>

    <form action="${pageContext.request.contextPath}/user/delete">
        <button type="submit" class="btn btn-danger">DELETE INFO ABOUT EMPLOYEE</button>
    </form>

    <form action="${pageContext.request.contextPath}/user/change-login">
        <button type="submit" class="btn btn-warning">CHANGE LOGIN OF EMPLOYEE</button>
    </form>

</body>
</html>
