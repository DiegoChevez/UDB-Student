package complementario.settings;

import java.sql.SQLException;

public abstract class MetodosCRUD {

	public abstract void crearRegistros()  throws SQLException;
	
	public abstract void mostrarRegistros() throws SQLException;
	
	public abstract void actualizarRegistros()  throws SQLException;
	
	public abstract void eliminarRegistros()  throws SQLException;
	
}
