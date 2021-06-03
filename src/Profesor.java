/**
 * Profesor es la clase para todos los profesores y tiene
 * atributos y métodos comunes a todos ellos.
 * Es subclase de persona.
 *
 * @author Rubén Serrano Cano.
 * @version 1.0
 */
public class Profesor extends Persona {

    //Atributos
    /**
     * Asignatura que imparte el profesor.
     */
    String asignatura;

    //Métodos
    /**
     * Método constructor que asigna los parámetros suministrados
     * a los atributos dni y nombre, heredados de persona y asignatura.
     * @param dni Dni de la persona, actúa como identificador único.
     * @param nombre Nombre de la persona.
     * @param asignatura Asignatura que imparte el profesor.
     */
    public Profesor(String dni, String nombre, String asignatura){
        setDni(dni);
        setNombre(nombre);
        this.asignatura = asignatura;
    }

    /**
     * Método que devuelve la asignatura del profesor.
     * @return Asignatura que imparte el profesor.
     */
    public String getAsignatura(){
        return this.asignatura;
    }

    /**
     * Sobreescritura del método toString.
     * @return profesor con su dni, nombre y asignatura.
     */
    @Override
    public String toString() {
        return "Profesor{ "+"dni: " + getDni() + ", nombre: "+getNombre()+", asignatura: "+asignatura+" }";
    }
}
