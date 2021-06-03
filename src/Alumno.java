import java.util.ArrayList;

/**
 * Alumno es la clase abstracta base para todos los tipos de alumnos.
 * Contiene atributos comunes a todos los alumnos y métodos abstractos
 * que deberán implementar.
 *
 * @author Rubén Serrano Cano.
 * @version 1
 */
public abstract class Alumno extends Persona {

    //Atributos
    /**
     * Curso del alumno.
      */
    private int curso;
    /**
     * Nivel académico del alumno.
     */
    private String nivelAcademico;
    /**
     * Lista de las asignaturas del alumno.
     */
    private ArrayList<Asignatura> listaAsignaturas;
    /**
     * Tipo de alumno.
     */
    private String tipoDeAlumno;

    //Métodos
    /*
    La clase no presenta un método constructor porque la
    asignación se hace mediante setters en los métodos
    constructores de las subclases. En lugar de super(parametro),
    se usa set(parametro).
     */

    /**
     * Método que devuelve el curso del alumno.
     * @return curso del alumno como int.
     */
    public int getCurso(){
        return curso;
    }

    /**
     * Método que devuelve el nivel académico del alumno.
     * @return nivel académico del alumno como String.
     */
    public String getNivelAcademico(){
        return nivelAcademico;
    }

    /**
     * Método que devuelve la lista de asignaturas del alumno.
     * @return lista de las asignaturas del alumno como ArrayList.
     */
    public ArrayList<Asignatura> getListaAsignaturas(){
        return listaAsignaturas;
    }

    /**
     * Método que devuelve el tipo de alumno.
     * @return tipo de alumno como String.
     */
    public String getTipoDeAlumno(){
        return tipoDeAlumno;
    }

    /**
     * Método que asigna el parámetro suministrado al curso.
     * @param curso el curso del alumno.
     */
    public void setCurso(int curso){
        this.curso = curso;
    }

    /**
     * Método que asigna el parámetro suministrado al nivel académico.
     * @param nivelAcademico el nivel académico del alumno.
     */
    public void setNivelAcademico(String nivelAcademico){
        this.nivelAcademico = nivelAcademico;
    }

    /**
     * Método que asigna el parámetro suministrado a la lista de asignatura.
     * @param asignaturas lista ArrayList que contiene las asignaturas del alumno.
     */
    public void setListaAsignaturas(ArrayList<Asignatura> asignaturas){
        this.listaAsignaturas = asignaturas;
    }

    /**
     * Método que asigna el parámetro suministrado al tipo de alumno.
     * @param tipoDeAlumno el tipo de alumno que es.
     */
    public void setTipoDeAlumno(String tipoDeAlumno){
        this.tipoDeAlumno = tipoDeAlumno;
    }

    /**
     * Método abastacto declarado pero no implementado,
     * las subclases deberán implementarlo.
     * @return el pago mensual del alumno como double.
     */
    public abstract double pagoMensual();

    /**
     * Método abstracto declarado pero no implementado,
     * las subclases deberán implementarlo.
     * @return las asignaturas del alumno como String.
     */
    public abstract String mostrarAsignaturas();

}
