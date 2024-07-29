<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.07.2024
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/change-login" method="post">
    <div class="mb-3">
        <label for="userID" class="form-label">Enter the ID</label>
        <input type="number" class="form-control" name="id" id="userID">
    </div>
    <div class="mb-3">
        <label for="newLogin" class="form-label">Enter the NEW name</label>
        <input type="text" class="form-control" name="login" id="newLogin">
    </div>
    <button type="submit" class="btn btn-primary">UPDATE MY FIRST NAME</button>
</form>
<form action="${pageContext.request.contextPath}/">
    <input type="submit" class="btn btn-primary" value="GO BACK TO HOME PAGE" />
</form>
</body>
</html>