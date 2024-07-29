<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.06.2024
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUCCESSFUL CREATED</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<style>
    body {
        background: #ececec url('data:image/svg+xml,%3Csvg width="42" height="44" viewBox="0 0 42 44" xmlns="http://www.w3.org/2000/svg"%3E%3Cg id="Page-1" fill="none" fill-rule="evenodd"%3E%3Cg id="brick-wall" fill="%239C92AC" fill-opacity="0.4"%3E%3Cpath d="M0 0h42v44H0V0zm1 1h40v20H1V1zM0 23h20v20H0V23zm22 0h20v20H22V23z"/%3E%3C/g%3E%3C/g%3E%3C/svg%3E');
    }

    .shadow {
        font-family: Mr Dafoe, sans-serif;
        font-size: 16em;
        text-align: center;
        text-shadow: 0 -3px 0 #333,
        0 6px 8px rgba(0, 0, 0, .4),
        0 9px 10px rgba(0, 0, 0, .15),
        0 30px 10px rgba(0, 0, 0, .18),
        0 15px 10px rgba(0, 0, 0, .21);
    }
</style>

<body>
<link href="https://fonts.googleapis.com/css?family=Mr+Dafoe" rel="stylesheet">
<div class="shadow">The user was created successfully</div>
<form action="${pageContext.request.contextPath}/">
    <input type="submit" class="btn btn-primary" value="GO BACK TO HOME PAGE" />
</form>
</body>
</html>