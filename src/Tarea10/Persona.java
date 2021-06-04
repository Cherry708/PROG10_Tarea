package Tarea10;

/**
 * Persona es la clase para todas las personas y cuenta con
 * los atributos y métodos comunes a ellas.
 *
 * @author Rubén Serrano Cano.
 * @version 1.0
 */
public class Persona {

    //Atributos
    /**
     * Dni de la persona, actúa como identificador único
     */
    private String dni = "";
    /**
     * Nombre de la persona.
     */
    private String nombre = "";

    //Métodos
    /**
     * Método constructor de persona.
     */
    public Persona(){}

    /**
     * Método que devuelve el dni de la persona.
     * @return Dni de la persona, actúa como identificador único.
     */
    public String getDni(){
        return this.dni;
    }

    /**
     * Método que devuelve el nombre de la persona.
     * @return Nombre de la persona.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Método que asigna el parámetro suministrado al dni de la persona.
     * @param dni Dni de la persona, actúa como identificador único.
     */
    public void setDni(String dni){
        this.dni = dni;
    }

    /**
     * Método que asigna el parámetro suministrado al nomrbe de la persona.
     * @param nombre Nombre de la persona.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Sobreescritura del método toString.
     * @return devuelve la persona junto a su dni y su nombre.
     */
    @Override
    public String toString() {
        return "Persona{ "+"dni: " + dni + ", nombre: " + nombre+" }";
    }
}
