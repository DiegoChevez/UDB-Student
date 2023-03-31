package sv.edu.udb.users;

import sv.edu.udb.users.beans.UserBeans;
import sv.edu.udb.users.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDatos {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;



    private static final String SQL_SELECT = "Select * from usuarios";



}
