package com.teachMeSkills.task.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/save-request")
public class ServletSaveRequest extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        req.setAttribute("name", name);
        req.setAttribute("surname", surname);
        req.setAttribute("age", age);

        if (name.isEmpty() || surname.isEmpty() || age.isEmpty()) {
            getServletContext().getRequestDispatcher("/inputForm.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/userdata.jsp").forward(req, resp);
        }
    }
}
