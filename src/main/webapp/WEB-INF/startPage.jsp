<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="get" method="post" class="form-example">
    <div class="form-example">
        <label for="id">Enter ID of employee to show it: </label>
        <input type="text" name="id" id="id"/>
        <br>
        <button type="submit">SHOW EMPLOYEE</button>


    </div>
</form>
<hr>
<form action="create" method="post" class="form-example">
    <div class="form-example">
        <label for="first_name">Enter First Name of employee:</label>
        <input type="text" name="first_name" id="first_name"/>
        <br>
        <label for="last_name">Enter Last Name of employee: </label>
        <input type="text" name="last_name" id="last_name"/>
        <br>
        <label for="email">Enter E-mail of employee: </label>
        <input type="text" name="email" id="email"/>
        <br>
        <label for="phone_number">Enter Phone Number of employee: </label>
        <input type="text" name="phone_number" id="phone_number"/>
        <br>
        <label for="hire_date">Enter Hire Date of employee: </label>
        <input type="text" name="hire_date" id="hire_date"/>
        <br>
        <label for="salary">Enter Salary of employee: </label>
        <input type="text" name="salary" id="salary"/>
        <br>
        <label for="commission_pct">Enter Commission PCT of employee: </label>
        <input type="text" name="commission_pct" id="commission_pct"/>
        <br>
        <label for="department_id">Enter Department ID of employee: </label>
        <input type="text" name="department_id" id="department_id"/>
        <br>
        <button type="submit">ADD EMPLOYEE</button>


    </div>
</form>
<hr>
<form action="change-login" method="post" class="form-example">
    <div class="form-example">
        <label for="id_cl">Enter ID of employee to change login it: </label>
        <input type="text" name="id" id="id_cl"/>
        <br>
        <label for="first_name_cl">Enter First Name of employee to change: </label>
        <input type="text" name="first_name" id="first_name_cl"/>
        <br>
        <button type="submit">UPDATE EMPLOYEE</button>
    </div>
</form>


<hr>
<form action="delete" method="post" class="form-example">
    <div class="form-example">
        <label for="id_d">Enter ID of employee to delete it: </label>
        <input type="text" name="id" id="id_d"/>
        <br>
        <button type="submit">DELETE EMPLOYEE</button>


    </div>
</form>

</body>
</html>
