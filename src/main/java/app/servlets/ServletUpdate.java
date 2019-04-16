package app.servlets;

import app.entities.User;
import app.modul.UserDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdate")
public class ServletUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String language = request.getParameter("language");
        UserDB userDB = UserDB.getInstance();
        User user = new User(id, age, name, language);
        userDB.updateUser(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));
        UserDB userDB = UserDB.getInstance();
        User user = userDB.getUserById(id);
        request.setAttribute("previousUser",user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/updatePage.jsp");
        requestDispatcher.forward(request, response);
    }
}
