import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicacion {

    private JPanel pnlPrincipal;
    private JTextField txtBuscar;
    private JButton btnAñadir;
    private JButton btnBuscar;
    private JComboBox cmbOpcion;
    private JPanel pnlListado;

    //Ventana añadirEstudiante
    private JFrame anadirEstudiante;

    public Aplicacion(){
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
                    anadirEstudiante = new AnadirEstudiante(pnlListado);
                    //Ventana añadirEstudiante
                } else if(cmbOpcion.getSelectedIndex() == 1){
                    //Ventana añadirProfesor
                } else if(cmbOpcion.getSelectedIndex() == 2){
                    //Ventana añadirAsigntura
                }
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
