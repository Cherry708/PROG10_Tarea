import java.util.ArrayList;

public abstract class Alumno extends Persona {

    //Atributos
    private int curso;
    private String nivelAcademico;
    private ArrayList<Asignatura> listaAsignaturas;
    private String tipoDeAlumno;

    //Métodos
    public Alumno(){}

    public int getCurso(){
        return curso;
    }

    public String getNivelAcademico(){
        return nivelAcademico;
    }

    public ArrayList<Asignatura> getListaAsignaturas(){
        return listaAsignaturas;
    }

    public String getTipoDeAlumno(){
        return tipoDeAlumno;
    }

    public void setCurso(int curso){
        this.curso = curso;
    }

    public void setNivelAcademico(String nivelAcademico){
        this.nivelAcademico = nivelAcademico;
    }

    public void setListaAsignaturas(ArrayList<Asignatura> asignaturas){
        this.listaAsignaturas = asignaturas;
    }

    public void setTipoDeAlumno(String tipoDeAlumno){
        this.tipoDeAlumno = tipoDeAlumno;
    }

    public abstract double pagoMensual();

    public abstract String mostrarAsignaturas();

}
