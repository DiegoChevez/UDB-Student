package sv.edu.udb.guia7jakarta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(name = "GeneraSession", urlPatterns = {"/GeneraSession"})
public class GenerarSession extends HttpServlet {
    protected void doPost(final HttpServletRequest request, final HttpServletResponse
            response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(final HttpServletRequest request, final HttpServletResponse
            response)
            throws ServletException, IOException {
        final HttpSession sessionActual = request.getSession(true);
        final String operacion = request.getParameter("operacion");
        if ("salir".equals(operacion)) {
            sessionActual.setAttribute("USER", null);
            sessionActual.setAttribute("NAME", null);
            response.sendRedirect("principal.jsp");
        } else if ("logueo".equals(operacion)) {
            final String usuario = request.getParameter("usuario");
            final String password = request.getParameter("password");
            try {
                Conexion con = new Conexion();
                con.setRs("select count(usuario),nombre_persona, id_ocupacion from persona" + " where usuario='" + usuario + "' and " + "contrasenia='" + password + "'");
                ResultSet rs = con.getRs();
                rs.next();
                if (rs.getInt(1) == 1) { //solo una coincidencia es permitida
                    sessionActual.setAttribute("USER", usuario);
                    sessionActual.setAttribute("NAME", rs.getString(2));
                    sessionActual.setAttribute("ROL", rs.getString(3));
                    int rol = Integer.parseInt(rs.getString(3));

                    switch (rol) {
                        case 1:     response.sendRedirect("principal.jsp");
                            break;
                        case 2:     response.sendRedirect("jefe.jsp");
                            break;
                        case 3:     response.sendRedirect("jefedesarrollo.jsp");
                            break;
                        case 4:     response.sendRedirect("empleado.jsp");
                            break;
                        case 5:     response.sendRedirect("programador.jsp");
                            break;
                    }

                } else {
                    response.sendRedirect("login.jsp");
                }
                rs.close();
                con.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}