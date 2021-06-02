import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Aplicacion {

    private JPanel pnlPrincipal;
    private JTextField txtBuscar;
    private JButton btnAñadir;
    private JButton btnBuscar;
    private JComboBox cmbOpcion;
    private JPanel pnlListado;
    private JButton btnRecargar;

    //
    int index = 0;



    //Ventana añadirEstudiante
    private JFrame anadirEstudiante;
    private JFrame anadirProfesor;
    private JFrame anadirAsignatura;



    public Aplicacion(){

        //Declaramos e instaciamos los layouts que utilizaremos
        GridLayout layoutEstudiante = new GridLayout(0,7,10,5);
        GridLayout layoutProfesor = new GridLayout(0, 5, 10,5);
        GridLayout layoutAsignatura = new GridLayout(0,4,10,5);

        //Declaramos e instanciamos las listas de alumnos, profesores y asignaturas
        //Listas en las que se almacenarán los objetos instanciados en ejecución
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        ArrayList<Profesor> listaProfesores = new ArrayList<>();
        ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();



        //Declaramos e instanciamos las listas de los componentes de los objetos alumnos, profesores y asignaturas
        /*
        Alumnos
         */
        //Almacenamos los componentes de los alumnos en un arrayList para luego poder manipularlos
        ArrayList<JTextField> txtListaDniAlumno = new ArrayList<>();
        ArrayList<JTextField> txtListaNombresAlumno = new ArrayList<>();
        ArrayList<JTextField> txtListaCursosAlumno = new ArrayList<>();
        ArrayList<JTextField> txtListaNivelesAcademicosAlumno = new ArrayList<>();
        ArrayList<JComboBox> cmbListaAsignaturasAlumno = new ArrayList<>();
        ArrayList<JButton> btnListaBotonesEditarAlumno = new ArrayList<>();
        ArrayList<JButton> btnListaBotonesBorrarAlumno = new ArrayList<>();

        //Almacenamos los componentes de los profesores en un arrayList para luego poder manipularlos
        ArrayList<JTextField> txtListaDniProfesor = new ArrayList<>();
        ArrayList<JTextField> txtListaNombresProfesor = new ArrayList<>();
        ArrayList<JTextField> txtListaAsignaturasProfesor = new ArrayList<>();
        ArrayList<JButton> btnListaBotonesEditarProfesor = new ArrayList<>();
        ArrayList<JButton> btnListaBotonesBorrarProfesor = new ArrayList<>();

        //Almacenamos los componentes de las asignaturas en un arrayList para luego poder manipularlos
        ArrayList<JTextField> txtListaNombreAsignatura = new ArrayList<>();
        ArrayList<JTextField> txtListaCursoAsignatura = new ArrayList<>();
        ArrayList<JButton> btnListaBotonesEditarAsignatura = new ArrayList<>();
        ArrayList<JButton> btnListaBotonesBorrarAsignatura = new ArrayList<>();




        txtBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });

        cmbOpcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        }); //Parece finalizado

        btnAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Ventana añadirEstudiante
                if (cmbOpcion.getSelectedIndex() == 0){
                    //AñadirEstudiante hereda de JDialog
                    //Instanciamos AñadirEstudiante
                    //El parámetro de entrada debe ser un arraylist de alumnos
                    anadirEstudiante = new AnadirEstudiante(listaAlumnos, listaAsignaturas);

                //Ventana añadirEstudiante
                } else if(cmbOpcion.getSelectedIndex() == 1){
                    anadirProfesor = new AnadirProfesor(listaProfesores, listaAsignaturas);
                //Ventana añadirAsigntura
                } else if(cmbOpcion.getSelectedIndex() == 2){
                    anadirAsignatura = new AnadirAsignatura(listaAsignaturas);
                }
            }
        });

        btnRecargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Dibujamos estudiantes
                if (cmbOpcion.getSelectedIndex() == 0){
                    txtBuscar.setText("Para buscar un estudiante, introduce su DNI:");

                    pnlListado.setLayout(layoutEstudiante);
                    pnlListado.removeAll(); //Antes de añadir toda la lista vaciamos el panel para evitar duplicados

                    if (!listaAlumnos.isEmpty()){
                        pnlListado.add(new JLabel("DNI"));
                        pnlListado.add(new JLabel("Nombre"));
                        pnlListado.add(new JLabel("Curso"));
                        pnlListado.add(new JLabel("Nivel académico"));
                        pnlListado.add(new JLabel("Asignaturas"));
                        pnlListado.add(new JLabel(""));
                        pnlListado.add(new JLabel(""));
                    }

                    for (Alumno alumno : listaAlumnos){
                        txtListaDniAlumno.add(new JTextField());
                        txtListaNombresAlumno.add(new JTextField());
                        txtListaCursosAlumno.add(new JTextField());
                        txtListaNivelesAcademicosAlumno.add(new JTextField());
                        //A cada alumno le corresponde una cmb
                        cmbListaAsignaturasAlumno.add(new JComboBox());
                        JButton botonEditar = new JButton();
                        btnListaBotonesEditarAlumno.add(botonEditar);
                        botonEditar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(alumno.getDni());
                            }
                        });
                        btnListaBotonesBorrarAlumno.add(new JButton());

                    }


                    for (int contador = 0; contador < listaAlumnos.size(); contador++){ //Se añade toda la lista
                        //cmbAsignaturas, como añado las asignaturas? Puede que sea bucle con .addItem
                        pnlListado.add(txtListaDniAlumno.get(contador));
                        txtListaDniAlumno.get(contador).setText(listaAlumnos.get(contador).getDni());

                        pnlListado.add(txtListaNombresAlumno.get(contador));
                        txtListaNombresAlumno.get(contador).setText(listaAlumnos.get(contador).getNombre());

                        pnlListado.add(txtListaCursosAlumno.get(contador));
                        txtListaCursosAlumno.get(contador).setText(String.valueOf(listaAlumnos.get(contador).getCurso()));

                        pnlListado.add(txtListaNivelesAcademicosAlumno.get(contador));
                        txtListaNivelesAcademicosAlumno.get(contador).setText(listaAlumnos.get(contador).getNivelAcademico());

                        //Dibujamos el cmb de cada alumno
                        pnlListado.add(cmbListaAsignaturasAlumno.get(contador));
                        //CADA VEZ PULSAS RECARGAR SE AÑADE OTRA VEZ
                        //cmbListaAsignaturasAlumno.get(contador).addItem(listaAlumnos.get(contador).getListaAsignaturas().get(contador));


                        //Así le damos la lista a este alumno, esa lista de asignaturas debe ser una lista con lo seleccionado
                        //cmbListaAsignaturasAlumno.get(contador).addItem(listaAlumnos.get(contador).getListaAsignaturas().get(contador).getNombre());

                        /*
                        Así estamos dando TODAS las asignaturas al alumno, queremos dar solo las que escoga.
                         */
                        //listaAlumnos.get(contador).setListaAsignaturas(listaAsignaturas);
                       /*
                        al cmb debemos añadirle las asignaturas que ha escogido el alumno, lista que forma parte de la
                        clase presencial
                         */

                        pnlListado.add(btnListaBotonesEditarAlumno.get(contador));
                        btnListaBotonesEditarAlumno.get(contador).setText("Editar");

                        pnlListado.add(btnListaBotonesBorrarAlumno.get(contador));
                        btnListaBotonesBorrarAlumno.get(contador).setText("Borrar");

                        //txtListaDni.get(contador).setEnabled(false);
                    }
                    cmbListaAsignaturasAlumno.clear(); //Vaciamos la lista de componentes para evitar que se duplique
                    //Ahora no se duplica pero al añadir 2 el cmb se rompe
                    pnlPrincipal.doLayout();
                    pnlListado.doLayout(); //Dibujamos el panel

                //Dibujamos profesores
                } else if (cmbOpcion.getSelectedIndex() == 1){
                    txtBuscar.setText("Para buscar un profesor, introduce su DNI:");

                    pnlListado.setLayout(layoutProfesor);
                    pnlListado.removeAll(); //Antes de añadir toda la lista vaciamos el panel para evitar duplicados

                    pnlListado.add(new JLabel("DNI"));
                    pnlListado.add(new JLabel("Nombre"));
                    pnlListado.add(new JLabel("Asignatura"));
                    pnlListado.add(new JLabel(""));
                    pnlListado.add(new JLabel(""));


                    for (Profesor profesor : listaProfesores){
                        txtListaDniProfesor.add(new JTextField());
                        txtListaNombresProfesor.add(new JTextField());
                        txtListaAsignaturasProfesor.add(new JTextField());
                        btnListaBotonesEditarProfesor.add(new JButton());
                        btnListaBotonesBorrarProfesor.add(new JButton());
                    }

                    for (int contador = 0; contador < listaProfesores.size(); contador++){ //Se añade toda la lista
                        //cmbAsignaturas, como añado las asignaturas? Puede que sea bucle con .addItem
                        pnlListado.add(txtListaDniProfesor.get(contador));
                        txtListaDniProfesor.get(contador).setText(listaProfesores.get(contador).getDni());

                        pnlListado.add(txtListaNombresProfesor.get(contador));
                        txtListaNombresProfesor.get(contador).setText(listaProfesores.get(contador).getNombre());

                        pnlListado.add(txtListaAsignaturasProfesor.get(contador));
                        txtListaAsignaturasProfesor.get(contador).setText(listaProfesores.get(contador).getAsignatura());

                        pnlListado.add(btnListaBotonesEditarAlumno.get(contador));
                        btnListaBotonesEditarAlumno.get(contador).setText("Editar");

                        pnlListado.add(btnListaBotonesBorrarAlumno.get(contador));
                        btnListaBotonesBorrarAlumno.get(contador).setText("Borrar");

                        //txtListaDni.get(contador).setEnabled(false);
                    }
                    pnlPrincipal.doLayout();
                    pnlListado.doLayout(); //Dibujamos el panel

                //Dibujamos asignaturas
                } else if (cmbOpcion.getSelectedIndex() == 2){

                    pnlListado.setLayout(layoutAsignatura);
                    pnlListado.removeAll(); //Antes de añadir toda la lista vaciamos el panel para evitar duplicados

                    pnlListado.add(new JLabel("Nombre"));
                    pnlListado.add(new JLabel("Curso"));
                    pnlListado.add(new JLabel(""));
                    pnlListado.add(new JLabel(""));


                    for (Asignatura asignatura : listaAsignaturas){
                        txtListaNombreAsignatura.add(new JTextField());
                        txtListaCursoAsignatura.add(new JTextField());
                        btnListaBotonesEditarAsignatura.add(new JButton());
                        btnListaBotonesBorrarAsignatura.add(new JButton());
                    }

                    for (int contador = 0; contador < listaAsignaturas.size(); contador++){ //Se añade toda la lista
                        //cmbAsignaturas, como añado las asignaturas? Puede que sea bucle con .addItem
                        pnlListado.add(txtListaNombreAsignatura.get(contador));
                        txtListaNombreAsignatura.get(contador).setText(listaAsignaturas.get(contador).getNombre());

                        pnlListado.add(txtListaCursoAsignatura.get(contador));
                        txtListaCursoAsignatura.get(contador).setText(String.valueOf(listaAsignaturas.get(contador).getCurso()));

                        pnlListado.add(btnListaBotonesEditarAsignatura.get(contador));
                        btnListaBotonesEditarAsignatura.get(contador).setText("Editar");

                        pnlListado.add(btnListaBotonesBorrarAsignatura.get(contador));
                        btnListaBotonesBorrarAsignatura.get(contador).setText("Borrar");

                        //txtListaDni.get(contador).setEnabled(false);
                        System.out.println(listaAsignaturas.get(contador).toString());
                    }
                    pnlPrincipal.doLayout();
                    pnlListado.doLayout(); //Dibujamos el panel

                }


            }
        });



        /*
        //Parece que no funciona
        for (int contador = 0; contador < btnListaBotonesBorrarAlumno.size(); contador++){
            btnListaBotonesBorrarAlumno.get(contador).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnListaBotonesBorrarAlumno.get(0).setText("Ha entrado");
                    System.out.println("ha entrado");
                }
            });
        }
       */
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().pnlPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
