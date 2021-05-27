public class Persona {

    //Atributos
    private String dni = "";
    private String nombre = "";

    //Métodos
    public Persona(){}

    public String getDni(){
        return this.dni;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{ "+"dni: " + dni + ", nombre: " + nombre+" }";
    }
}
