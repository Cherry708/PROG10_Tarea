import java.util.ArrayList;

public class Asignatura {

    //Atributos
    private String nombre = "";
    private int curso;
    private ArrayList<Alumno> listaEstudiantes;

    //Métodos
    public Asignatura(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getCurso(){
        return this.curso;
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

    public void setListaEstudiantes(ArrayList<Alumno> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Asignatura{ "+"nombre: "+nombre+", curso: "+curso+" }";
    }
}
