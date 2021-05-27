import java.util.ArrayList;
import java.util.Arrays;

public class Presencial extends Alumno{

    //Atributos
    private double matriculaCurso;
    private int numeroConvocatoria;
    private double plusPorConvocatoria;

    //Métodos
    public Presencial(String dni, String nombre, int curso, ArrayList<Asignatura> listaAsignaturas){
        setDni(dni);
        setNombre(nombre);
        setCurso(curso);
        setListaAsignaturas(listaAsignaturas);
        //setConvocatoria??????

    }

    @Override
    public double pagoMensual() {
        return (matriculaCurso+plusPorConvocatoria*numeroConvocatoria)/12;
    }

    @Override
    public String mostrarAsignaturas() {
        return "El estudiante presencial: "+getNombre()+", estudia: "+ getListaAsignaturas().toString();
    }
}
