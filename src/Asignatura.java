import java.util.ArrayList;

public class Asignatura {

    //Atributos
    private String nombre = "";
    private int curso;
    private Profesor profesor;
    private ArrayList<Alumno> listaEstudiantes;

    //Métodos
    public Asignatura(){}

    public String getNombre(){
        return this.nombre;
    }

    public int getCurso(){
        return this.curso;
    }

    public Profesor getProfesor(){
        return this.profesor;
    }

    public ArrayList<Alumno> getListaEstudiantes(){
        return this.listaEstudiantes;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setListaEstudiantes(ArrayList<Alumno> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Asignatura{ "+"nombre: "+nombre+", curso: "+curso+", profesor: "+profesor+" }";
    }
}
