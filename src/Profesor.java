public class Profesor extends Persona {

    //Atributos
    String asignatura;

    //Métodos
    public Profesor(String dni, String nombre, String asignatura){
        setDni(dni);
        setNombre(nombre);
        this.asignatura = asignatura;
    }

    public String getAsignatura(){
        return this.asignatura;
    }

    @Override
    public String toString() {
        return "Profesor{ "+"dni: " + getDni() + ", nombre: "+getNombre()+", asignatura: "+asignatura+" }";
    }
}
