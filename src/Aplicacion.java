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

    //Ventana añadirEstudiante
    private JFrame anadirEstudiante;

    public Aplicacion(){

        //Componentes de la lista de alumnos
        JTextField txtDni = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtCurso = new JTextField();
        JComboBox cmbAsignaturas = new JComboBox();


        //Declaramos e instanciamos las listas que usaremos
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        //NO ERA NECESARIO INSTANCIARLO, AL HACERLO SE ¿SOBREESCRIBIA?
        int filas = 10;
        int columnas = 5;
        GridLayout layout = new GridLayout();
        layout.setRows(filas);
        layout.setColumns(columnas);
        pnlListado.setLayout(layout);

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
                txtDni.setText(listaAlumnos.get(0).getDni());
                txtNombre.setText(listaAlumnos.get(0).getNombre());
                txtCurso.setText(String.valueOf(listaAlumnos.get(0).getCurso()));
                //cmbAsignaturas
                pnlListado.add(txtDni, 0);
                pnlListado.add(txtNombre, 1, 0);
                pnlListado.add(txtCurso, 2, 0);

                pnlListado.doLayout();
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
