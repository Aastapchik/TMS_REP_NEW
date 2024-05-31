package teachmyskill.task.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

import static teachmyskill.task.database.Connect.getConnect;
@WebServlet("/create")
public class CreateUserServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, Integer.parseInt(req.getParameter("id_c")));
            preparedStatement.setString(2, req.getParameter("first_name"));
            preparedStatement.setString(3, req.getParameter("last_name"));
            preparedStatement.setString(4, req.getParameter("email"));
            preparedStatement.setString(5, req.getParameter("phone_number"));
            preparedStatement.setDate(6, Date.valueOf(req.getParameter("hire_date")));
            preparedStatement.setDouble(7, Double.parseDouble(req.getParameter("salary")));
            preparedStatement.setDouble(8, Double.parseDouble(req.getParameter("commission_pct")));
            preparedStatement.setInt(9, Integer.parseInt(req.getParameter("department_id")));
            preparedStatement.executeUpdate();
            resp.getWriter().write("SUCCESSFUL UPDATE!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
