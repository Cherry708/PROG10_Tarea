public class Profesor extends Persona {

    //Atributos
    Asignatura asignatura;

    //Métodos
    public Profesor(String dni, String nombre, Asignatura asignatura){
        setDni(dni);
        setNombre(nombre);
        this.asignatura = asignatura;
    }

    public Asignatura getAsignatura(){
        return this.asignatura;
    }

    @Override
    public String toString() {
        return "Profesor{ "+"dni: " + getDni() + ", nombre: "+getNombre()+", asignatura: "+asignatura+" }";
    }
}
