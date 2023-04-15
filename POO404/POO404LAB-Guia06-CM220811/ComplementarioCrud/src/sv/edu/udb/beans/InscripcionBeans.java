package sv.edu.udb.beans;

public class InscripcionBeans {
	int idReporte;
	int idAlumno;
	String nombreAlumno;
	int idMateria;
	String nombreMateria;

	public InscripcionBeans (int idReporte,int idAlumno,String nombreAlumno,int idMateria,String nombreMateria){
		this.idReporte = idReporte;
		this.idMateria = idMateria;
		this.nombreMateria = nombreMateria;
		this.idAlumno = idAlumno;
		this.nombreMateria = nombreAlumno;
	}
	public int getIdReporte(){return idReporte;}
	public void setIdReporte(){this.idReporte=idReporte;}

	public int getIdAlumno(){return idAlumno;}
	public void setIdAlumno(int idAlumno){this.idAlumno=idAlumno;}

	public String getNombreAlumno(){return nombreAlumno;}
	public void setNombreAlumno(String nombreAlumno){this.nombreAlumno = nombreAlumno;}

	public int getIdMateria(){return idMateria;}
	public void setIdMateria(int idMateria){this.idMateria=idMateria;}

	public String getNombreMateria(){return nombreMateria;}
	public void setNombreMateria(String nombreMateria){this.nombreMateria=nombreMateria;}





}
