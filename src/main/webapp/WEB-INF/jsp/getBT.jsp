<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.07.2024
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GET INFO</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<form action="${pageContext.request.contextPath}/user/get" method="post">
    <label for="inputID" class="form-label">Enter the ID of employee</label>
    <input type="number" id="inputID" class="form-control" name="id"  aria-describedby="helpForUser">
    <div id="helpForUser" class="form-text">
        Enter the ID of the employee whose information you want to view
    </div>
    <button type="submit" class="btn btn-primary">SHOW THE INFORMATION</button>
</form>
<form action="${pageContext.request.contextPath}/">
    <input type="submit" class="btn btn-primary" value="GO BACK TO HOME PAGE" />
</form>
</body>
</html>