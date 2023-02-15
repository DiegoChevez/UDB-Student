package sv.edu.udb.persona;
import java.sql.*;
import sv.edu.udb.util.*;
import javax.swing.JOptionPane;

public class IngresoDatos {

	private int id;
	 private String ids;
	 private String nombre;
	 private int edad;
	 private String edads;
	 private String telefono;
	 private String sexo;
	 private int idocupacion;
	 private String idocupacions;
	 private String fechanac;
	 
	 private Connection conexion;
	 private ResultSet rs;
	 private Statement s;
	 
	 public IngresoDatos() {
		 
		 try {
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 conexion = DriverManager.getConnection("jdbc:mysql://localhost/personabdd","root","");
			 
			 s = conexion.createStatement();
			 
			ingreso(); 
			s.executeUpdate("Insert into persona values("+id+",\""+nombre+"\","+edad+",\""+telefono+"\",\""+sexo+"\","+idocupacion+",\""+fechanac+"\")");
			 
			JOptionPane.showMessageDialog(null, "Persona Ingresada Correctamente");
			 
		 }
		 
		 catch(ClassNotFoundException e1) {
				System.out.println("ERROR:No encuentro el driver de la BD:"+e1.getMessage());

		 }
		 catch(SQLException e2) {
				System.out.println("ERROR:Fallo en SQL: "+e2.getMessage());
	 
		 }
		  
	 }

	@SuppressWarnings("unused")
	private void obtenerOcupacion() throws SQLException {

		rs = s.executeQuery("select count(*) from ocupaciones");
		
		int tamanio = 0;
		while(rs.next()) {
			
			tamanio = rs.getInt(1);
			
		}
		
		String[] options2 = new String [tamanio];
		int contador = 0;
		rs = s.executeQuery("select * from ocupaciones");
		String texto = "";
		while(rs.next()) {
			
			options2[contador] = rs.getString("ocupacion");
			contador++;
		}
		idocupacions = (String) JOptionPane.showInputDialog(null,"Seleccione una ocupación", "ocupacion persona", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
		rs = s.executeQuery("select id_ocupacion from ocupaciones where ocupacion ='" + idocupacions + "'");
		while(rs.next()) {
			
			idocupacion = rs.getInt(1);			
		}
		
	}
	
	public void ingreso() throws SQLException {
		
		 ids = JOptionPane.showInputDialog("Ingrese el ID");
		 id = Integer.parseInt(ids);
		 nombre = JOptionPane.showInputDialog("Ingrese el Nombre");
		 edads = JOptionPane.showInputDialog("Ingrese la edad");
		 edad = Integer.parseInt(edads);
		 telefono = JOptionPane.showInputDialog("Ingrese su Telefono");
		 
		 do {
			 if (MatchTelephone.compareTelephone(telefono) == true)
			 {
				 break;
				 }else{
				 JOptionPane.showMessageDialog(null, "Numero de Telefono invalido");
				 telefono=JOptionPane.showInputDialog("Ingrese su Telefono");
				  
			 }
			 
			 
		 }while(true);
		 
		 String[] options = {"Femenino", "Masculino"};
		 sexo = (String) JOptionPane.showInputDialog(null, "¿Ingrese el sexo?","Sexo persona", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		 obtenerOcupacion();
		
		
	}
	
	public void mostrardatos() throws SQLException{
		 rs = s.executeQuery ("select * from persona");
		 while (rs.next())
		 {
		 JOptionPane.showMessageDialog(null,"ID:"+rs.getString("id_persona")+
		 "\nNombre: "+rs.getString("nombre_persona")+
		 "\nEdad: "+rs.getInt("edad_persona")+
		 "\nSexo: "+rs.getString("telefono_persona")
		 );
	   }
	}
	
	public void cierreconexion() throws SQLException{
		 if (conexion != null){
		 conexion.close();
		 }
	}
	
	public static void main(String[] args) throws SQLException
	 {
	 IngresoDatos ing=new IngresoDatos();
	 ing.mostrardatos();
	 ing.cierreconexion();
	 
	 }

}
