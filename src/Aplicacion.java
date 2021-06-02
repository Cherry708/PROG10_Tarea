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
        GridLayout layoutEstudiante = new GridLayout(0,5,10,5);
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
        ArrayList<JTextField> txtListaCursosAlumno = new ArrayList<>();
        ArrayList<JTextField> txtListaNivelesAcademicosAlumno = new ArrayList<>();
        ArrayList<JList<Asignatura>> lstListaAsignaturasAlumno = new ArrayList<>();
        DefaultListModel<Asignatura> modeloAsignaturasAlumno = new DefaultListModel<>();

        //Almacenamos los componentes de los profesores en un arrayList para luego poder manipularlos
        ArrayList<JTextField> txtListaDniProfesor = new ArrayList<>();
        ArrayList<JTextField> txtListaNombresProfesor = new ArrayList<>();
        ArrayList<JTextField> txtListaAsignaturasProfesor = new ArrayList<>();

        //Almacenamos los componentes de las asignaturas en un arrayList para luego poder manipularlos
        ArrayList<JTextField> txtListaNombreAsignatura = new ArrayList<>();
        ArrayList<JTextField> txtListaCursoAsignatura = new ArrayList<>();


        cmbOpcion.setSelectedIndex(2);

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

                             dniAlumno.setText(alumno.getDni());
                             nombreAlumno.setText(alumno.getNombre());
                             cursoAlumno.setText(String.valueOf(alumno.getCurso()));
                             nivelAlumno.setText(alumno.getNivelAcademico());
                             //asignaturasAlumno.addItem(alumno.getListaAsignaturas().get(0));

                             pnlListado.add(dniAlumno);
                             pnlListado.add(nombreAlumno);
                             pnlListado.add(cursoAlumno);
                             pnlListado.add(nivelAlumno);
                             pnlListado.add(asignaturasAlumno);

                             pnlListado.doLayout();
                             JOptionPane.showMessageDialog(null,"Se ha encontrado.");
                             //Es necesario???
                             txtBuscar.setText("Para buscar, eliminar o editar un estudiante, introduce su DNI.");
                             encontrado = true;
                             mostrarMensaje = false;
                         }
                     }
                     if (mostrarMensaje){
                         JOptionPane.showMessageDialog(null,"No se ha encontrado.");
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



        for (Asignatura asignatura : listaAsignaturas){
            modeloAsignaturasAlumno.addElement(asignatura);
        }

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
                        txtListaCursosAlumno.add(new JTextField());
                        txtListaNivelesAcademicosAlumno.add(new JTextField());
                        //A cada alumno le corresponde una cmb
                        lstListaAsignaturasAlumno.add(new JList<>());
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

                        pnlListado.add(txtListaNombresAlumno.get(contador));
                        txtListaNombresAlumno.get(contador).setText(listaAlumnos.get(contador).getNombre());

                        pnlListado.add(txtListaCursosAlumno.get(contador));
                        txtListaCursosAlumno.get(contador).setText(String.valueOf(listaAlumnos.get(contador).getCurso()));

                        pnlListado.add(txtListaNivelesAcademicosAlumno.get(contador));
                        txtListaNivelesAcademicosAlumno.get(contador).setText(listaAlumnos.get(contador).getNivelAcademico());

                        //Dibujamos el cmb de cada alumno
                        pnlListado.add(lstListaAsignaturasAlumno.get(contador));
                        //CADA VEZ PULSAS RECARGAR SE AÑADE OTRA VEZ
                        //cmbListaAsignaturasAlumno.get(contador).addItem(listaAlumnos.get(contador).getListaAsignaturas().get(contador));


                        //Así le damos la lista a este alumno, esa lista de asignaturas debe ser una lista con lo seleccionado
                        lstListaAsignaturasAlumno.get(contador).setModel(modeloAsignaturasAlumno);

                        /*
                        Así estamos dando TODAS las asignaturas al alumno, queremos dar solo las que escoga.
                         */
                        //listaAlumnos.get(contador).setListaAsignaturas(listaAsignaturas);
                       /*
                        al cmb debemos añadirle las asignaturas que ha escogido el alumno, lista que forma parte de la
                        clase presencial
                         */



                        //txtListaDni.get(contador).setEnabled(false);
                    }
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
                    txtBuscar.setText("Para buscar, eliminar o editar una asignatura, introduce su curso.");

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
                            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente.");
                            definirLayoutPanel(layoutEstudiante);
                            mostrarMensaje = false;
                        }
                    }
                    if (mostrarMensaje){
                        JOptionPane.showMessageDialog(null, "No se ha encontrado.");
                    }
                }
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

    private void editar(String busqueda, ArrayList<Alumno> listaAlumnos, ArrayList<Asignatura> listaAsignaturas, ArrayList<Profesor> listaProfesores) {
        if (cmbOpcion.getSelectedIndex() == 0){
            for (Alumno alumno : listaAlumnos){
                if (alumno.getDni().equals(busqueda)){
                    anadirEstudiante = new AnadirEstudiante(listaAlumnos, listaAsignaturas);
                    listaAlumnos.remove(alumno);
                }
            }
        } else if (cmbOpcion.getSelectedIndex() == 1){
            for (Profesor profesor : listaProfesores){
                if (profesor.getDni().equals(busqueda)){
                    anadirProfesor = new AnadirProfesor(listaProfesores,listaAsignaturas);
                    listaProfesores.remove(profesor);
                }
            }
        } else if (cmbOpcion.getSelectedIndex() == 2){
            for (Asignatura asignatura : listaAsignaturas){
                if (String.valueOf(asignatura.getCurso()).equals(busqueda)){
                    anadirAsignatura = new AnadirAsignatura(listaAsignaturas);
                    listaAsignaturas.remove(asignatura);
                }
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
            pnlListado.add(new JLabel("Nivel académico"));
            pnlListado.add(new JLabel("Asignaturas"));
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
