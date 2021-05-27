public class Profesor extends Persona {

    //Atributos
    Asignatura asignatura;

    //Métodos
    public Asignatura getAsignatura(){
        return this.asignatura;
    }

    @Override
    public String toString() {
        return "Profesor{ "+"dni: " + getDni() + ", nombre: "+getNombre()+", asignatura: "+asignatura+" }";
    }
}
