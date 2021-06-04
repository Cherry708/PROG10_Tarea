package Tarea10;

import java.util.ArrayList;

/**
 * Presencial es una subclase de Alumno para los alumnos
 * de tipo presencial y cuenta con los atributos y métodos
 * comunes a ellos.
 *
 * @author Rubén Serrano Cano.
 * @version 1.0
 */
public class Presencial extends Alumno{

    //Atributos
    /**
     * Precio de la matriculación en el curso.
     */
    private double matriculaCurso;
    /**
     * Número de convocatorias realizadas por el alumno.
     */
    private int numeroConvocatoria;
    /**
     * Precio por la convocatoria adicional.
     */
    private double plusPorConvocatoria;

    //Métodos

    /**
     * Método constructor de Presencial, que asigna los parametros
     * suministrados a los atributos de esta clase y de las superclases
     * Persona y Alumno
     * @param dni Dni de la persona.
     * @param nombre Nombre de la persona.
     * @param curso Curso del alumno.
     * @param nivelAcademico Nivel académico del alumno.
     * @param listaAsignaturas Lista de asignaturas del alumno.
     * @param tipoDeAlumno Tipo de alumno.
     * @param numeroConvocatoria Número de convocatorias del alumno.
     */
    public Presencial(String dni, String nombre, int curso, String nivelAcademico, ArrayList<Asignatura> listaAsignaturas, String tipoDeAlumno ,int numeroConvocatoria){
        setDni(dni);
        setNombre(nombre);
        setNivelAcademico(nivelAcademico);
        setListaAsignaturas(listaAsignaturas);
        setTipoDeAlumno(tipoDeAlumno);
        this.numeroConvocatoria = numeroConvocatoria;
    }

    /**
     * Método que devuelve el precio de la matriculación en el curso.
     * @return Precio de la matriculación en el curso.
     */
    public double getMatriculaCurso() {
        return matriculaCurso;
    }

    /**
     * Método que asigna el parámetro suministrado a la matricula del curso.
     * @param matriculaCurso Precio de la matriculación en el curso.
     */
    public void setMatriculaCurso(double matriculaCurso) {
        this.matriculaCurso = matriculaCurso;
    }

    /**
     * Método que devuelve el número de convocatorias realizadas por el alumno.
     * @return Número de convocatorias realizadas por el alumno.
     */
    public int getNumeroConvocatoria() {
        return numeroConvocatoria;
    }

    /**
     * Método que asigna el parámetro suministrado al número de convocatoria del alumno.
     * @param numeroConvocatoria Número de las convocatorias realizadas por el alumno.
     */
    public void setNumeroConvocatoria(int numeroConvocatoria) {
        this.numeroConvocatoria = numeroConvocatoria;
    }

    /**
     * Método que devuelve el precio de la convocatoria adicional.
     * @return Precio por la convocatoria adicional.
     */
    public double getPlusPorConvocatoria() {
        return plusPorConvocatoria;
    }

    /**
     * Método que asigna el parámetro suministrado al precio por la convocatoria adicional del alumno.
     * @param plusPorConvocatoria Precio por la convocatoria adicional.
     */
    public void setPlusPorConvocatoria(double plusPorConvocatoria) {
        this.plusPorConvocatoria = plusPorConvocatoria;
    }

    /**
     * Implementacion del método abstracto de la superclase Alumno.
     * @return pago mensual del alumno.
     */
    @Override
    public double pagoMensual() {
        return (matriculaCurso+plusPorConvocatoria*numeroConvocatoria)/12;
    }

    /**
     * Implementación del método abstraco de la superclase Alumno.
     * @return asignaturas del alumno.
     */
    @Override
    public String mostrarAsignaturas() {
        return "El estudiante presencial: "+getNombre()+", estudia: "+ getListaAsignaturas().toString();
    }
}
