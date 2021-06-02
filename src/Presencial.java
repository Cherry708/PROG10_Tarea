import java.util.ArrayList;
import java.util.Arrays;

public class Presencial extends Alumno{

    //Atributos
    private double matriculaCurso;
    private int numeroConvocatoria;
    private double plusPorConvocatoria;

    //Métodos
    public Presencial(String dni, String nombre, int curso, String nivelAcademico, ArrayList<Asignatura> listaAsignaturas, int numeroConvocatoria){
        setDni(dni);
        setNombre(nombre);
        setCurso(curso);
        setNivelAcademico(nivelAcademico);
        setListaAsignaturas(listaAsignaturas);
        this.numeroConvocatoria = numeroConvocatoria;
    }

    public double getMatriculaCurso() {
        return matriculaCurso;
    }

    public void setMatriculaCurso(double matriculaCurso) {
        this.matriculaCurso = matriculaCurso;
    }

    public int getNumeroConvocatoria() {
        return numeroConvocatoria;
    }

    public void setNumeroConvocatoria(int numeroConvocatoria) {
        this.numeroConvocatoria = numeroConvocatoria;
    }

    public double getPlusPorConvocatoria() {
        return plusPorConvocatoria;
    }

    public void setPlusPorConvocatoria(double plusPorConvocatoria) {
        this.plusPorConvocatoria = plusPorConvocatoria;
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
