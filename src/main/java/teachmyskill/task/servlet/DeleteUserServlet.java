package teachmyskill.task.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static teachmyskill.task.database.Connect.getConnect;
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Connection connection = getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            resp.getWriter().write("SUCCESSFUL DELETE!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
