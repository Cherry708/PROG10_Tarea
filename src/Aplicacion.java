import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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

    //
    int index = 0;



    //Ventana añadirEstudiante
    private JFrame anadirEstudiante;
    private JFrame anadirProfesor;
    private JFrame anadirAsignatura;



    public Aplicacion(){

        //Declaramos e instaciamos los layouts que utilizaremos
        GridLayout layoutEstudiante = new GridLayout(0,6,10,5);
        GridLayout layoutProfesor = new GridLayout(0, 3, 10,5);
        GridLayout layoutAsignatura = new GridLayout(0,2,10,5);

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
        ArrayList<JTextField> txtListaCursoAlumno = new ArrayList<>();
        ArrayList<JTextField> txtListaNiveleAlumno = new ArrayList<>();
        ArrayList<JComboBox<Asignatura>> cmbListaAsignaturasAlumno = new ArrayList<>();
        ArrayList<JTextField> txtListaTipoAlumno = new ArrayList<>();
        //DefaultListModel<Asignatura> modeloAsignaturasAlumno = new DefaultListModel<>();

        //Almacenamos los componentes de los profesores en un arrayList para luego poder manipularlos
        ArrayList<JTextField> txtListaDniProfesor = new ArrayList<>();
        ArrayList<JTextField> txtListaNombresProfesor = new ArrayList<>();
        ArrayList<JTextField> txtListaAsignaturasProfesor = new ArrayList<>();

        //Almacenamos los componentes de las asignaturas en un arrayList para luego poder manipularlos
        ArrayList<JTextField> txtListaNombreAsignatura = new ArrayList<>();
        ArrayList<JTextField> txtListaCursoAsignatura = new ArrayList<>();


        cmbOpcion.setSelectedIndex(2);

        //POR ACABAR!!!!
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String busqueda;
                busqueda = txtBuscar.getText();
                boolean encontrado = false;
                boolean mostrarMensaje = true;

                if (cmbOpcion.getSelectedIndex() == 0){
                     for (Alumno alumno : listaAlumnos){
                         if (alumno.getDni().equals(busqueda)){
                             definirLayoutPanel(layoutEstudiante);
                             mostrarEtiquetasAlumno(listaAlumnos);
                             JTextField dniAlumno = new JTextField();
                             JTextField nombreAlumno = new JTextField();
                             JTextField cursoAlumno = new JTextField();
                             JTextField nivelAlumno = new JTextField();
                             JList<Asignatura> asignaturasAlumno = new JList<Asignatura>();
                             JTextField tipoDeAlumno = new JTextField();

                             dniAlumno.setText(alumno.getDni());
                             nombreAlumno.setText(alumno.getNombre());
                             cursoAlumno.setText(String.valueOf(alumno.getCurso()));
                             nivelAlumno.setText(alumno.getNivelAcademico());
                             //asignaturasAlumno.addItem(alumno.getListaAsignaturas().get(0));
                             tipoDeAlumno.setText(alumno.getTipoDeAlumno());

                             pnlListado.add(dniAlumno);
                             pnlListado.add(nombreAlumno);
                             pnlListado.add(cursoAlumno);
                             pnlListado.add(nivelAlumno);
                             pnlListado.add(asignaturasAlumno);
                             pnlListado.add(tipoDeAlumno);

                             pnlListado.doLayout();
                             accionRealizadaMensaje();
                             mostrarMensaje = false;
                         }
                     }
                     if (mostrarMensaje){
                         noEncontradoMensaje();
                     }
                }
            }
        });

        cmbOpcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (listaAsignaturas.isEmpty() && cmbOpcion.getSelectedIndex() != 2) {
                    JOptionPane.showMessageDialog(null, "Debes añadir asignaturas.");
                    cmbOpcion.setSelectedIndex(2);
                }
                actualizarPaneles();
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


        /*
        for (Asignatura asignatura : listaAsignaturas){
            modeloAsignaturasAlumno.addElement(asignatura);
        }

         */

        //LAS ASIGNATURAS DEL ALUMNO SIGUEN SIN FUNCIONAR
        btnRecargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Dibujamos estudiantes
                if (cmbOpcion.getSelectedIndex() == 0){
                    txtBuscar.setText("Para buscar, eliminar o editar un estudiante, introduce su DNI.");

                    definirLayoutPanel(layoutEstudiante);

                    mostrarEtiquetasAlumno(listaAlumnos);

                    for (Alumno alumno : listaAlumnos){

                        //JButton botonEditar = new JButton();
                        txtListaDniAlumno.add(new JTextField());
                        txtListaNombresAlumno.add(new JTextField());
                        txtListaCursoAlumno.add(new JTextField());
                        txtListaNiveleAlumno.add(new JTextField());
                        //A cada alumno le corresponde una cmb
                        cmbListaAsignaturasAlumno.add(new JComboBox<>());
                        txtListaTipoAlumno.add(new JTextField());
                        /*
                        botonEditar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(alumno.getDni());
                            }
                        });

                         */
                    }


                    for (int contador = 0; contador < listaAlumnos.size(); contador++){ //Se añade toda la lista
                        //cmbAsignaturas, como añado las asignaturas? Puede que sea bucle con .addItem
                        pnlListado.add(txtListaDniAlumno.get(contador));
                        txtListaDniAlumno.get(contador).setText(listaAlumnos.get(contador).getDni());
                        txtListaDniAlumno.get(contador).setEditable(false);

                        pnlListado.add(txtListaNombresAlumno.get(contador));
                        txtListaNombresAlumno.get(contador).setText(listaAlumnos.get(contador).getNombre());
                        txtListaNombresAlumno.get(contador).setEditable(false);

                        pnlListado.add(txtListaCursoAlumno.get(contador));
                        txtListaCursoAlumno.get(contador).setText(String.valueOf(listaAlumnos.get(contador).getCurso()));
                        txtListaCursoAlumno.get(contador).setEditable(false);

                        pnlListado.add(txtListaNiveleAlumno.get(contador));
                        txtListaNiveleAlumno.get(contador).setText(listaAlumnos.get(contador).getNivelAcademico());
                        txtListaNiveleAlumno.get(contador).setEditable(false);

                        pnlListado.add(cmbListaAsignaturasAlumno.get(contador));
                        /*
                         Estamos añadiendo más asignaturas de las que hay
                         //cmbListaAsignaturasAlumno.get(contador).addItem(listaAlumnos.get(contador).getListaAsignaturas().get(0));
                        */
                        /*
                         Tengo que añadir tantas asignaturas como el alumno tenga:
                        */
                        for (Asignatura asignatura: listaAlumnos.get(contador).getListaAsignaturas()){
                            cmbListaAsignaturasAlumno.get(contador).addItem(asignatura);
                        }

                        pnlListado.add(txtListaTipoAlumno.get(contador));
                        txtListaTipoAlumno.get(contador).setText(listaAlumnos.get(contador).getTipoDeAlumno());
                        txtListaTipoAlumno.get(contador).setEditable(false);

                        //Así le damos la lista a este alumno, esa lista de asignaturas debe ser una lista con lo seleccionado
                        //lstListaAsignaturasAlumno.get(contador).setModel(modeloAsignaturasAlumno);

                        /*
                        Así estamos dando TODAS las asignaturas al alumno, queremos dar solo las que escoga.
                         */
                        //listaAlumnos.get(contador).setListaAsignaturas(listaAsignaturas);
                       /*
                        al cmb debemos añadirle las asignaturas que ha escogido el alumno, lista que forma parte de la
                        clase presencial
                         */

                        //Cada vez que hacemos click en recargar se incrementa el tamaño que debería ir ligado a los alumnos, está mal
                        //probamos a hacer clear
                    }
                    //Debería vaciarlo aquí
                    System.out.println("Tamaño lista txt"+txtListaDniAlumno.size());
                    txtListaDniAlumno.clear();
                    System.out.println("Tamaño lista cmb "+cmbListaAsignaturasAlumno.size());
                    cmbListaAsignaturasAlumno.clear();
                    System.out.println("Tamaño lista alumno"+listaAlumnos.size());
                    //lstListaAsignaturasAlumno.clear(); //Vaciamos la lista de componentes para evitar que se duplique
                    //Ahora no se duplica pero al añadir 2 el cmb se rompe
                    actualizarPaneles();

                    //Dibujamos profesores
                } else if (cmbOpcion.getSelectedIndex() == 1){
                    txtBuscar.setText("Para buscar, eliminar o editar un profesor, introduce su DNI.");

                    definirLayoutPanel(layoutProfesor);

                    if (!listaProfesores.isEmpty()) {
                        pnlListado.add(new JLabel("DNI"));
                        pnlListado.add(new JLabel("Nombre"));
                        pnlListado.add(new JLabel("Asignatura"));
                    }


                    for (Profesor profesor : listaProfesores){
                        txtListaDniProfesor.add(new JTextField());
                        txtListaNombresProfesor.add(new JTextField());
                        txtListaAsignaturasProfesor.add(new JTextField());
                    }

                    for (int contador = 0; contador < listaProfesores.size(); contador++){ //Se añade toda la lista
                        //cmbAsignaturas, como añado las asignaturas? Puede que sea bucle con .addItem
                        pnlListado.add(txtListaDniProfesor.get(contador));
                        txtListaDniProfesor.get(contador).setText(listaProfesores.get(contador).getDni());

                        pnlListado.add(txtListaNombresProfesor.get(contador));
                        txtListaNombresProfesor.get(contador).setText(listaProfesores.get(contador).getNombre());

                        pnlListado.add(txtListaAsignaturasProfesor.get(contador));
                        txtListaAsignaturasProfesor.get(contador).setText(listaProfesores.get(contador).getAsignatura());



                        //txtListaDni.get(contador).setEnabled(false);
                    }
                    actualizarPaneles();

                    //Dibujamos asignaturas
                } else if (cmbOpcion.getSelectedIndex() == 2){
                    txtBuscar.setText("Para buscar, eliminar o editar una asignatura, introduce su nombre.");

                    definirLayoutPanel(layoutAsignatura);

                    if (!listaAsignaturas.isEmpty()){
                        pnlListado.add(new JLabel("Nombre"));
                        pnlListado.add(new JLabel("Curso"));
                    }


                    for (Asignatura asignatura : listaAsignaturas){
                        txtListaNombreAsignatura.add(new JTextField());
                        txtListaCursoAsignatura.add(new JTextField());
                    }

                    for (int contador = 0; contador < listaAsignaturas.size(); contador++){ //Se añade toda la lista
                        //cmbAsignaturas, como añado las asignaturas? Puede que sea bucle con .addItem
                        pnlListado.add(txtListaNombreAsignatura.get(contador));
                        txtListaNombreAsignatura.get(contador).setText(listaAsignaturas.get(contador).getNombre());

                        pnlListado.add(txtListaCursoAsignatura.get(contador));
                        txtListaCursoAsignatura.get(contador).setText(String.valueOf(listaAsignaturas.get(contador).getCurso()));


                        //txtListaDni.get(contador).setEnabled(false);
                        System.out.println(listaAsignaturas.get(contador).toString());
                    }
                    actualizarPaneles();

                }


            }
        });

        //POR ACABAR!!!!!!
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda;
                busqueda = txtBuscar.getText();
                boolean mostrarMensaje = true;

                if (cmbOpcion.getSelectedIndex() == 0){
                    for (Alumno alumno : listaAlumnos){
                        if (alumno.getDni().equals(busqueda)){
                            listaAlumnos.remove(alumno);
                            accionRealizadaMensaje();
                            definirLayoutPanel(layoutEstudiante);
                            mostrarMensaje = false;
                        }
                    }
                    if (mostrarMensaje){
                        noEncontradoMensaje();
                    }
                }
            }
        });

        //FINALIZADO
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda;
                busqueda = txtBuscar.getText();
                editar(busqueda, listaAlumnos, listaAsignaturas, listaProfesores);
            }
        });

    }

    private void accionRealizadaMensaje() {
        JOptionPane.showMessageDialog(null,"Acción realizada correctamente.");
    }

    private void noEncontradoMensaje() {
        JOptionPane.showMessageDialog(null, "No se ha encontrado.");
    }

    private void editar(String busqueda, ArrayList<Alumno> listaAlumnos, ArrayList<Asignatura> listaAsignaturas, ArrayList<Profesor> listaProfesores) {

        boolean mostrarMensaje = true;

        if (cmbOpcion.getSelectedIndex() == 0){
            for (Alumno alumno : listaAlumnos){
                if (alumno.getDni().equals(busqueda)){
                    anadirEstudiante = new AnadirEstudiante(listaAlumnos, listaAsignaturas);
                    listaAlumnos.remove(alumno);
                    mostrarMensaje = false;
                }
            }
            if (mostrarMensaje){
                noEncontradoMensaje();
            }
        } else if (cmbOpcion.getSelectedIndex() == 1){
            for (Profesor profesor : listaProfesores){
                if (profesor.getDni().equals(busqueda)){
                    anadirProfesor = new AnadirProfesor(listaProfesores,listaAsignaturas);
                    listaProfesores.remove(profesor);
                    mostrarMensaje = false;
                }
            }
            if (mostrarMensaje){
                noEncontradoMensaje();
            }
        } else if (cmbOpcion.getSelectedIndex() == 2){
            for (Asignatura asignatura : listaAsignaturas){
                if (String.valueOf(asignatura.getCurso()).equals(busqueda)){
                    anadirAsignatura = new AnadirAsignatura(listaAsignaturas);
                    listaAsignaturas.remove(asignatura);
                    mostrarMensaje = false;
                }
            }
            if (mostrarMensaje){
                noEncontradoMensaje();
            }
        }
    }

    private void actualizarPaneles() {
        pnlPrincipal.doLayout();
        pnlListado.doLayout(); //Dibujamos el panel
    }

    private void mostrarEtiquetasAlumno(ArrayList<Alumno> listaAlumnos) {
        if (!listaAlumnos.isEmpty()){
            pnlListado.add(new JLabel("DNI"));
            pnlListado.add(new JLabel("Nombre"));
            pnlListado.add(new JLabel("Curso"));
            pnlListado.add(new JLabel("Nivel"));
            pnlListado.add(new JLabel("Asignaturas"));
            pnlListado.add(new JLabel("Tipo"));
        }
    }

    private void definirLayoutPanel(GridLayout layoutEstudiante) {
        pnlListado.setLayout(layoutEstudiante);
        pnlListado.removeAll(); //Antes de añadir toda la lista vaciamos el panel para evitar duplicados
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().pnlPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
