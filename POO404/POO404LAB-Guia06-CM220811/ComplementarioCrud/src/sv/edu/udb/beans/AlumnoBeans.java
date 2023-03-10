package sv.edu.udb.beans;

public class AlumnoBeans {

    int idAlumno;
    String nombreAlumno;
    String apellidoAlumno;
    int edadAlumno;
    String direccionAlumno;

    public AlumnoBeans (int idAlumno, String nombreAlumno, String apellidoAlumno, int edadAlumno, String direccionAlumno){

        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.edadAlumno = edadAlumno;
        this.direccionAlumno = direccionAlumno;
    }

    public int getIdAlumno() {
        return idAlumno;
    }
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    public String getNombreAlumno() {
        return nombreAlumno;
    }
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }
    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }
    public int getEdadAlumno() {
        return edadAlumno;
    }

    public void setEdadAlumno(int edadAlumno){
        this.edadAlumno = edadAlumno;
    }

    public String getDireccionAlumno(){
        return direccionAlumno;
    }
    public void setDireccionAlumno(String direccionAlumno) {
        this.direccionAlumno = direccionAlumno;
    }


}
