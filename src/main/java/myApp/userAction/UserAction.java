package myApp.userAction;

import myApp.DTO.CreateUser;
import myApp.dataBase.Connect;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class UserAction {

    public boolean deletingUser(int id, Model model) {
        Connection connection = null;
        try {
            connection = Connect.getInstance().getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            model.addAttribute("name", id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean creatingUser(CreateUser user) {

        Connection connection = null;
        ResultSet resultSet = null;
        int ID = 0;
        try {
            connection = Connect.getInstance().getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            PreparedStatement maxID = connection.prepareStatement("SELECT MAX(EMPLOYEE_ID) FROM EMPLOYEES");

            resultSet = maxID.executeQuery();

            while (resultSet.next()) ID = resultSet.getInt("max");

            preparedStatement.setInt(1, ID + 1);
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.geteMail());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setDate(6, user.getHireDate());
            preparedStatement.setDouble(7, user.getSalary());
            preparedStatement.setDouble(8, user.getCommissionPCT());
            preparedStatement.setInt(9, user.getDepartmentID());
            preparedStatement.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }


    public boolean updatingUser(int id, String name) {
        Connection connection = null;
        try {
            connection = Connect.getInstance().getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE EMPLOYEES SET FIRST_NAME = ? WHERE EMPLOYEE_ID = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean gettingUser(int id, Model model) {

        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = Connect.getInstance().getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                model.addAttribute("ID", resultSet.getString("employee_id"));
                model.addAttribute("firstName", resultSet.getString("first_name"));
                model.addAttribute("lastName", resultSet.getString("last_name"));
                model.addAttribute("email", resultSet.getString("email"));
                model.addAttribute("phoneNumber", resultSet.getString("phone_number"));
                model.addAttribute("hireDate", resultSet.getString("hire_date"));
                model.addAttribute("salary", resultSet.getString("salary"));
                model.addAttribute("commissionPCT", resultSet.getString("commission_pct"));
                model.addAttribute("departmentID", resultSet.getString("department_id"));
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
