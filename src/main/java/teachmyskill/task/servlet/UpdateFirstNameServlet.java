package teachmyskill.task.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static teachmyskill.task.database.Connect.getConnect;

@WebServlet("/change-login")
public class UpdateFirstNameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String newFistName = req.getParameter("first_name");
        Connection connection = null;

        try {
            connection = getInstanse().getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE EMPLOYEES SET FIRST_NAME = ? WHERE EMPLOYEE_ID = ?");
            preparedStatement.setString(1, newFistName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            getServletContext().getRequestDispatcher("/WEB-INF/updateUser.jps").forward(req, resp);
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/WEB-INF/errorPage.jsp").forward(req, resp);
        }

    }
}

