import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * Aplicación es el controlador que muestra la interfaz
 * gráfica principal y cuenta con la mayoría de funciones,
 * aunque delega en otras clases para añadir profesores,
 * estudiantes y asignaturas.
 *
 * Aplicación consiste en una interfaz gráfica que permite
 * añadir, editar, buscar y eliminar profesores, estudiantes
 * y asignaturas en tiempo de ejecución.
 *
 * @author Rubén Serrano Cano
 * @version 1.0
 */
public class Aplicacion {

    private JPanel pnlPrincipal;
    private JTextField txtBuscar;
    private JButton btnAñadir;
    private JButton btnBuscar;
    private JComboBox cmbOpcion;
    private JPanel pnlListado;
    private JButton btnRecargar;
    private JButton btnEliminar;
    private JButton btnEditar;

    /*
    Ventanas que podrán mostrarse en tiempo de ejecución.
     */
    private JFrame anadirEstudiante;
    private JFrame anadirProfesor;
    private JFrame anadirAsignatura;

    /**
     * Metodo constructor.
     */
    public Aplicacion(){

        //Declaramos e instaciamos los GridLayouts que utilizaremos.
        GridLayout layoutEstudiante = new GridLayout(0,6,10,5);
        GridLayout layoutProfesor = new GridLayout(0, 3, 10,5);
        GridLayout layoutAsignatura = new GridLayout(0,2,10,5);

        /*
        Declaramos e instanciamos las listas de alumnos, profesores y asignaturas.
        Listas en las que se almacenarán los objetos instanciados en ejecución.
         */
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        ArrayList<Profesor> listaProfesores = new ArrayList<>();
        ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();



        /*
        Declaramos e instanciamos las listas de los componentes de alumnos, profesores y asignaturas
        Almacenaremos los componentes en un arrayList para luego poder manipularlos
         */

        /*
        Componentes de alumnos
         */
        ArrayList<JTextField> txtListaDniAlumno = new ArrayList<>();
        ArrayList<JTextField> txtListaNombresAlumno = new ArrayList<>();
        ArrayList<JTextField> txtListaCursoAlumno = new ArrayList<>();
        ArrayList<JTextField> txtListaNivelAlumno = new ArrayList<>();
        ArrayList<JComboBox<Asignatura>> cmbListaAsignaturasAlumno = new ArrayList<>();
        ArrayList<JTextField> txtListaTipoAlumno = new ArrayList<>();

        /*
        Componentes de profesores
         */
        ArrayList<JTextField> txtListaDniProfesor = new ArrayList<>();
        ArrayList<JTextField> txtListaNombresProfesor = new ArrayList<>();
        ArrayList<JTextField> txtListaAsignaturasProfesor = new ArrayList<>();

        /*
        Componentes de asignaturas
         */
        ArrayList<JTextField> txtListaNombreAsignatura = new ArrayList<>();
        ArrayList<JTextField> txtListaCursoAsignatura = new ArrayList<>();

        cmbOpcion.setSelectedIndex(2);

        cmbOpcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                /*
                Dado que profesores y alumnos necesitan de al menos una asignatura, la aplicación
                obligará al usuario a añadir una para evitar que intente añadir profesores o alumnos
                y no cumpla los requisitos de la ventana/formulario.
                 */
                anadirAsignaturasMensaje(listaAsignaturas);
                validarPaneles();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String busqueda;
                busqueda = txtBuscar.getText();
                buscar(busqueda, listaAlumnos, layoutEstudiante, listaProfesores, listaAsignaturas, layoutProfesor, layoutAsignatura);
            }
        });


        btnAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (cmbOpcion.getSelectedIndex() == 0){
                    anadirEstudiante = new AnadirEstudiante(listaAlumnos, listaAsignaturas);
                } else if(cmbOpcion.getSelectedIndex() == 1){
                    anadirProfesor = new AnadirProfesor(listaProfesores, listaAsignaturas);
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
                    txtBuscar.setText("Para buscar, eliminar o editar un estudiante, introduce su DNI.");

                    definirLayoutPanel(layoutEstudiante);

                    mostrarEtiquetas(listaAlumnos, listaProfesores, listaAsignaturas);

                    for (Alumno alumno : listaAlumnos){
                        txtListaDniAlumno.add(new JTextField());
                        txtListaNombresAlumno.add(new JTextField());
                        txtListaCursoAlumno.add(new JTextField());
                        txtListaNivelAlumno.add(new JTextField());
                        cmbListaAsignaturasAlumno.add(new JComboBox<>());
                        txtListaTipoAlumno.add(new JTextField());
                    }


                    for (int contador = 0; contador < listaAlumnos.size(); contador++){ //Se añade toda la lista
                        pnlListado.add(txtListaDniAlumno.get(contador));
                        txtListaDniAlumno.get(contador).setText(listaAlumnos.get(contador).getDni());
                        txtListaDniAlumno.get(contador).setEditable(false);

                        pnlListado.add(txtListaNombresAlumno.get(contador));
                        txtListaNombresAlumno.get(contador).setText(listaAlumnos.get(contador).getNombre());
                        txtListaNombresAlumno.get(contador).setEditable(false);

                        pnlListado.add(txtListaCursoAlumno.get(contador));
                        txtListaCursoAlumno.get(contador).setText(String.valueOf(listaAlumnos.get(contador).getCurso()));
                        txtListaCursoAlumno.get(contador).setEditable(false);

                        pnlListado.add(txtListaNivelAlumno.get(contador));
                        txtListaNivelAlumno.get(contador).setText(listaAlumnos.get(contador).getNivelAcademico());
                        txtListaNivelAlumno.get(contador).setEditable(false);

                        pnlListado.add(cmbListaAsignaturasAlumno.get(contador));
                        /*
                        Para cada asignatura en la lista de asignaturas de cada alumno, se añade esta asignatura
                        al componente JComboBox del alumno, que se mostrará en el panel.
                         */
                        for (Asignatura asignatura: listaAlumnos.get(contador).getListaAsignaturas()){
                            cmbListaAsignaturasAlumno.get(contador).addItem(asignatura);
                        }

                        pnlListado.add(txtListaTipoAlumno.get(contador));
                        txtListaTipoAlumno.get(contador).setText(listaAlumnos.get(contador).getTipoDeAlumno());
                        txtListaTipoAlumno.get(contador).setEditable(false);
                    }
                    /*
                    Al pulsar recargar añadimos componentes a las listas a pesar de que el número
                    de alumnos no se haya modificado, esto significa que se añadirán componentes
                    a los que no se accederá nunca. Si vaciamos las listas al terminar el bucle
                    y dibujarlas por pantalla, nos aseguramos de que no se añaden componentes vacios.
                    Es decir, que los únicos componentes en las listas son los empleados por alumnos.
                     */
                    txtListaDniAlumno.clear();
                    txtListaNombresAlumno.clear();
                    txtListaCursoAlumno.clear();
                    txtListaNivelAlumno.clear();
                    cmbListaAsignaturasAlumno.clear();
                    txtListaTipoAlumno.clear();
                    validarPaneles();

                    //Dibujamos profesores
                } else if (cmbOpcion.getSelectedIndex() == 1){
                    txtBuscar.setText("Para buscar, eliminar o editar un profesor, introduce su DNI.");

                    definirLayoutPanel(layoutProfesor);

                    mostrarEtiquetas(listaAlumnos, listaProfesores, listaAsignaturas);

                    for (Profesor profesor : listaProfesores){
                        txtListaDniProfesor.add(new JTextField());
                        txtListaNombresProfesor.add(new JTextField());
                        txtListaAsignaturasProfesor.add(new JTextField());
                    }

                    for (int contador = 0; contador < listaProfesores.size(); contador++){ //Se añade toda la lista
                        pnlListado.add(txtListaDniProfesor.get(contador));
                        txtListaDniProfesor.get(contador).setText(listaProfesores.get(contador).getDni());
                        txtListaDniProfesor.get(contador).setEditable(false);

                        pnlListado.add(txtListaNombresProfesor.get(contador));
                        txtListaNombresProfesor.get(contador).setText(listaProfesores.get(contador).getNombre());
                        txtListaNombresProfesor.get(contador).setEditable(false);

                        pnlListado.add(txtListaAsignaturasProfesor.get(contador));
                        txtListaAsignaturasProfesor.get(contador).setText(listaProfesores.get(contador).getAsignatura());
                        txtListaAsignaturasProfesor.get(contador).setEditable(false);
                    }
                    txtListaDniProfesor.clear();
                    txtListaNombresProfesor.clear();
                    txtListaAsignaturasProfesor.clear();
                    validarPaneles();

                    //Dibujamos asignaturas
                } else if (cmbOpcion.getSelectedIndex() == 2){
                    txtBuscar.setText("Para buscar, eliminar o editar una asignatura, introduce su nombre.");

                    definirLayoutPanel(layoutAsignatura);

                    mostrarEtiquetas(listaAlumnos,listaProfesores,listaAsignaturas);

                    for (Asignatura asignatura : listaAsignaturas){
                        txtListaNombreAsignatura.add(new JTextField());
                        txtListaCursoAsignatura.add(new JTextField());
                    }

                    for (int contador = 0; contador < listaAsignaturas.size(); contador++){ //Se añade toda la lista
                        pnlListado.add(txtListaNombreAsignatura.get(contador));
                        txtListaNombreAsignatura.get(contador).setText(listaAsignaturas.get(contador).getNombre());
                        txtListaNombreAsignatura.get(contador).setEditable(false);

                        pnlListado.add(txtListaCursoAsignatura.get(contador));
                        txtListaCursoAsignatura.get(contador).setText(String.valueOf(listaAsignaturas.get(contador).getCurso()));
                        txtListaCursoAsignatura.get(contador).setEditable(false);
                    }
                    txtListaNombreAsignatura.clear();
                    txtListaCursoAsignatura.clear();
                    validarPaneles();
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda;
                busqueda = txtBuscar.getText();
                eliminar(busqueda, listaAlumnos, listaProfesores, listaAsignaturas);
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda;
                busqueda = txtBuscar.getText();
                editar(busqueda, listaAlumnos, listaAsignaturas, listaProfesores);
            }
        });

    }

    /*
    Método que muestra un mensaje para indicar al usuario que añada asignaturas, además de impedir
    que acceda al resto de modos.
     */
    private void anadirAsignaturasMensaje(ArrayList<Asignatura> listaAsignaturas) {
        if (listaAsignaturas.isEmpty() && cmbOpcion.getSelectedIndex() != 2) {
            JOptionPane.showMessageDialog(null, "Debes añadir asignaturas.");
            cmbOpcion.setSelectedIndex(2);
        }
    }

    /*
    Método que permite buscar alumnos, profesores o asignaturas y que, en caso de encontrar el objeto,
    lo dibuja en el panel con toda la información. De no encontrar un objeto, mostrará un mensaje de advertencia.
    Se ha diseñado con la premisa de que los campos a buscar son identificadores únicos.
     */
    private void buscar(String busqueda, ArrayList<Alumno> listaAlumnos, GridLayout layoutEstudiante, ArrayList<Profesor> listaProfesores, ArrayList<Asignatura> listaAsignaturas, GridLayout layoutProfesor, GridLayout layoutAsignatura) {
        boolean mostrarMensaje = true;

        //Si se ha escogido alumno
        if (cmbOpcion.getSelectedIndex() == 0){
             for (Alumno alumno : listaAlumnos){
                 //Si la busqueda coincide con algún alumno
                 if (alumno.getDni().equals(busqueda)){
                     /*
                     Se dibuja el alumno en el panel
                      */
                     definirLayoutPanel(layoutEstudiante);
                     mostrarEtiquetas(listaAlumnos, listaProfesores, listaAsignaturas);

                     JTextField txtDniAlumno = new JTextField();
                     JTextField txtNombreAlumno = new JTextField();
                     JTextField txtCursoAlumno = new JTextField();
                     JTextField txtNivelAlumno = new JTextField();
                     JComboBox<Asignatura> cmbAsignaturasAlumno = new JComboBox<>();
                     JTextField txtTipoDeAlumno = new JTextField();

                     txtDniAlumno.setText(alumno.getDni());
                     txtNombreAlumno.setText(alumno.getNombre());
                     txtCursoAlumno.setText(String.valueOf(alumno.getCurso()));
                     txtNivelAlumno.setText(alumno.getNivelAcademico());
                     txtTipoDeAlumno.setText(alumno.getTipoDeAlumno());

                     pnlListado.add(txtDniAlumno);
                     txtDniAlumno.setEditable(false);

                     pnlListado.add(txtNombreAlumno);
                     txtNombreAlumno.setEditable(false);

                     pnlListado.add(txtCursoAlumno);
                     txtCursoAlumno.setEditable(false);

                     pnlListado.add(txtNivelAlumno);
                     txtNivelAlumno.setEditable(false);

                     for (Asignatura asignatura: alumno.getListaAsignaturas()){
                         cmbAsignaturasAlumno.addItem(asignatura);
                     }
                     pnlListado.add(cmbAsignaturasAlumno);

                     pnlListado.add(txtTipoDeAlumno);
                     txtTipoDeAlumno.setEditable(false);

                     validarPaneles();
                     accionRealizadaMensaje();
                     mostrarMensaje = false;
                 }
             }
             //De no encontrarse el alumno se muestra un error
             if (mostrarMensaje){
                 noEncontradoMensaje();
             }
            //Si se ha escogido profesor
        } else if (cmbOpcion.getSelectedIndex() == 1){
            for (Profesor profesor : listaProfesores){
                //Si la busqueda coincide con algún profesor
                if (profesor.getDni().equals(busqueda)){
                    /*
                     Se dibuja el profesor en el panel
                      */
                    definirLayoutPanel(layoutProfesor);
                    mostrarEtiquetas(listaAlumnos, listaProfesores, listaAsignaturas);

                    JTextField txtDniProfesor = new JTextField();
                    JTextField txtNombreProfesor = new JTextField();
                    JTextField txtAsignaturaProfesor = new JTextField();

                    txtDniProfesor.setText(profesor.getDni());
                    txtNombreProfesor.setText(profesor.getDni());
                    txtAsignaturaProfesor.setText(profesor.getAsignatura());

                    pnlListado.add(txtDniProfesor);
                    txtDniProfesor.setEditable(false);

                    pnlListado.add(txtNombreProfesor);
                    txtNombreProfesor.setEditable(false);

                    pnlListado.add(txtAsignaturaProfesor);
                    txtAsignaturaProfesor.setEditable(false);

                    validarPaneles();
                    accionRealizadaMensaje();
                    mostrarMensaje = false;
                }
            }
            //De no encontrarse el profesor se muestra un error
            if (mostrarMensaje){
                noEncontradoMensaje();
            }
            //Si se ha escogido asignatura
        } else if (cmbOpcion.getSelectedIndex() == 2) {
            for (Asignatura asignatura : listaAsignaturas) {
                //Si la busqueda coincide con alguna asignatura
                if (asignatura.getNombre().equals(busqueda)) {
                    /*
                     Se dibuja la asignatura en el panel
                      */
                    definirLayoutPanel(layoutAsignatura);
                    mostrarEtiquetas(listaAlumnos, listaProfesores, listaAsignaturas);

                    JTextField txtNombreAsignatura = new JTextField();
                    JTextField txtCursoAsignatura = new JTextField();

                    txtNombreAsignatura.setText(asignatura.getNombre());
                    txtCursoAsignatura.setText(String.valueOf(asignatura.getCurso()));

                    pnlListado.add(txtNombreAsignatura);
                    txtNombreAsignatura.setEditable(false);

                    pnlListado.add(txtCursoAsignatura);
                    txtCursoAsignatura.setEditable(false);;

                    validarPaneles();
                    accionRealizadaMensaje();
                    mostrarMensaje = false;
                }
            }
            //De no encontrarse la asignatura se muestra un error
            if (mostrarMensaje) {
                noEncontradoMensaje();
            }
        }
    }

    /*
    Método que según la opción escogida añade a la primera fila del panel las etiquetas correspondientes a cada
    opción.
     */
    private void mostrarEtiquetas(ArrayList<Alumno> listaAlumnos, ArrayList<Profesor> listaProfesores,  ArrayList<Asignatura> listaAsignaturas){
        if (cmbOpcion.getSelectedIndex() == 0){
            if (!listaAlumnos.isEmpty()){
                pnlListado.add(new JLabel("DNI"));
                pnlListado.add(new JLabel("Nombre"));
                pnlListado.add(new JLabel("Curso"));
                pnlListado.add(new JLabel("Nivel"));
                pnlListado.add(new JLabel("Asignaturas"));
                pnlListado.add(new JLabel("Tipo"));
            }
        } else if (cmbOpcion.getSelectedIndex() == 1){
            if (!listaProfesores.isEmpty()) {
                pnlListado.add(new JLabel("DNI"));
                pnlListado.add(new JLabel("Nombre"));
                pnlListado.add(new JLabel("Asignatura"));
            }
        } else if (cmbOpcion.getSelectedIndex() == 2){
            if (!listaAsignaturas.isEmpty()){
                pnlListado.add(new JLabel("Nombre"));
                pnlListado.add(new JLabel("Curso"));
            }
        }
    }

    /*
    Método que según la opción escogida por el usuario, busca una coincidencia en las diferentes listas para eliminar
    de estas el elemento que contenga el atributo que coincida con la búsqueda.
     */
    private void eliminar(String busqueda, ArrayList<Alumno> listaAlumnos, ArrayList<Profesor> listaProfesores, ArrayList<Asignatura> listaAsignaturas) {
        boolean mostrarMensaje = true;

        if (cmbOpcion.getSelectedIndex() == 0){
            try {
                for (Alumno alumno : listaAlumnos) {
                    if (alumno.getDni().equals(busqueda)) {
                        try {
                            listaAlumnos.remove(alumno);
                            accionRealizadaMensaje();
                            mostrarMensaje = false;
                        } catch (ConcurrentModificationException ignored) {
                        }
                    }
                }
            } catch (ConcurrentModificationException ignored){}
            if (mostrarMensaje){
                noEncontradoMensaje();
            }
        } else if (cmbOpcion.getSelectedIndex() == 1){
            try {
                for (Profesor profesor : listaProfesores) {
                    if (profesor.getDni().equals(busqueda)) {
                        listaProfesores.remove(profesor);
                        accionRealizadaMensaje();
                        mostrarMensaje = false;
                    }
                }
            } catch (ConcurrentModificationException ignored){}
            if (mostrarMensaje){
                noEncontradoMensaje();
            }
        } else if (cmbOpcion.getSelectedIndex() == 2){
            try {
                for (Asignatura asignatura : listaAsignaturas) {
                    if (asignatura.getNombre().equals(busqueda)) {
                        listaAsignaturas.remove(asignatura);
                        accionRealizadaMensaje();
                        mostrarMensaje = false;
                    }
                }
            } catch (ConcurrentModificationException ignored){}
            if (mostrarMensaje){
                noEncontradoMensaje();
            }
        }
    }

    /*
    Método que muestra un mensaje de confirmación a través de una ventana JOptionPane.
     */
    private void accionRealizadaMensaje() {
        JOptionPane.showMessageDialog(null,"Acción realizada correctamente.");
    }

    /*
    Método que muestra un mensaje de error a través de una ventana JOptionPane.
     */
    private void noEncontradoMensaje() {
        JOptionPane.showMessageDialog(null, "No se ha encontrado.");
    }

    /*
    Método que al encontrar una coincidencia con la busqueda elimina el objeto y muestra una nueva ventana para
    añadir el objeto que sustituirá al eliminado.
     */
    private void editar(String busqueda, ArrayList<Alumno> listaAlumnos, ArrayList<Asignatura> listaAsignaturas, ArrayList<Profesor> listaProfesores) {
        boolean mostrarMensaje = true;
        if (cmbOpcion.getSelectedIndex() == 0){
            try {
                for (Alumno alumno : listaAlumnos) {
                    if (alumno.getDni().equals(busqueda)) {
                        anadirEstudiante = new AnadirEstudiante(listaAlumnos, listaAsignaturas);
                        listaAlumnos.remove(alumno);
                        mostrarMensaje = false;
                    }
                }
            } catch (ConcurrentModificationException ignored){}
            if (mostrarMensaje){
                noEncontradoMensaje();
            }
        } else if (cmbOpcion.getSelectedIndex() == 1){
            try {
                for (Profesor profesor : listaProfesores) {
                    if (profesor.getDni().equals(busqueda)) {
                        try {
                            anadirProfesor = new AnadirProfesor(listaProfesores, listaAsignaturas);
                            listaProfesores.remove(profesor);
                            mostrarMensaje = false;
                        } catch (ConcurrentModificationException ignored) {
                        }
                    }
                }
            } catch (ConcurrentModificationException ignored){}
            if (mostrarMensaje){
                noEncontradoMensaje();
            }
        } else if (cmbOpcion.getSelectedIndex() == 2){
            try {
                for (Asignatura asignatura : listaAsignaturas) {
                    if (asignatura.getNombre().equals(busqueda)) {
                        try {
                            anadirAsignatura = new AnadirAsignatura(listaAsignaturas);
                            listaAsignaturas.remove(asignatura);
                            mostrarMensaje = false;
                        } catch (ConcurrentModificationException ignored) {
                        }
                    }
                }
            } catch (ConcurrentModificationException ignored){}
            if (mostrarMensaje){
                noEncontradoMensaje();
            }
        }
    }

    /*
    Método que valida los paneles mediante el método "validate" de estos.
    Permite mostrar los componentes añadidos al panel en tiempo de ejecución.
     */
    private void validarPaneles() {
        pnlPrincipal.validate();
        pnlListado.validate();
    }

    /*
    Método que determina el GridLayout del panel y eliminar el contenido anterior
     */
    private void definirLayoutPanel(GridLayout layout) {
        pnlListado.setLayout(layout);
        pnlListado.removeAll();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicación");
        frame.setContentPane(new Aplicacion().pnlPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600,300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
