<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee</title>
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
<p class = "header1">CREATE NEW EMPLOYEE</p>
<form action="${pageContext.request.contextPath}/user/create" method="post" class="row g-3">
    <div class="col-md-6">
        <label for="inputFirstName" class="form-label">First Name</label>
        <input type="text" class="form-control" name="FirstName" id="inputFirstName">
    </div>
    <div class="col-md-6">
        <label for="inputLastName" class="form-label">Last Name</label>
        <input type="text" class="form-control" name="LastName" id="inputLastName">
    </div>
    <div class="col-12">
        <label for="inputEMail" class="form-label">e-Mail</label>
        <input type="email" class="form-control" id="inputEMail" name="eMail" placeholder="username@gmail.com">
    </div>
    <div class="col-12">
        <label for="inputPhoneNumber" class="form-label">Phone Number</label>
        <input type="text" class="form-control" id="inputPhoneNumber" name="PhoneNumber" placeholder="375-29-XXX-XX-XX">
    </div>
    <div class="col-md-4">
        <label for="inputHireDate" class="form-label">Hire Date</label>
        <input type="text" class="form-control" id="inputHireDate" name="HireDate" placeholder="YYYY-MM-DD">
    </div>
    <div class="col-md-4">
        <label for="inputSalary" class="form-label">Salary</label>
        <input type="text" class="form-control" name="Salary" id="inputSalary">
    </div>
    <div class="col-md-4">
        <label for="inputCommissionPCT" class="form-label">Commission PCT</label>
        <input type="text" class="form-control" name="CommissionPCT" id="inputCommissionPCT">
    </div>
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <label for="inputDepartmentID" class="form-label">Department ID</label>
        <input type="text" class="form-control" name="DepartmentID" id="inputDepartmentID">
    </div>
    <div class="col-md-4"></div>
    <div class="col-md-6">
        <button type="submit" class="btn btn-primary">Create employee</button>
    </div>
</form>

    <div class="col-md-6">
        <form action="${pageContext.request.contextPath}/">
            <input type="submit" class="btn btn-primary" value="GO BACK TO HOME PAGE" />
        </form>
    </div>

</body>
</html>
