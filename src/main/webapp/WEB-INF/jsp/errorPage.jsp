<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.06.2024
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR PAGE</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<p>Ooops, что-то пошло не так. Вернитесь на главную страницу и попробуйте еще раз.</p>

<div class="col-md-6">
    <form action="${pageContext.request.contextPath}/">
        <input type="submit" class="btn btn-primary" value="GO BACK TO HOME PAGE" />
    </form>
</div>
</body>
</html>
