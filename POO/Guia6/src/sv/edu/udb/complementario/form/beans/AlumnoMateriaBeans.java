package sv.edu.udb.complementario.form.beans;

public class AlumnoMateriaBeans {

    int codReporte;
    int codMateria;
    int codAlumno;

    public AlumnoMateriaBeans(int codReporte, int codMateria, int codAlumno){

        this.codReporte = codAlumno;
        this.codMateria = codMateria;
        this.codAlumno = codAlumno;

    }

    public int getCodAlumno(){
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno){
        this.codAlumno = codAlumno;
    }

    public int getCodMateria(){
        return codMateria;
    }

    public void setCodMateria(int codMateria){
        this.codMateria = codAlumno;
    }

    public int getCodReporte(){
        return codReporte;
    }

    public void setCodReporte(int codReporte){
        this.codReporte = codReporte;
    }

}
