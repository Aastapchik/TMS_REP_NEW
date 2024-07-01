package teachmyskill.task.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import teachmyskill.task.database.Connect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static teachmyskill.task.database.Connect.getConnect;

@WebServlet("/get")
public class ServletGetUser extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                req.setAttribute("ID", resultSet.getString("employee_id"));
                req.setAttribute("firstName", resultSet.getString("first_name"));
                req.setAttribute("lastName", resultSet.getString("last_name"));
                req.setAttribute("email", resultSet.getString("email"));
                req.setAttribute("phoneNumber", resultSet.getString("phone_number"));
                req.setAttribute("hireDate", resultSet.getString("hire_date"));
                req.setAttribute("salary", resultSet.getString("salary"));
                req.setAttribute("commissionPCT", resultSet.getString("commission_pct"));
                req.setAttribute("departmentID", resultSet.getString("department_id"));
            }
            getServletContext().getRequestDispatcher("/WEB-INF/dataUserDB.jsp").forward(req, resp);
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/WEB-INF/errorPage.jsp").forward(req, resp);
        }

    }
}
