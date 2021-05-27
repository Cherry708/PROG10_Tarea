public class Libre extends Alumno {

    //Atributos
    private final float PRECIO_HORA = 10;
    private int numeroHorasDiarias;

    //Métodos
    public Libre(){}

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
