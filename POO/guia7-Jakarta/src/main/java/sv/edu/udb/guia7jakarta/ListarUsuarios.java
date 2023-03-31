package sv.edu.udb.guia7jakarta;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ListarUsuarios", value = "/ListarUsuarios")
public class ListarUsuarios extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    private void processRequest(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

        try (PrintWriter out = response.getWriter()) {
            try {
                final String nombreCaso = request.getParameter("nameCase");
                final String descripcion = request.getParameter("description");
                final String fecha = request.getParameter("fecha");
                int idprogramador = Integer.parseInt(request.getParameter("programmer"));
                String programador = "";
                String apellidoProgramador ="";
                final String usuario = request.getParameter("usuario");
                final String password = request.getParameter("password");
                final String query = "INSERT INTO `cases`(`id_programador`, `Descripcion`, `Fecha`) VALUES ('"+idprogramador+"','"+descripcion+"','"+fecha+"')";
                Conexion con = new Conexion();
                con.setQuery(query);
                String query2 = "SELECT Nombres, Apellidos FROM `empleados` WHERE Id_Empleado = '"+idprogramador+"'";
                con.setRs(query2);
                ResultSet rs = con.getRs();
                rs.next();
                apellidoProgramador = rs.getString(2);
                programador = rs.getString(1);
                con.cerrarConexion();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro" + usuario + "</title>");
                out.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
                out.println("<link rel='stylesheet' href='css/estilo.css' >");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 class='text-center'>Usted ha registrado un usuario exitosamente</h1>");
                out.println("<section class='container text-center'>");
                out.println("<h3>Nombre del caso: </h3>" + nombreCaso);
                out.println("<h3>Descripcion del caso: </h3>" + descripcion);
                out.println("<h3>Programador encargado: </h3>" + programador +" "+ apellidoProgramador);
                out.println("<h3>Fecha de asignacion del caso: </h3>" + fecha);
                out.println("<br><a class='btn btn-light' href='jefe.jsp'>Volver</a>");
                out.println("</section>");
                out.println("</body>");
                out.println("</html>");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
