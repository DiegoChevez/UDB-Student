package sv.edu.udb.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Services", value = "/Services")
public class Services extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDatos userDatos;

    public  Services(){
        this.userDatos = new UserDatos();


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();

        switch (action){
            case "/new":
                showNewForm(request,response);
                break;
            case "/insert":
                break;
            case "/delete":
                break;
            case "/edit":
                break;
            case "/update":
                break;
        }
    }

    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request,response);

    }

    protected void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {


    }

}
