import java.util.ArrayList;

public abstract class Alumno extends Persona {

    //Atributos
    private int curso;
    private String nivelAcademico = "";
    private ArrayList<String> asignaturas;

    //Métodos
    public Alumno(){}

    public int getCurso(){
        return curso;
    }

    public String getNivelAcademico(){
        return nivelAcademico;
    }

    public ArrayList<String> getListaAsignaturas(){
        return asignaturas;
    }

    public void setCurso(int curso){
        this.curso = curso;
    }

    public void setNivelAcademico(String nivelAcademico){
        this.nivelAcademico = nivelAcademico;
    }

    public void setListaAsignaturas(ArrayList<String> asignaturas){
        this.asignaturas = asignaturas;
    }

    public abstract double pagoMensual();

    public abstract String mostrarAsignaturas();

}
