<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.05.2024
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DATABASE_INFO</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<p>Данные для пользователя с ID = ${ID}</p>
<p>EMPLOYEE_ID: ${ID}</p>
<p>FIRST_NAME: ${firstName}</p>
<p>LAST_NAME: ${lastName}</p>
<p>EMAIL: ${email}</p>
<p>PHONE_NUMBER: ${phoneNumber}</p>
<p>HIRE_DATE: ${hireDate}</p>
<p>SALARY: ${salary}</p>
<p>COMMISSION_PCT: ${commissionPCT}</p>
<p>DEPARTMENT_ID: ${departmentID}</p>

<div class="col-md-6">
    <form action="${pageContext.request.contextPath}/">
        <input type="submit" class="btn btn-primary" value="GO BACK TO HOME PAGE" />
    </form>
</div>
</body>
</html>
