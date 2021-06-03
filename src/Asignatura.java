import java.util.ArrayList;

/**
 * Asignatura es la clase para todas las asignaturas y presenta
 * los atributos y métodos comunes a ellas.
 *
 * @author Rubén Serrano Cano.
 * @version 1.0
 */
public class Asignatura {


    //Atributos
    /**
     * Nombre de la asignatura.
     */
    private String nombre = "";
    /**
     * Curso en que se imparte la asignatura.
     */
    private int curso;
    /**
     * Lista de los estudiantes en esta asignatura
     */
    private ArrayList<Alumno> listaEstudiantes;

    //Métodos

    /**
     * Método constructor de Asignatura, que asigna los parámetros
     * suministrados a los atributos nombre y curso.
     * @param nombre Nombre de la asignatura.
     * @param curso Curso en que se imparte la asignatura.
     */
    public Asignatura(String nombre, int curso){
        this.nombre = nombre;
        this.curso = curso;
    }

    /**
     * Método que devuelve el nombre de la asignatura.
     * @return Nombre de la asignatura.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Método que devuelve el curso en que imparte la asignatura.
     * @return Curso en que se imparte la asignatura.
     */
    public int getCurso(){
        return this.curso;
    }

    /**
     * Método que devuelve la lista de los estudiantes en esta asignatura.
     * @return Lista de los estudiantes en esta asignatura.
     */
    public ArrayList<Alumno> getListaEstudiantes(){
        return this.listaEstudiantes;
    }

    /**
     * Método que asigna el parámetro suministrado al nombre.
     * @param nombre Nombre de la asignatura.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Método que asigna el parámetro suministrado al curso.
     * @param curso Curso en que se imparte la asignatura.
     */
    public void setCurso(int curso) {
        this.curso = curso;
    }

    /**
     * Método que asigna el parámetro suministrado a la lista de estudiantes.
     * @param listaEstudiantes Lista de estudiantes en esta asignatura.
     */
    public void setListaEstudiantes(ArrayList<Alumno> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    /**
     * Sobreescritura del método toString que muestra el nombre de la asignatura.
     * @return nombre de la asignatura.
     */
    @Override
    public String toString() {
        return this.nombre;
    }
}
