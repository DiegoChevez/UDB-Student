package sv.edu.udb.complementario.form.beans;

import sv.edu.udb.form.MateriasView;

public class MateriaBeans {

    int codMateria;
    String nombreMateria;
    String descripcionMateria;

    public MateriaBeans(int codMateria, String nombreMateria, String descripcionMateria){

    this.codMateria = codMateria;
    this.nombreMateria = nombreMateria;
    this.descripcionMateria = descripcionMateria;

    }

    public int getCodMateria(){
        return codMateria;
    }
    public void setCodMateria(int CodMateria){
        this.codMateria = CodMateria;
    }

    public String getNombreMateria(){
        return nombreMateria;
    }

    public void setNombreMateria(){
        this.nombreMateria = nombreMateria;
    }

    public String getDescripcionMateria(){
        return descripcionMateria;
    }

    public void setDescripcionMateriaMateria(){
        this.descripcionMateria = descripcionMateria;
    }
}
