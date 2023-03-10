package sv.edu.udb.complementario.form.beans;

public class AlumnoBeans {

    int codAlumno;
    String nombreAlumno;
    String apellidoAlumno;
    int edadAlumno;
    String direccionAlumno;

    public AlumnoBeans(int codAlumno, String nombreAlumno, String apellidoAlumno, int edadAlumno, String direccionAlumno){

        this.codAlumno = codAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.edadAlumno = edadAlumno;
        this.direccionAlumno = direccionAlumno;

    }

    public int getCodAlumno(){
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno){
        this.codAlumno = codAlumno;
    }

    public String getNombreAlumno(){
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno){
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno(){
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno){
        this.apellidoAlumno = apellidoAlumno;
    }

    public int getEdadAlumno(){
        return edadAlumno;
    }

    public void setEdadAlumno(int edadAlumno){
        this.edadAlumno = edadAlumno;
    }

    public String getDireccionAlumno(){
        return  direccionAlumno;
    }

    public void setDireccionAlumno(String direccionAlumno){
        this.direccionAlumno = direccionAlumno;
    }





}
