import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        //NO ERA NECESARIO INSTANCIARLO, AL HACERLO SE ¿SOBREESCRIBIA?
        pnlListado.setLayout(new GridLayout(10,5));

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
        });
        btnAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (cmbOpcion.getSelectedIndex() == 0){
                    //AñadirEstudiante hereda de JDialog
                    //Instanciamos AñadirEstudiante
                    //El parámetro de entrada debe ser un arraylist de alumnos
                    anadirEstudiante = new AnadirEstudiante(pnlListado);
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
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().pnlPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
