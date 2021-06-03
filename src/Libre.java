import java.util.ArrayList;

public class Libre extends Alumno {

    //Atributos
    private final float PRECIO_HORA = 10;
    private int numeroHorasDiarias;

    //Métodos
    public Libre(){}

    public Libre(String dni, String nombre, int curso, String nivelAcademico, ArrayList<Asignatura> listaAsignaturas, String tipoDeAlumno){
        setDni(dni);
        setNombre(nombre);
        setCurso(curso);
        setNivelAcademico(nivelAcademico);
        setListaAsignaturas(listaAsignaturas);
        setTipoDeAlumno(tipoDeAlumno);
    }

    public int getNumeroHorasDiarias(){
        return numeroHorasDiarias;
    }

    public void setNumeroHorasDiarias(int numeroHorasDiarias){
        this.numeroHorasDiarias = numeroHorasDiarias;
    }

    @Override
    public double pagoMensual() {
        return PRECIO_HORA*numeroHorasDiarias*30;
    }

    @Override
    public String mostrarAsignaturas() {
        return "El estudiante presencial: "+getNombre()+", estudia: "+ getListaAsignaturas().toString();
    }
}
