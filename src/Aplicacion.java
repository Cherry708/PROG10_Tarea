import javax.swing.*;
import javax.swing.table.TableColumn;
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

    //
    int index = 0;



    //Ventana añadirEstudiante
    private JFrame anadirEstudiante;


    public Aplicacion(){

        /*
        //Componentes de la lista de alumnos
        JTextField txtDni = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtCurso = new JTextField();
        JComboBox cmbAsignaturas = new JComboBox();
        */


        //Declaramos e instaciamos los layouts que utilizaremos
        GridLayout layoutEstudiante = new GridLayout(0,7,5,5);

        //Declaramos e instanciamos las listas de alumnos, profesores y asignaturas
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        ArrayList<Profesor> listaProfesores = new ArrayList<>();
        ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();

        //Declaramos e instanciamos las listas de los componentes de los objetos alumnos, profesores y asignaturas
        /*
        Alumnos
         */
        //Almacenamos los datos de los alumnos en un arrayList para luego poder manipularlos
        ArrayList<JTextField> txtListaDni = new ArrayList<>();
        ArrayList<JTextField> txtListaNombres = new ArrayList<>();
        ArrayList<JTextField> txtListaCursos = new ArrayList<>();
        ArrayList<JTextField> txtListaNivelesAcademicos = new ArrayList<>();
        ArrayList<JComboBox> cmbListaAsignaturas = new ArrayList<>();
        ArrayList<JButton> btnListaBotonesEditar = new ArrayList<>();
        ArrayList<JButton> btnListaBotonesBorrar = new ArrayList<>();



        /* Ejemplo de listeners para los botones creados en tiempo de ejecución
        btnListaBotonesBorrar.get(contador).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
         */

        //NO ERA NECESARIO INSTANCIAR pnlListado, AL HACERLO SE ¿SOBREESCRIBIA?

        //Primero se rellenan filas y luego columnas, como se soluciona???
        pnlListado.setLayout(new GridLayout(0, 7, 5,5));


        // Añadir componente
        /* Añadir componente
        JTextField textField = new JTextField();
        textField.setText("Texto");
        pnlListado.add(textField, 0, 0);
         */

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
                if (cmbOpcion.getSelectedIndex() == 0){
                    //AñadirEstudiante hereda de JDialog
                    //Instanciamos AñadirEstudiante
                    //El parámetro de entrada debe ser un arraylist de alumnos
                    anadirEstudiante = new AnadirEstudiante(listaAlumnos);

                    //Ventana añadirEstudiante
                } else if(cmbOpcion.getSelectedIndex() == 1){
                    //Ventana añadirProfesor
                } else if(cmbOpcion.getSelectedIndex() == 2){
                    //Ventana añadirAsigntura
                }
            }
        });



        /*
        btnRecargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pnlListado.add(new JButton("Boton"));
                pnlListado.setBackground(new Color(255));
                System.out.println("Entrado");
            }
        });
         */

        /*
        Al pulsar dos veces se volverán a añadir los mismos componentes? No parece
        Bucle que recorra la lista y añada los componentes
         */
        btnRecargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Si cmbOpcion == 0
                pnlListado.setLayout(layoutEstudiante);

                pnlListado.removeAll(); //Antes de añadir toda la lista vaciamos el panel para evitar duplicados

                pnlListado.add(new JLabel("DNI"));
                pnlListado.add(new JLabel("Nombre"));
                pnlListado.add(new JLabel("Curso"));
                pnlListado.add(new JLabel("Nivel académico"));
                pnlListado.add(new JLabel("Asignaturas"));
                pnlListado.add(new JLabel(""));
                pnlListado.add(new JLabel(""));



                for (Alumno alumno : listaAlumnos){
                    txtListaDni.add(new JTextField(alumno.getDni()));
                    txtListaNombres.add(new JTextField(alumno.getNombre()));
                    txtListaCursos.add(new JTextField(alumno.getCurso()));
                    txtListaNivelesAcademicos.add(new JTextField(alumno.getNivelAcademico()));
                    //cmbListaAsignaturas.add(new JComboBox(alumno.getListaAsignaturas()));
                    btnListaBotonesEditar.add(new JButton("Editar"));
                    btnListaBotonesBorrar.add(new JButton("Borrar"));
                }

                for (Alumno alumno : listaAlumnos){ //Se añade toda la lista
                    //cmbAsignaturas, como añado las asignaturas? Puede que sea bucle con .addItem
                    pnlListado.add(txtListaDni.get(index));
                    pnlListado.add(txtListaNombres.get(index));
                    pnlListado.add(txtListaCursos.get(index));
                    pnlListado.add(txtListaNivelesAcademicos.get(index));
                    pnlListado.add(new JComboBox<>());
                    pnlListado.add(btnListaBotonesEditar.get(index));
                    pnlListado.add(btnListaBotonesBorrar.get(index));

                    //Obtenemos el componente txt y lo configuramos
                    txtListaDni.get(index).setEnabled(false);
                    index++;

                    System.out.println(alumno.getCurso());

                }
                pnlPrincipal.doLayout();
                pnlListado.doLayout(); //Dibujamos el panel



            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().pnlPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
