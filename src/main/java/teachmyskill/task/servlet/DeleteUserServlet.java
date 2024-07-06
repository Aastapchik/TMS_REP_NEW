package teachmyskill.task.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static teachmyskill.task.database.Connect.getConnect;
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Connection connection = null;
        try {
            connection = getInstanse().getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
    
            req.setAttribute("name", id);
            getServletContext().getRequestDispatcher("/WEB-INF/deleteUser.jsp").forward(req,resp);
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/WEB-INF/errorPage.jsp").forward(req, resp);
        }

    }
}
