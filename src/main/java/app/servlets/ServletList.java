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
import java.util.List;

@WebServlet(name = "ServletList")
public class ServletList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list;
        UserDB userDB = UserDB.getInstance();
        list = userDB.getUsers();
        request.setAttribute("listOfUsers", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/listPage.jsp");
        requestDispatcher.forward(request, response);
    }
}
