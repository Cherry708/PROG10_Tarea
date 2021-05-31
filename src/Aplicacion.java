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



        //Declaramos e instanciamos las listas que usaremos
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        //NO ERA NECESARIO INSTANCIAR pnlListado, AL HACERLO SE ¿SOBREESCRIBIA?

        //Primero se rellenan filas y luego columnas, como se soluciona???
        pnlListado.setLayout(new GridLayout(0, 7, 35,5));


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

                pnlListado.removeAll(); //Antes de añadir toda la lista vaciamos el panel para evitar duplicados

                pnlListado.add(new JLabel("DNI"));
                pnlListado.add(new JLabel("Nombre"));
                pnlListado.add(new JLabel("Curso"));
                pnlListado.add(new JLabel("Nivel académico"));
                pnlListado.add(new JLabel("Asignaturas"));
                pnlListado.add(new JLabel(""));
                pnlListado.add(new JLabel(""));


                //Almacenamos los dni de los alumnos en un arrayList de JTextField para luego poder configurarlos
                ArrayList<JTextField> txtListaDni = new ArrayList<>();
                ArrayList<JTextField> txtListaNombre = new ArrayList<>();
                ArrayList<JTextField> txtListaNivelAcademico = new ArrayList<>();
                JList lstAsignaturas = new JList();

                for (Alumno alumno : listaAlumnos){
                    txtListaDni.add(new JTextField(alumno.getDni()));
                }

                int index = 0;
                for (Alumno alumno : listaAlumnos){ //Se añade toda la lista
                    //cmbAsignaturas, como añado las asignaturas? Puede que sea bucle con .addItem
                    pnlListado.add(txtListaDni.get(index));
                    pnlListado.add(new JTextField(alumno.getNombre()));
                    pnlListado.add(new JTextField(alumno.getCurso()));
                    pnlListado.add(new JTextField(alumno.getNivelAcademico()));
                    pnlListado.add(new JList<Asignatura>());
                    pnlListado.add(new JButton("EditarNOFUNCIONA"));
                    pnlListado.add(new JButton("EliminarNOFUNCIONA"));
                    index++;

                    System.out.println(alumno.getCurso());
                    /*Los JTextField no se pueden configurar como no editables porque no se pueden declarar,
                    y al usar .setEditable(false) el tipo de dato devuelto es distinto al que queremos guardar en el
                    GridLayout. Si declaramos los JTextField no se podrán añadir nuevos componentes porque estaremos
                    sobreescribiendo los objetos
                     */

                }
                //Obtenemos el componente txt y lo configuramos
                txtListaDni.get(0).setEnabled(false);
                pnlListado.doLayout(); //Dibujamos el panel

                /*
                txtDni.setText(listaAlumnos.get(0).getDni());
                txtNombre.setText(listaAlumnos.get(0).getNombre());
                txtCurso.setText(String.valueOf(listaAlumnos.get(0).getCurso()));
                //cmbAsignaturas, como añado las asignaturas? Puede que sea bucle con .addItem

                pnlListado.add(txtDni, 0, 0);
                pnlListado.add(txtNombre, 0, 0);
                pnlListado.add(txtCurso, 0, 0);
                pnlListado.doLayout();
                */
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
