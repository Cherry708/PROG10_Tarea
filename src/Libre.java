import java.util.ArrayList;

/**
 * Libre es una subclase de Alumno para los alumnos
 * de tipo libre y cuenta con los atributos y métodos
 * comunes a ellos.
 *
 * @author Rubén Serrano Cano.
 * @version 1.0
 */
public class Libre extends Alumno {

    //Atributos
    /**
     * Precio por hora del alumno.
     */
    private final float PRECIO_HORA = 10;
    /**
     * Número de horas diarias del alumno.
     */
    private int numeroHorasDiarias;

    //Métodos

    /**
     * Método constructor del alumno libre que asigna los parámetros
     * suministrados a los atributos dni y nombre de persona, curso,
     * nivel académico, lista de asignaturas y tipo de alumno de Alumno.
     * @param dni Dni de la persona, actúa como identificador único.
     * @param nombre Nombre de la persona.
     * @param curso Curso del alumno.
     * @param nivelAcademico Nivel académico del alumno.
     * @param listaAsignaturas Lista de asignaturas del alumno.
     * @param tipoDeAlumno Tipo de alumno.
     */
    public Libre(String dni, String nombre, int curso, String nivelAcademico, ArrayList<Asignatura> listaAsignaturas, String tipoDeAlumno){
        setDni(dni);
        setNombre(nombre);
        setCurso(curso);
        setNivelAcademico(nivelAcademico);
        setListaAsignaturas(listaAsignaturas);
        setTipoDeAlumno(tipoDeAlumno);
    }

    /**
     * Método que devuelve el número de horas diarias del alumno libre.
     * @return Número de hroas diarias del alumno.
     */
    public int getNumeroHorasDiarias(){
        return numeroHorasDiarias;
    }

    /**
     * Método que asigna el parámetro de entrada a numeros de horas diarias
     * del alumno libre.
     * @param numeroHorasDiarias Número de hroas diarias del alumno.
     */
    public void setNumeroHorasDiarias(int numeroHorasDiarias){
        this.numeroHorasDiarias = numeroHorasDiarias;
    }

    /**
     * Implementación del método abstracto de la superclase Alumno
     * @return el pago que deberá efectuar el alumno libre.
     */
    @Override
    public double pagoMensual() {
        return PRECIO_HORA*numeroHorasDiarias*30;
    }

    /**
     * Implementación del método abstracto de la superclase Alumno.
     * @return el alumno con su nombre y asignaturas.
     */
    @Override
    public String mostrarAsignaturas() {
        return "El estudiante presencial: "+getNombre()+", estudia: "+ getListaAsignaturas().toString();
    }
}
